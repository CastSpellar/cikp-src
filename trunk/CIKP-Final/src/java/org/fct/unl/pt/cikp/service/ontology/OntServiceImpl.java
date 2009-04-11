
package org.fct.unl.pt.cikp.service.ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */
public class OntServiceImpl implements OntService {

    private String configFilePath = "C:/config.xml" ;


    /**
     * @return the configFilePath
     */
    public String getConfigFilePath() {
        return configFilePath;
    }

    /**
     * @param aConfigFilePath the configFilePath to set
     */
    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    private PersistentOntology po ;

    private static String namespace = ("http://www.jinyuezhang.com/work/ontology/Actor.owl#") ;

    public OntServiceImpl() {}

    public void createIndividual(String entitytype, String entityname, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(entitytype, p) ;
        p.getModel().createIndividual(namespace + entityname, c) ;
        return ;
    }

    public Property getProperty(String propName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        return p.getModel().getProperty(namespace + propName) ;
    }

    public OntClass getClass(String clsName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        return p.getModel().getOntClass(namespace + clsName) ;
    }

    public Individual getIndividual(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        return p.getModel().getIndividual(namespace + indName) ;
    }

    public String getIndividualLocalName(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        return getIndividual(indName, p).getLocalName() ;
    }

    public String getIndividualURI(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        return getIndividual(indName, p).getURI() ;
    }

    public void addLiteralByProperty(String prop, String entityname, Object value, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname, p) ;
        Property pr = getProperty(prop, p) ;
        p.getModel().addLiteral(ind, pr, value) ;
    }

    public void removeLiteralByProperty(String prop, String entityname, PersistentOntology p, Object oldValue) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname, p) ;
        Property pr = getProperty(prop, p) ;
        Literal lit = ind.getProperty(pr).getLiteral() ;
        p.getModel().removeAll(ind, pr, lit);
        return ;
    }

    public String getIndividualClass(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(indName, p) ;
        return ind.getOntClass().getLocalName() ;
    }

    public ArrayList getIndividualByPropertyValue(String prop, Object value, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        ExtendedIterator iter = p.getModel().listIndividuals() ;
        ArrayList<String> aux = new ArrayList<String>() ;
        Property pr = getProperty(prop, p) ;
        Object obj = null ;
        while (iter.hasNext()) {
            Individual ind = (Individual) iter.next() ;

            Literal lit = (Literal) ind.getPropertyValue(pr) ;
            if(!lit.equals(obj)){
                if(getLiteralByProperty(ind.getLocalName(), prop, p).equals(value)) {
                    aux.add(ind.getLocalName()) ;
                }
            }
        }
        return aux ;
    }

    public void addIndividualToClass(String cls, String entityname, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname, p) ;
        OntClass c = getClass(cls, p) ;
        ind.addOntClass(c);
    }


    public Object getLiteralByProperty(String entityname, String prop, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname, p) ;
        Property pr = getProperty(prop, p) ;
        Literal lit = (Literal) ind.getPropertyValue(pr) ;
        if(lit == null)
            return null ;
        else
            return lit.getValue() ;
    }

    public void listAllInstancesOfClass(ArrayList<String> list, String cls, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls, p) ;
        ExtendedIterator iter = p.getModel().listIndividuals(c) ;
        while(iter.hasNext()) {
            Individual instance = (Individual)iter.next() ;
            list.add(instance.getLocalName());
        }
        iter = c.listSubClasses(false) ;
        while (iter.hasNext()) {
            OntClass subC = (OntClass)iter.next() ;
            listAllInstancesOfClass(list, subC.getLocalName(), p);
        }
    }

    public ArrayList listDirectSubClasses(String cls, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls, p) ;
        ArrayList<String> clsArray = new ArrayList<String>() ;
        for (ExtendedIterator iter = c.listSubClasses() ; iter.hasNext(); ) {
            OntClass aux = (OntClass) iter.next() ;
            clsArray.add(aux.getLocalName());
        }
        return clsArray ;
    }

    public void listAbsoluteSubClasses(ArrayList<String> list, ArrayList<Integer> hierarchy, int counter, String cls, boolean bool, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls, p) ;
        if (!bool) {
            bool = true ;
        }
        else {
            list.add(c.getLocalName());
            hierarchy.add(counter);
            counter++ ;
        }
        ExtendedIterator iter = c.listSubClasses() ;
        if(iter.hasNext()){
            while ( iter.hasNext() ) {
                OntClass auxc = (OntClass) iter.next() ;
                listAbsoluteSubClasses(list, hierarchy, counter, auxc.getLocalName(), true, p) ;
            }
        }
    }

    public void createXMLFileXTree(String fileName, String supercls, PersistentOntology p) throws MissingParamException, ClassNotFoundException {

        String ENCODING = "ISO-8859-1" ;

        try {
            File f = new File(fileName) ;
            f.createNewFile() ;
            PrintWriter out = new PrintWriter(new FileOutputStream(f)) ;
            out.println("<?xml version=\"1.0\" encoding=\""+ENCODING+"\"?>");
            out.println("<tree id=\"0\" radio=\"1\">");
            out.flush() ;
            ArrayList<String> list = new ArrayList<String>() ;
            OntClass cls = getClass(supercls, p) ;
            writeClassesXTree(cls, new ArrayList<OntClass>(), 0, out, p) ;
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

    private void writeClassesXTree(OntClass cls, ArrayList<OntClass> occurs, int depth, PrintWriter out, PersistentOntology p){
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
                        writeClassesXTree(sub, occurs, depth + 1, out, p) ;
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

    public OntModel getM() throws IOException, MissingParamException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void writeOnt(OutputStream out, PersistentOntology p) {
        p.writeOnt(out);
    }
}
