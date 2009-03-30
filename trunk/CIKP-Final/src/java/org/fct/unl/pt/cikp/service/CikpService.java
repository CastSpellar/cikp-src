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
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortal;
import org.fct.unl.pt.cikp.data.portal.SubscriptionPortal;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

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

    public KnowledgeItemPortal createKnowledgeItemPortal(KnowledgeItemPortal ki) ;
    
    public SubscriptionPortal createSubscriptionPortal(SubscriptionPortal subscription) ;

    public AttributeControl getAttributeControl(String attributeName) ;

    public OntologyControlsPortal getControl(String name) ;


    /**
     Ontology Methods
     */
    public IndividualActor createIndividualActor(IndividualActor actor, PersistentOntology p) ;

    public IndividualActor getIndividualActor(String name, PersistentOntology p) ;

    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology p) ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item, PersistentOntology p) ;

    public void createXMLTree(String filename, String cls, PersistentOntology p) ;

    public ArrayList<String> listAbilitys(PersistentOntology p) ;

    public ArrayList<String> listAuthoritys(PersistentOntology p) ;

    public ArrayList<String> listCOPAffiliations(PersistentOntology p) ;

    public ArrayList<String> listCertificatesAndLicences(PersistentOntology p) ;

    public ArrayList<String> listCommLanguages(PersistentOntology p) ;

    public ArrayList<String> listEducationBGs(PersistentOntology p) ;

    public ArrayList<String> listEthnicitys(PersistentOntology p) ;

    public ArrayList<String> listEventAffiliations(PersistentOntology p) ;

    public ArrayList<String> listExperiences(PersistentOntology p) ;

    public ArrayList<String> listGeoAffiliations(PersistentOntology p) ;

    public ArrayList<String> listInfoNeeds(PersistentOntology p) ;

    public ArrayList<String> listKnowledges(PersistentOntology p) ;

    public ArrayList<String> listLiabilitys(PersistentOntology p) ;

    public ArrayList<String> listLocations(PersistentOntology p) ;

    public ArrayList<String> listMaritalStatus(PersistentOntology p);

    public ArrayList<String> listOrgAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProcAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProdAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProjAffiliations(PersistentOntology p);

    public ArrayList<String> listResponsibilitys(PersistentOntology p);

    public ArrayList<String> listRights(PersistentOntology p);

    public ArrayList<String> listSkills(PersistentOntology p);

    public ArrayList<String> listTrainingObts(PersistentOntology p);

    public void writeOnt(OutputStream out, PersistentOntology p) ;

    public ArrayList<String> getSubClasses(String name, PersistentOntology p) ;

    public List<String> listInstances(String name, PersistentOntology p);
}
