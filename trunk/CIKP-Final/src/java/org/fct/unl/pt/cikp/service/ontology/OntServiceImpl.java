
package org.fct.unl.pt.cikp.service.ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private static String configFilePath = "c:/config.xml" ;

    private PersistentOntology po ;

    private static String namespace = ("http://www.jinyuezhang.com/work/ontology/Actor.owl#") ;

    public OntServiceImpl() {}

    public void createIndividual(String entitytype, String entityname) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(entitytype) ;
        getPo().getModel().createIndividual(namespace + entityname, c) ;
        return ;
    }

    public Property getProperty(String propName) throws IOException, MissingParamException, ClassNotFoundException {
        return getPo().getModel().getProperty(namespace + propName) ;
    }

    public OntClass getClass(String clsName) throws IOException, MissingParamException, ClassNotFoundException {
        return getPo().getModel().getOntClass(namespace + clsName) ;
    }

    public Individual getIndividual(String indName) throws IOException, MissingParamException, ClassNotFoundException {
        return getPo().getModel().getIndividual(namespace + indName) ;
    }

    public String getIndividualLocalName(String indName) throws IOException, MissingParamException, ClassNotFoundException {
        return getIndividual(indName).getLocalName() ;
    }

    public String getIndividualURI(String indName) throws IOException, MissingParamException, ClassNotFoundException {
        return getIndividual(indName).getURI() ;
    }

    public void addLiteralByProperty(String prop, String entityname, Object value) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname) ;
        Property pr = getProperty(prop) ;
        getPo().getModel().addLiteral(ind, pr, value) ;
    }

    public String getIndividualClass(String indName) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(indName) ;
        return ind.getOntClass().getLocalName() ;
    }

    public ArrayList getIndividualByPropertyValue(String prop, Object value) throws IOException, MissingParamException, ClassNotFoundException {
        ExtendedIterator iter = getPo().getModel().listIndividuals() ;
        ArrayList<String> aux = new ArrayList<String>() ;
        Property pr = getProperty(prop) ;
        Object obj = null ;
        while (iter.hasNext()) {
            Individual ind = (Individual) iter.next() ;

            Literal lit = (Literal) ind.getPropertyValue(pr) ;
            if(!lit.equals(obj)){
                if(getLiteralByProperty(ind.getLocalName(), prop).equals(value)) {
                    aux.add(ind.getLocalName()) ;
                }
            }
        }
        return aux ;
    }

    public void addIndividualToClass(String cls, String entityname) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname) ;
        OntClass c = getClass(cls) ;
        ind.addOntClass(c);
    }


    public Object getLiteralByProperty(String entityname, String prop) throws IOException, MissingParamException, ClassNotFoundException {
        Individual ind = getIndividual(entityname) ;
        Property pr = getProperty(prop) ;
        Literal lit = (Literal) ind.getPropertyValue(pr) ;
        return lit.getValue() ;
    }

    public void listAllInstancesOfClass(ArrayList<String> list, String cls) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls) ;
        ExtendedIterator iter = getPo().getModel().listIndividuals(c) ;
        while(iter.hasNext()) {
            Individual instance = (Individual)iter.next() ;
            list.add(instance.getLocalName());
        }
        iter = c.listSubClasses(false) ;
        while (iter.hasNext()) {
            OntClass subC = (OntClass)iter.next() ;
            listAllInstancesOfClass(list, subC.getLocalName());
        }
    }

    public ArrayList listDirectSubClasses(String cls) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls) ;
        ArrayList<String> clsArray = new ArrayList<String>() ;
        for (ExtendedIterator iter = c.listSubClasses() ; iter.hasNext(); ) {
            OntClass aux = (OntClass) iter.next() ;
            clsArray.add(aux.getLocalName());
        }
        return clsArray ;
    }

    public void listAbsoluteSubClasses(ArrayList<String> list, ArrayList<Integer> hierarchy, int counter, String cls, boolean bool) throws IOException, MissingParamException, ClassNotFoundException {
        OntClass c = getClass(cls) ;
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
                listAbsoluteSubClasses(list, hierarchy, counter, auxc.getLocalName(), true) ;
            }
        }
    }

    public void createXMLFileXTree(String fileName, String supercls) throws MissingParamException, ClassNotFoundException {

        String ENCODING = "ISO-8859-1" ;

        try {
            File f = new File(fileName) ;
            f.createNewFile() ;
            PrintWriter out = new PrintWriter(new FileOutputStream(f)) ;
            out.println("<?xml version=\"1.0\" encoding=\""+ENCODING+"\"?>");
            out.println("<tree id=\"0\" radio=\"1\">");
            out.flush() ;
            ArrayList<String> list = new ArrayList<String>() ;
            OntClass cls = getClass(supercls) ;
            writeClassesXTree(cls, new ArrayList<OntClass>(), 0, out) ;
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

    private void writeClassesXTree(OntClass cls, ArrayList<OntClass> occurs, int depth, PrintWriter out){
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

    /**
     * @return the po
     */
    public PersistentOntology getPo() throws IOException, MissingParamException, ClassNotFoundException  {
        po = new PersistentOntologyImpl() ;
        po.setS_reload(false) ;
        po.setConfigFilePath(configFilePath) ;
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(PersistentOntology po) {
        this.po = po;
    }

    public OntModel getM() throws IOException, MissingParamException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
