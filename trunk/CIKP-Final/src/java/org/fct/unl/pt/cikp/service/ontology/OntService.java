/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Property;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Bruno
 */
public interface OntService {

    public void createIndividual(String entitytype, String entityname, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public Property getProperty(String propName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public OntClass getClass(String clsName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public Individual getIndividual(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public String getIndividualLocalName(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public String getIndividualURI(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public void addLiteralByProperty(String prop, String entityname, Object value, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public String getIndividualClass(String indName, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public ArrayList getIndividualByPropertyValue(String prop, Object value, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public void addIndividualToClass(String cls, String entityname, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public Object getLiteralByProperty(String entityname, String prop, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public void listAllInstancesOfClass(ArrayList<String> list, String cls, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public ArrayList listDirectSubClasses(String cls, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public void createXMLFileXTree(String fileName, String supercls, PersistentOntology p) throws MissingParamException, ClassNotFoundException ;

    public void listAbsoluteSubClasses(ArrayList<String> list, ArrayList<Integer> hierarchy, int counter, String cls, boolean bool, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException ;

    public void writeOnt(OutputStream out, PersistentOntology p) ;

    public OntModel getM() throws IOException, MissingParamException, ClassNotFoundException ;

}
