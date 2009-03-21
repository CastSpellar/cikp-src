/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.portal.User;

/**
 *
 * @author Bruno
 */
public interface CikpService {

    /* Methods for the Portal User */

    public boolean existsUser(User u) ;

    public void updateUser(User u) ;

    public User authenticateUser(User u) ;

    public User registerUser(User u) ;


    /**
     Ontology Methods
     */
    public IndividualActor createIndividualActor(IndividualActor actor) ;

    public ArrayList<String> listKnowledges() ;

    public void createXMLTree(String filename, String cls) ;
}
