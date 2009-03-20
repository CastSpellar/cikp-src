/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.portal.User;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortalImpl;
import org.fct.unl.pt.cikp.service.user.UserService;
import org.fct.unl.pt.cikp.service.user.UserServiceImpl;

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

    public void updateUser(User u) {
        getUserService().updateUser(u);
    }

    public boolean existsUser(User u) {
        return getUserService().existsUserName(u) ;
    }

    public User authenticateUser(User u) {
        return getUserService().authenticateUser(u) ;
    }

    public User registerUser(User u) {
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

}
