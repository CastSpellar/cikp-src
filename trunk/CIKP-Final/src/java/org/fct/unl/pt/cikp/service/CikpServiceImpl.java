/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActor;
import org.fct.unl.pt.cikp.data.portal.FilePortal;
import org.fct.unl.pt.cikp.data.portal.FilePortalService;
import org.fct.unl.pt.cikp.data.portal.FilePortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.HibernateUtil;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortalService;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortal;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortalService;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortal;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortalService;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortalServiceImpl;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortal;
import org.fct.unl.pt.cikp.service.ontology.OntServicePortalImpl;
import org.fct.unl.pt.cikp.data.portal.UserService;
import org.fct.unl.pt.cikp.data.portal.UserServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
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
    private SubscriptionPortalService subsService ;
    private OntologyControlsPortalService ontControlService ;


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
        session.getTransaction().commit();
        return user ;
    }

    public IndividualActor createIndividualActor(IndividualActor actor, PersistentOntology po) {
        return getOntServicePortal().createIndividualActor(actor, po) ;
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

    public ArrayList<String> listAbilitys(PersistentOntology po) {
        return getOntServicePortal().listAbilitys(po) ;
    }

    public ArrayList<String> listAuthoritys(PersistentOntology po) {
        return getOntServicePortal().listAuthoritys(po) ;
    }

    public ArrayList<String> listCOPAffiliations(PersistentOntology po) {
        return getOntServicePortal().listCOPAffiliations(po) ;
    }

    public ArrayList<String> listCertificatesAndLicences(PersistentOntology po) {
        return getOntServicePortal().listCertificatesAndLicenses(po) ;
    }

    public ArrayList<String> listCommLanguages(PersistentOntology po) {
        return getOntServicePortal().listCommLanguages(po) ;
    }

    public ArrayList<String> listEducationBGs(PersistentOntology po) {
        return getOntServicePortal().listEducationBGs(po) ;
    }

    public ArrayList<String> listEthnicitys(PersistentOntology po) {
        return getOntServicePortal().listEthnicitys(po) ;
    }

    public ArrayList<String> listEventAffiliations(PersistentOntology po) {
        return getOntServicePortal().listEventAffiliations(po) ;
    }

    public ArrayList<String> listExperiences(PersistentOntology po) {
        return getOntServicePortal().listExperiences(po) ;
    }

    public ArrayList<String> listGeoAffiliations(PersistentOntology po) {
        return getOntServicePortal().listGeoAffiliations(po) ;
    }

    public ArrayList<String> listInfoNeeds(PersistentOntology po) {
        return getOntServicePortal().listInfoNeeds(po) ;
    }

    public ArrayList<String> listKnowledges(PersistentOntology po) {
        return getOntServicePortal().listKnowledges(po) ;
    }

    public ArrayList<String> listLiabilitys(PersistentOntology po) {
        return getOntServicePortal().listLiabilitys(po) ;
    }

    public ArrayList<String> listLocations(PersistentOntology po) {
        return getOntServicePortal().listLocations(po) ;
    }

    public ArrayList<String> listMaritalStatus(PersistentOntology po) {
        return getOntServicePortal().listMaritalStatus(po) ;
    }

    public ArrayList<String> listOrgAffiliations(PersistentOntology po) {
        return getOntServicePortal().listOrgAffiliations(po) ;
    }

    public ArrayList<String> listProcAffiliations(PersistentOntology po) {
        return getOntServicePortal().listProcAffiliations(po) ;
    }

    public ArrayList<String> listProdAffiliations(PersistentOntology po) {
        return getOntServicePortal().listProdAffiliations(po) ;
    }

    public ArrayList<String> listProjAffiliations(PersistentOntology po) {
        return getOntServicePortal().listProjAffiliations(po) ;
    }

    public ArrayList<String> listResponsibilitys(PersistentOntology po) {
        return getOntServicePortal().listResponsibilitys(po) ;
    }

    public ArrayList<String> listRights(PersistentOntology po) {
        return getOntServicePortal().listRights(po) ;
    }

    public ArrayList<String> listSkills(PersistentOntology po) {
        return getOntServicePortal().listSkills(po) ;
    }

    public ArrayList<String> listTrainingObts(PersistentOntology po) {
        return getOntServicePortal().listTrainingObts(po) ;
    }

    public void createXMLTree(String filename, String cls, PersistentOntology po) {
        getOntServicePortal().createXMLTree(filename, cls, po);
    }

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item, PersistentOntology po) {
        return getOntServicePortal().createKnowledgeItem(item, po) ;
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

    public void writeOnt(OutputStream out, PersistentOntology po) {
        getOntServicePortal().writeOnt(out, po);
    }

    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology po) {
        return getOntServicePortal().createOrganizationActor(actor, po) ;
    }

    public SubscriptionPortal createSubscriptionPortal(SubscriptionPortal subscription) {
        Session session = getSession() ;
        session.beginTransaction() ;
        SubscriptionPortal s = getSubsService().store(subscription, session) ;
        session.getTransaction().commit() ;
        return s ;
    }

    /**
     * @return the subsService
     */
    public SubscriptionPortalService getSubsService() {
        return new SubscriptionPortalServiceImpl() ;
    }

    /**
     * @param subsService the subsService to set
     */
    public void setSubsService(SubscriptionPortalService subsService) {
        this.subsService = subsService;
    }

    public OntologyControlsPortal getControl(String name) {
        Session session = getSession() ;
        session.beginTransaction() ;
        OntologyControlsPortal o = getOntControlService().getControl(name, session) ;
        session.getTransaction().commit();
        return o ;
        //OntologyControlsPortal control = getOntologyControls
    }

    public ArrayList<String> getSubClasses(String name, PersistentOntology po) {
        return getOntServicePortal().listSubClasses(name, po) ;
    }

    /**
     * @return the ontControlService
     */
    public OntologyControlsPortalService getOntControlService() {
        return new OntologyControlsPortalServiceImpl() ;
    }

    /**
     * @param ontControlService the ontControlService to set
     */
    public void setOntControlService(OntologyControlsPortalService ontControlService) {
        this.ontControlService = ontControlService;
    }

    public List<String> listInstances(String name, PersistentOntology po) {
        return getOntServicePortal().listInstances(name, po) ;
    }

    public IndividualActor getIndividualActor(String name, PersistentOntology p) {
        return getOntServicePortal().getIndividualActorByUsername(name, p) ;
    }

}
