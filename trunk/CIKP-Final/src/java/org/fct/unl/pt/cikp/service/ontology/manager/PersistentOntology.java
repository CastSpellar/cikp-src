/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology.manager;

import com.hp.hpl.jena.ontology.OntModel;
import java.io.IOException;
import java.io.OutputStream;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Bruno
 */
public interface PersistentOntology {

    public void writeOnt(OutputStream out) ;

    public void createXMLFile(String fileName) ;

    public void createXMLFileXTree(String fileName) ;

    public OntModel getModel() ;
    
    public void setConfigFilePath(String configFilePath) throws IOException, MissingParamException, ClassNotFoundException ;

    public void setS_reload(boolean s_reload) ;

}
