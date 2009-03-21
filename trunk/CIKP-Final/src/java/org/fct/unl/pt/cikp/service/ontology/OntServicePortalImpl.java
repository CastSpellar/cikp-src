/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.data.ontology.Event;
import org.fct.unl.pt.cikp.data.ontology.EventService;
import org.fct.unl.pt.cikp.data.ontology.EventServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.IndividualActorService;
import org.fct.unl.pt.cikp.data.ontology.IndividualActorServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItemService;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItemServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActor;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActorService;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActorServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.PhysicalProduct;
import org.fct.unl.pt.cikp.data.ontology.PhysicalProductService;
import org.fct.unl.pt.cikp.data.ontology.PhysicalProductServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.Process;
import org.fct.unl.pt.cikp.data.ontology.ProcessService;
import org.fct.unl.pt.cikp.data.ontology.ProcessServiceImpl;
import org.fct.unl.pt.cikp.data.ontology.Project;
import org.fct.unl.pt.cikp.data.ontology.ProjectService;
import org.fct.unl.pt.cikp.data.ontology.ProjectServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Bruno
 */
public class OntServicePortalImpl implements OntServicePortal {

    private IndividualActorService individualActorService ;
    private OrganizationActorService organizationActorService ;
    private KnowledgeItemService knowledgeItemService ;
    private ProjectService projectService ;
    private EventService eventService ;
    private ProcessService processService ;
    private PhysicalProductService physicalProductService ;
    private OntService ontService ;

    public IndividualActor createIndividualActor(IndividualActor actor) {
        return getIndividualActorService().createActor(actor) ;
    }

    public IndividualActor getIndividualActorByUsername(String username) {
        return getIndividualActorService().getIndividualActorByName(username) ;
    }

    public OrganizationActor createOrganizationActor(OrganizationActor actor) {
        return getOrganizationActorService().createOrganizationActor(actor) ;
    }

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item) {
        return getKnowledgeItemService().createKnowledgeItem(item) ;
    }

    public Project createProject(Project proj) {
        return getProjectService().createProject(proj) ;
    }

    public Event createEvent(Event ev) {
        return getEventService().createEvent(ev) ;
    }

    public Process createProcess(Process proc) {
        return getProcessService().createProcess(proc) ;
    }
    
    public void createXMLTree(String filename, String cls) {
        try {
            getOntService().createXMLFileXTree(filename, cls);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhysicalProduct createPhysicalProduct(PhysicalProduct prod) {
        return getPhysicalProductService().createPhysicalProduct(prod) ;
    }

    public ArrayList<String> listSkills() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Skill_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listAbilitys() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Ability_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listKnowledges() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Knowledge_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listCertificatesAndLicenses() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Certificate_And_License_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listCommLanguages() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Language", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listEducationBGs() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Education_Background_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listEthnicitys() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Ethnic_Group", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listExperiences() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Experience_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listInfoNeeds() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Knowledge_Item");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listMaritalStatus() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Marital_Status_Value", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listTrainingObts() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Training_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listAuthoritys() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Authority_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listLiabilitys() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Liability_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listResponsibilitys() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Resposibility_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listRights() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Right_Type", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listEventAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Event");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listOrgAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Organization_Actor");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listProcAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Process");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listProdAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Product");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listProjAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Project");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listCOPAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "COP_Value");
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList <String> listGeoAffiliations() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Geographic_Area", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList <String> listLocations() {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Geographic_Area", false);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    /**
     * @return the individualActorService
     */
    public IndividualActorService getIndividualActorService() {
        return new IndividualActorServiceImpl() ;
    }

    /**
     * @param individualActorService the individualActorService to set
     */
    public void setIndividualActorService(IndividualActorService individualActorService) {
        this.individualActorService = individualActorService;
    }

    /**
     * @return the ontService
     */
    public OntService getOntService() {
        return new OntServiceImpl();
    }

    /**
     * @param ontService the ontService to set
     */
    public void setOntService(OntService ontService) {
        this.ontService = ontService;
    }

    /**
     * @return the organizationActorService
     */
    public OrganizationActorService getOrganizationActorService() {
        return new OrganizationActorServiceImpl();
    }

    /**
     * @param organizationActorService the organizationActorService to set
     */
    public void setOrganizationActorService(OrganizationActorService organizationActorService) {
        this.organizationActorService = organizationActorService;
    }

    /**
     * @return the knowledgeItemService
     */
    public KnowledgeItemService getKnowledgeItemService() {
        return new KnowledgeItemServiceImpl();
    }

    /**
     * @param knowledgeItemService the knowledgeItemService to set
     */
    public void setKnowledgeItemService(KnowledgeItemService knowledgeItemService) {
        this.knowledgeItemService = knowledgeItemService;
    }

    /**
     * @return the projectService
     */
    public ProjectService getProjectService() {
        return new ProjectServiceImpl();
    }

    /**
     * @param projectService the projectService to set
     */
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * @return the eventService
     */
    public EventService getEventService() {
        return new EventServiceImpl();
    }

    /**
     * @param eventService the eventService to set
     */
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * @return the processService
     */
    public ProcessService getProcessService() {
        return new ProcessServiceImpl();
    }

    /**
     * @param processService the processService to set
     */
    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }

    /**
     * @return the physicalProductService
     */
    public PhysicalProductService getPhysicalProductService() {
        return new PhysicalProductServiceImpl();
    }

    /**
     * @param physicalProductService the physicalProductService to set
     */
    public void setPhysicalProductService(PhysicalProductService physicalProductService) {
        this.physicalProductService = physicalProductService;
    }

}
