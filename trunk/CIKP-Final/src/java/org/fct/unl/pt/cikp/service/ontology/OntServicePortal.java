/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology;

import java.io.OutputStream;
import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ontology.Event;
import org.fct.unl.pt.cikp.data.ontology.EventService;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.IndividualActorService;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItemService;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActor;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActorService;
import org.fct.unl.pt.cikp.data.ontology.PhysicalProduct;
import org.fct.unl.pt.cikp.data.ontology.PhysicalProductService;
import org.fct.unl.pt.cikp.data.ontology.Project;
import org.fct.unl.pt.cikp.data.ontology.ProjectService;
import org.fct.unl.pt.cikp.data.ontology.Process;
import org.fct.unl.pt.cikp.data.ontology.ProcessService;

/**
 *
 * @author Bruno
 */
public interface OntServicePortal {

   public IndividualActor createIndividualActor(IndividualActor actor) ;

   public IndividualActor getIndividualActorByUsername(String username) ;

    public OrganizationActor createOrganizationActor(OrganizationActor actor) ;

    public OrganizationActor getOrganizationActorByUsername(String username) ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item) ;

    public Project createProject(Project proj) ;

    public Event createEvent(Event ev) ;

    public Process createProcess(Process proc) ;

    public void createXMLTree(String filename, String cls) ;

    public PhysicalProduct createPhysicalProduct(PhysicalProduct prod) ;

    public ArrayList<String> listSkills() ;

    public ArrayList<String> listAbilitys() ;

    public ArrayList<String> listKnowledges() ;

    public ArrayList<String> listCertificatesAndLicenses() ;

    public ArrayList<String> listCommLanguages() ;

    public ArrayList<String> listEducationBGs() ;

    public ArrayList<String> listEthnicitys() ;

    public ArrayList<String> listExperiences() ;

    public ArrayList<String> listInfoNeeds() ;

    public ArrayList<String> listMaritalStatus() ;

    public ArrayList<String> listTrainingObts() ;

    public ArrayList<String> listAuthoritys() ;

    public ArrayList<String> listLiabilitys() ;

    public ArrayList<String> listResponsibilitys() ;

    public ArrayList<String> listRights() ;

    public ArrayList<String> listEventAffiliations() ;

    public ArrayList<String> listOrgAffiliations() ;

    public ArrayList<String> listProcAffiliations() ;

    public ArrayList<String> listProdAffiliations() ;

    public ArrayList<String> listProjAffiliations() ;

    public ArrayList<String> listCOPAffiliations() ;

    public ArrayList <String> listGeoAffiliations() ;

    public ArrayList <String> listLocations() ;

    public void writeOnt(OutputStream out) ;

    /**
     * @return the individualActorService
     */
    public IndividualActorService getIndividualActorService() ;

    /**
     * @param individualActorService the individualActorService to set
     */
    public void setIndividualActorService(IndividualActorService individualActorService) ;

    /**
     * @return the ontService
     */
    public OntService getOntService() ;

    /**
     * @param ontService the ontService to set
     */
    public void setOntService(OntService ontService) ;

    /**
     * @return the organizationActorService
     */
    public OrganizationActorService getOrganizationActorService() ;

    /**
     * @param organizationActorService the organizationActorService to set
     */
    public void setOrganizationActorService(OrganizationActorService organizationActorService) ;

    /**
     * @return the knowledgeItemService
     */
    public KnowledgeItemService getKnowledgeItemService() ;
    /**
     * @param knowledgeItemService the knowledgeItemService to set
     */
    public void setKnowledgeItemService(KnowledgeItemService knowledgeItemService) ;

    /**
     * @return the projectService
     */
    public ProjectService getProjectService() ;

    /**
     * @param projectService the projectService to set
     */
    public void setProjectService(ProjectService projectService) ;

    /**
     * @return the eventService
     */
    public EventService getEventService() ;

    /**
     * @param eventService the eventService to set
     */
    public void setEventService(EventService eventService) ;

    /**
     * @return the processService
     */
    public ProcessService getProcessService() ;

    /**
     * @param processService the processService to set
     */
    public void setProcessService(ProcessService processService) ;

    /**
     * @return the physicalProductService
     */
    public PhysicalProductService getPhysicalProductService() ;

    /**
     * @param physicalProductService the physicalProductService to set
     */
    public void setPhysicalProductService(PhysicalProductService physicalProductService) ;

    public ArrayList<String> listSubClasses(String name) ;

}
