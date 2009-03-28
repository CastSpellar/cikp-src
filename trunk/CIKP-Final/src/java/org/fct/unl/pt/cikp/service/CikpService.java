/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service;

import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;
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

    public KnowledgeItemPortal createKnowledgeItemPortal(KnowledgeItemPortal ki) ;


    /**
     Ontology Methods
     */
    public IndividualActor createIndividualActor(IndividualActor actor) ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item) ;

    public void createXMLTree(String filename, String cls) ;

    public ArrayList<String> listAbilitys() ;

    public ArrayList<String> listAuthoritys() ;

    public ArrayList<String> listCOPAffiliations() ;

    public ArrayList<String> listCertificatesAndLicences() ;

    public ArrayList<String> listCommLanguages() ;

    public ArrayList<String> listEducationBGs() ;

    public ArrayList<String> listEthnicitys() ;

    public ArrayList<String> listEventAffiliations() ;

    public ArrayList<String> listExperiences() ;

    public ArrayList<String> listGeoAffiliations() ;

    public ArrayList<String> listInfoNeeds() ;

    public ArrayList<String> listKnowledges() ;

    public ArrayList<String> listLiabilitys() ;

    public ArrayList<String> listLocations() ;

    public ArrayList<String> listMaritalStatus();

    public ArrayList<String> listOrgAffiliations() ;

    public ArrayList<String> listProcAffiliations() ;

    public ArrayList<String> listProdAffiliations() ;

    public ArrayList<String> listProjAffiliations();

    public ArrayList<String> listResponsibilitys();

    public ArrayList<String> listRights();

    public ArrayList<String> listSkills();

    public ArrayList<String> listTrainingObts();

    public AttributeControl getAttributeControl(String attributeName) ;
}
