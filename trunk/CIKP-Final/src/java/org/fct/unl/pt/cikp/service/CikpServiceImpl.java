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
import org.fct.unl.pt.cikp.data.portal.FilePortal;
import org.fct.unl.pt.cikp.data.portal.FilePortalService;
import org.fct.unl.pt.cikp.data.portal.FilePortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.HibernateUtil;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortalService;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortalImpl;
import org.fct.unl.pt.cikp.data.portal.UserService;
import org.fct.unl.pt.cikp.data.portal.UserServiceImpl;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class CikpServiceImpl implements CikpService {

    private UserService userService ;
    private KnowledgeItemPortalService kiService ;
    private FilePortalService fpService ;
    private OntServicePortal ontServicePortal ;


     private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession() ;
    }

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
        Session session = getSession() ;
        session.beginTransaction() ;
        getUserService().updateUser(u, session);
        session.getTransaction().commit() ;
    }

    public boolean existsUser(UserPortal u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        boolean result = getUserService().existsUserName(u, session) ;
        session.getTransaction().commit();
        return result ;
    }

    public UserPortal authenticateUser(UserPortal u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        UserPortal user = getUserService().authenticateUser(u, session) ;
        session.getTransaction().commit();
        return user ;
    }

    public UserPortal registerUser(UserPortal u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        UserPortal user = getUserService().register(u, session) ;
        session.getTransaction().commit(); ;
        return user ;
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

    /**
     * @return the kiService
     */
    public KnowledgeItemPortalService getKiService() {
        return new KnowledgeItemPortalServiceImpl() ;
    }

    /**
     * @param kiService the kiService to set
     */
    public void setKiService(KnowledgeItemPortalService kiService) {
        this.kiService = kiService;
    }

    public KnowledgeItemPortal createKnowledgeItemPortal(KnowledgeItemPortal ki) {
        Session session = getSession() ;
        session.beginTransaction() ;
        FilePortal fp = getFpService().store(ki.getFilePortal(), session) ;
        ki.setFilePortal(fp) ;
        KnowledgeItemPortal k = getKiService().store(ki, session) ;
        session.beginTransaction().commit();
        return k ;
    }

    /**
     * @return the fpService
     */
    public FilePortalService getFpService() {
        return new FilePortalServiceImpl() ;
    }

    /**
     * @param fpService the fpService to set
     */
    public void setFpService(FilePortalService fpService) {
        this.fpService = fpService;
    }

}
