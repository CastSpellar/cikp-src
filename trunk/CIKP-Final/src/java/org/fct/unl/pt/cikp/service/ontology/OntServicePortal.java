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
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

/**
 *
 * @author Bruno
 */
public interface OntServicePortal {

   public IndividualActor createIndividualActor(IndividualActor actor, PersistentOntology p) ;

   public IndividualActor getIndividualActorByUsername(String username, PersistentOntology p) ;

    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology p) ;

    public OrganizationActor getOrganizationActorByUsername(String username, PersistentOntology p) ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item, PersistentOntology p) ;

    public Project createProject(Project proj, PersistentOntology p) ;

    public Event createEvent(Event ev, PersistentOntology p) ;

    public Process createProcess(Process proc, PersistentOntology p) ;

    public void createXMLTree(String filename, String cls, PersistentOntology p) ;

    public PhysicalProduct createPhysicalProduct(PhysicalProduct prod, PersistentOntology p) ;

    public ArrayList<String> listSkills(PersistentOntology p) ;

    public ArrayList<String> listAbilitys(PersistentOntology p) ;

    public ArrayList<String> listKnowledges(PersistentOntology p) ;

    public ArrayList<String> listCertificatesAndLicenses(PersistentOntology p) ;

    public ArrayList<String> listCommLanguages(PersistentOntology p) ;

    public ArrayList<String> listEducationBGs(PersistentOntology p) ;

    public ArrayList<String> listEthnicitys(PersistentOntology p) ;

    public ArrayList<String> listExperiences(PersistentOntology p) ;

    public ArrayList<String> listInfoNeeds(PersistentOntology p) ;

    public ArrayList<String> listMaritalStatus(PersistentOntology p) ;

    public ArrayList<String> listTrainingObts(PersistentOntology p) ;

    public ArrayList<String> listAuthoritys(PersistentOntology p) ;

    public ArrayList<String> listLiabilitys(PersistentOntology p) ;

    public ArrayList<String> listResponsibilitys(PersistentOntology p) ;

    public ArrayList<String> listRights(PersistentOntology p) ;

    public ArrayList<String> listEventAffiliations(PersistentOntology p) ;

    public ArrayList<String> listOrgAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProcAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProdAffiliations(PersistentOntology p) ;

    public ArrayList<String> listProjAffiliations(PersistentOntology p) ;

    public ArrayList<String> listCOPAffiliations(PersistentOntology p) ;

    public ArrayList <String> listGeoAffiliations(PersistentOntology p) ;

    public ArrayList <String> listLocations(PersistentOntology p) ;

    public void writeOnt(OutputStream out, PersistentOntology p) ;

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

    public ArrayList<String> listSubClasses(String name, PersistentOntology p) ;

    public ArrayList<String> listInstances(String name, PersistentOntology p) ;

}
