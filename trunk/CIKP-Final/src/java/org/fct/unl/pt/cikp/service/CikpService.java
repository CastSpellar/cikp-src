/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.portal.UserPortal;

/**
 *
 * @author Bruno
 */
public interface CikpService {

    /* Methods for the Portal User */

    public boolean existsUser(UserPortal u) ;

    public void updateUser(UserPortal u) ;

    public UserPortal authenticateUser(UserPortal u) ;

    public UserPortal registerUser(UserPortal u) ;


    /**
     Ontology Methods
     */
    public IndividualActor createIndividualActor(IndividualActor actor) ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item) ;

    public ArrayList<String> listKnowledges() ;

    public void createXMLTree(String filename, String cls) ;

    public AttributeControl getAttributeControl(String attributeName) ;
}
