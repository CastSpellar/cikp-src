/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.util.ArrayList;
import java.util.List;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortalImpl;
import org.fct.unl.pt.cikp.data.portal.UserService;
import org.fct.unl.pt.cikp.data.portal.UserServiceImpl;

/**
 *
 * @author Bruno
 */
public class CikpServiceImpl implements CikpService {

    private UserService userService ;
    private OntServicePortal ontServicePortal ;

    /**
     * @param userService the userService to set
     */
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return new UserServiceImpl() ;
    }

    public void updateUser(UserPortal u) {
        getUserService().updateUser(u);
    }

    public boolean existsUser(UserPortal u) {
        return getUserService().existsUserName(u) ;
    }

    public UserPortal authenticateUser(UserPortal u) {
        return getUserService().authenticateUser(u) ;
    }

    public UserPortal registerUser(UserPortal u) {
        return getUserService().register(u) ;
    }

    public IndividualActor createIndividualActor(IndividualActor actor) {
        return getOntServicePortal().createIndividualActor(actor) ;
    }

    /**
     * @return the ontServicePortal
     */
    public OntServicePortal getOntServicePortal() {
        return new OntServicePortalImpl() ;
    }

    /**
     * @param ontServicePortal the ontServicePortal to set
     */
    public void setOntServicePortal(OntServicePortal ontServicePortal) {
        this.ontServicePortal = ontServicePortal;
    }

    public ArrayList<String> listKnowledges() {
        return getOntServicePortal().listKnowledges() ;
    }

    public void createXMLTree(String filename, String cls) {
        getOntServicePortal().createXMLTree(filename, cls);
    }

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item) {
        return getOntServicePortal().createKnowledgeItem(item) ;
    }

    public AttributeControl getAttributeControl(String attributeName) {
        AttributeControl attrControl = new AttributeControl() ;
        attrControl.setControlName(attributeName);
        attrControl.setControlType("select");
        List<String> values = new ArrayList<String>() ;
        values.add("Teste1") ;
        values.add("Teste2") ;
        values.add("Teste3") ;
        attrControl.setValues(values);
        return attrControl ;
    }

}
