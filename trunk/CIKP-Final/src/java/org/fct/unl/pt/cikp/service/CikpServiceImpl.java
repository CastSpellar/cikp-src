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
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortal;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortalService;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortalServiceImpl;
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
    private SubscriptionPortalService subsService ;


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

    public ArrayList<String> listAbilitys() {
        return getOntServicePortal().listAbilitys() ;
    }

    public ArrayList<String> listAuthoritys() {
        return getOntServicePortal().listAuthoritys() ;
    }

    public ArrayList<String> listCOPAffiliations() {
        return getOntServicePortal().listCOPAffiliations() ;
    }

    public ArrayList<String> listCertificatesAndLicences() {
        return getOntServicePortal().listCertificatesAndLicenses() ;
    }

    public ArrayList<String> listCommLanguages() {
        return getOntServicePortal().listCommLanguages() ;
    }

    public ArrayList<String> listEducationBGs() {
        return getOntServicePortal().listEducationBGs() ;
    }

    public ArrayList<String> listEthnicitys() {
        return getOntServicePortal().listEthnicitys() ;
    }

    public ArrayList<String> listEventAffiliations() {
        return getOntServicePortal().listEventAffiliations() ;
    }

    public ArrayList<String> listExperiences() {
        return getOntServicePortal().listExperiences() ;
    }

    public ArrayList<String> listGeoAffiliations() {
        return getOntServicePortal().listGeoAffiliations() ;
    }

    public ArrayList<String> listInfoNeeds() {
        return getOntServicePortal().listInfoNeeds() ;
    }

    public ArrayList<String> listKnowledges() {
        return getOntServicePortal().listKnowledges() ;
    }

    public ArrayList<String> listLiabilitys() {
        return getOntServicePortal().listLiabilitys() ;
    }

    public ArrayList<String> listLocations() {
        return getOntServicePortal().listLocations() ;
    }

    public ArrayList<String> listMaritalStatus() {
        return getOntServicePortal().listMaritalStatus() ;
    }

    public ArrayList<String> listOrgAffiliations() {
        return getOntServicePortal().listOrgAffiliations() ;
    }

    public ArrayList<String> listProcAffiliations() {
        return getOntServicePortal().listProcAffiliations() ;
    }

    public ArrayList<String> listProdAffiliations() {
        return getOntServicePortal().listProdAffiliations() ;
    }

    public ArrayList<String> listProjAffiliations() {
        return getOntServicePortal().listProjAffiliations() ;
    }

    public ArrayList<String> listResponsibilitys() {
        return getOntServicePortal().listResponsibilitys() ;
    }

    public ArrayList<String> listRights() {
        return getOntServicePortal().listRights() ;
    }

    public ArrayList<String> listSkills() {
        return getOntServicePortal().listSkills() ;
    }

    public ArrayList<String> listTrainingObts() {
        return getOntServicePortal().listTrainingObts() ;
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

    public void writeOnt(OutputStream out) {
        getOntServicePortal().writeOnt(out);
    }

    public OrganizationActor createOrganizationActor(OrganizationActor actor) {
        return getOntServicePortal().createOrganizationActor(actor) ;
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

    public String getControl(String name) {
        return "" ;
        //OntologyControlsPortal control = getOntologyControls
    }

    public ArrayList<String> getSubClasses(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
