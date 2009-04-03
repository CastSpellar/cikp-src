/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology.manager;

import com.hp.hpl.jena.ontology.OntModel;
import java.io.OutputStream;

/**
 *
 * @author Bruno
 */
public interface PersistentOntology {

    public void load() ;

     public void writeOnt(OutputStream out) ;

    public void createXMLFile(String fileName) ;

    public void createXMLFileXTree(String fileName) ;

    public OntModel getModel() ;
    
    public void setS_reload(boolean s_reload) ;

    public void closeCon() ;

    public void reopenCon() ;

}
