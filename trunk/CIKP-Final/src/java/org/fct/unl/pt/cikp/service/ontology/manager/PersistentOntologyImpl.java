package org.fct.unl.pt.cikp.service.ontology.manager;
/**
 *
 * @author Figueiras
 */

import java.io.*;
import com.hp.hpl.jena.db.*;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersistentOntologyImpl implements PersistentOntology {

    private HashMap<String, String> params = new HashMap<String, String>() ;

    private String s_params[] = {"ont_file", "db_url", "db_user", "db_passwd", "db", "db_driver"} ;
    private String s_dbURL ;
    private String s_dbUser ;
    private String s_dbPw = "" ;
    private String s_dbType ;
    private String s_dbDriver ;
    private static String ns = ("http://www.jinyuezhang.com/work/ontology/Actor.owl#") ;

    // if true, reload the data
    private boolean s_reload ;

    // source URL to load data from; if null, use default
    private String s_source;
    
    private String configFilePath ;

    private ModelMaker maker ;

    private OntModel m ;

    private void loadConfigParams() throws MissingParamException, IOException, ClassNotFoundException {
        DOMParser domp = new DOMParser();
        try {
            domp.parse(getConfigFilePath());
            Document doc = domp.getDocument() ;
            Element root = doc.getDocumentElement() ;
            for(String param: s_params){
                NodeList paramNode = root.getElementsByTagName(param) ;
                if(paramNode != null){
                    Element el = (Element) paramNode.item(0) ;
                    String paramVal = el.getFirstChild().getNodeValue() ;
                    if(paramVal != null)
                        params.put(param, paramVal) ;
                    else
                        throw new MissingParamException("Ficheiro de configuração incompleto.") ;
                }
            }
            s_source = params.get(s_params[0]) ;
            s_dbURL = params.get(s_params[1]) ;
            s_dbUser = params.get(s_params[2]) ;
            s_dbPw = params.get(s_params[3]) ;
            s_dbType = params.get(s_params[4]) ;
            s_dbDriver = params.get(s_params[5]) ;
            Class.forName( s_dbDriver );
        } catch (SAXException ex) {
            Logger.getLogger(PersistentOntologyImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1) ;
        } 
    }

    private void loadMaker() {
         if (isS_reload()) {

            // we pass cleanDB=true to clear out existing models
            // NOTE: this will remove ALL Jena models from the named persistent store, so
            // use with care if you have existing data stored
            maker = getRDBMaker( s_dbURL, s_dbUser, s_dbPw, s_dbType, true );

            // now load the source data into the newly cleaned db
            loadDB( maker, s_source );
            s_reload = false ;
        }

        // now we list the classes in the database, to show that the persistence worked
        maker = getRDBMaker( s_dbURL, s_dbUser, s_dbPw, s_dbType, false );

        Model base = maker.createModel( s_source, false );

        m = ModelFactory.createOntologyModel( getModelSpec( maker ), base );
    }

    private void loadDB( ModelMaker maker, String source ) {
        // use the model maker to get the base model as a persistent model
        // strict=false, so we get an existing model by that name if it exists
        // or create a new one
        Model base = maker.createModel( source, false );

        // now we plug that base model into an ontology model that also uses
        // the given model maker to create storage for imported models
        m = ModelFactory.createOntologyModel( getModelSpec( maker ), base );

        InputStream in = FileManager.get().open( source );
        if (in == null) {
            throw new IllegalArgumentException(
                                         "File: " + source + " not found");
        }

        // now load the source document, which will also load any imports
        m.read( in,  "" );
    }
    public void writeOnt() {

    }

    public void createXMLFile(String fileName) {
        Model base = maker.createModel( s_source, false ) ;
        OntModel m = ModelFactory.createOntologyModel( getModelSpec( maker ), base ) ;
        String ENCODING = "ISO-8859-1" ;
        
        try {
            File f = new File(fileName) ;
            f.createNewFile() ;
            PrintWriter out = new PrintWriter(new FileOutputStream(f)) ;
            out.println("<?xml version=\"1.0\" encoding=\""+ENCODING+"\"?>");
            out.println("<Ontology-Hierarchy>");
            out.flush() ;
            ExtendedIterator i = m.listHierarchyRootClasses() ;
            i.filterDrop( new Filter() {
                public boolean accept( Object o ) {
                    return ((Resource) o).isAnon();
                }} );

            while (i.hasNext()) {
                OntClass cls = (OntClass) i.next() ;
                writeClasses(cls, new ArrayList<OntClass>(), 0, out) ;
            }
            /*
              out.println("<USER ID=\""+id[i]+"\" TYPE=\""+type[i]+"\">"+desc[i]+"</USER>");
            }*/
            out.println("</Ontology-Hierarchy>");
            out.flush() ;
            out.close() ;
        } catch (IOException ex) {
            Logger.getLogger(PersistentOntologyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeClasses(OntClass cls, List<OntClass> occurs, int depth, PrintWriter out){
        if((!cls.isRestriction()) && (!cls.isAnon())) {
            for(int i = 0; i < depth + 1; i++){
                out.print("\t") ;
            }
            out.println("<" + cls.getLocalName() + ">") ;
            out.flush() ;
            // recurse to the next level down
            if (cls.canAs( OntClass.class )  &&  !occurs.contains( cls )) {
                ExtendedIterator i = cls.listSubClasses(true) ;
                while(i.hasNext()) {
                    OntClass sub = (OntClass) i.next();

                    // we push this expression on the occurs list before we recurse
                    occurs.add( cls );
                    writeClasses(sub, occurs, depth + 1, out) ;
                    occurs.remove( cls );
                }
            }
            for(int i = 0; i < depth + 1; i++){
                out.print("\t") ;
            }
            out.println("</" + cls.getLocalName() + ">") ;
        }
    }


    private ModelMaker getRDBMaker( String dbURL, String dbUser, String dbPw, String dbType, boolean cleanDB ) {
        try {
            // Create database connection
            IDBConnection conn  = new DBConnection( dbURL, dbUser, dbPw, dbType );

            // do we need to clean the database?
            if (cleanDB) {
                conn.cleanDB();
            }

            // Create a model maker object
            return ModelFactory.createModelRDBMaker( conn );
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit( 1 );
        }

        return null;
    }

    public OntModelSpec getModelSpec( ModelMaker maker ) {
        // create a spec for the new ont model that will use no inference over models
        // made by the given maker (which is where we get the persistent models from)
        OntModelSpec spec = new OntModelSpec( OntModelSpec.OWL_MEM );
        spec.setImportModelMaker( maker );

        return spec;
    }

    public void createXMLFileXTree(String fileName) {
        Model base = maker.createModel( s_source, false ) ;
        OntModel m = ModelFactory.createOntologyModel( getModelSpec( maker ), base ) ;
        String ENCODING = "ISO-8859-1" ;

        try {
            File f = new File(fileName) ;
            f.createNewFile() ;
            PrintWriter out = new PrintWriter(new FileOutputStream(f)) ;
            out.println("<?xml version=\"1.0\" encoding=\""+ENCODING+"\"?>");
            out.println("<tree id=\"0\" radio=\"1\">");
            out.flush() ;
            ExtendedIterator i = m.listHierarchyRootClasses() ;
            i.filterDrop( new Filter() {
                public boolean accept( Object o ) {
                    return ((Resource) o).isAnon();
                }} );

            while (i.hasNext()) {
                OntClass cls = (OntClass) i.next() ;
                writeClassesXTree(cls, new ArrayList<OntClass>(), 0, out) ;
            }
            /*
              out.println("<USER ID=\""+id[i]+"\" TYPE=\""+type[i]+"\">"+desc[i]+"</USER>");
            }*/
            out.println("</tree>");
            out.flush() ;
            out.close() ;
        } catch (IOException ex) {
            Logger.getLogger(PersistentOntologyImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeClassesXTree(OntClass cls, List<OntClass> occurs, int depth, PrintWriter out){
        boolean writeTerm = true ;
        if((!cls.isRestriction()) && (!cls.isAnon())) {
            for(int i = 0; i < depth + 1; i++){
                out.print("\t") ;
            }
            out.flush() ;
            // recurse to the next level down
            if (cls.canAs( OntClass.class )  &&  !occurs.contains( cls )) {
                ExtendedIterator i = cls.listSubClasses(true) ;
                if(i.hasNext()) {
                    out.println("<item text=\"" + cls.getLocalName() + "\" id=\"" + cls.getURI() + "\" im0=\"Class.ico\" im1=\"Class.ico\" im2=\"Class.ico\">") ;
                    while(i.hasNext()) {
                        OntClass sub = (OntClass) i.next();

                        // we push this expression on the occurs list before we recurse
                        occurs.add( cls );
                        writeClassesXTree(sub, occurs, depth + 1, out) ;
                        occurs.remove( cls );
                    }
                }
                else {
                    out.println("<item text=\"" + cls.getLocalName() + "\" id=\"" + cls.getURI() + "\" im0=\"Class.ico\" im1=\"Class.ico\" im2=\"Class.ico\" />") ;
                    writeTerm = false ;
                }
            }
            if(writeTerm) {
                for(int i = 0; i < depth + 1; i++){
                    out.print("\t") ;
                }
                out.println("</item>") ;
            }
        }


    }

    public OntModel getModel() {
        return m ;
    }

    /**
     * @return the s_reload
     */
    public boolean isS_reload() {
        return s_reload;
    }

    /**
     * @param s_reload the s_reload to set
     */
    public void setS_reload(boolean s_reload) {
        this.s_reload = s_reload;
    }

    /**
     * @return the configFilePath
     */
    public String getConfigFilePath() {
        return configFilePath;
    }

    /**
     * @param configFilePath the configFilePath to set
     */
    public void setConfigFilePath(String configFilePath) throws IOException, MissingParamException, ClassNotFoundException {
        this.configFilePath = configFilePath;
        loadConfigParams() ;
        loadMaker();
    }
}
