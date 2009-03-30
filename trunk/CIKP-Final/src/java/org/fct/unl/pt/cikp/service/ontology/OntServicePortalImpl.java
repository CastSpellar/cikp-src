/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology;

import java.io.IOException;
import java.io.OutputStream;
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
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
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

    public IndividualActor createIndividualActor(IndividualActor actor, PersistentOntology p) {
        return getIndividualActorService().createActor(actor, p) ;
    }

    public IndividualActor getIndividualActorByUsername(String username, PersistentOntology p) {
        return getIndividualActorService().getIndividualActorByName(username, p) ;
    }

    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology p) {
        return getOrganizationActorService().createOrganizationActor(actor, p) ;
    }

    public OrganizationActor getOrganizationActorByUsername(String username, PersistentOntology p) {
        return getOrganizationActorService().getOrganizationActorByName(username, p) ;
    }

    public KnowledgeItem createKnowledgeItem(KnowledgeItem item, PersistentOntology p) {
        return getKnowledgeItemService().createKnowledgeItem(item, p) ;
    }

    public Project createProject(Project proj, PersistentOntology p) {
        return getProjectService().createProject(proj, p) ;
    }

    public Event createEvent(Event ev, PersistentOntology p) {
        return getEventService().createEvent(ev, p) ;
    }

    public Process createProcess(Process proc, PersistentOntology p) {
        return getProcessService().createProcess(proc, p) ;
    }
    
    public void createXMLTree(String filename, String cls, PersistentOntology p) {
        try {
            getOntService().createXMLFileXTree(filename, cls, p);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhysicalProduct createPhysicalProduct(PhysicalProduct prod, PersistentOntology p) {
        return getPhysicalProductService().createPhysicalProduct(prod, p) ;
    }

    public ArrayList<String> listSkills(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Skill_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listAbilitys(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Ability_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listKnowledges(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Knowledge_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listCertificatesAndLicenses(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Certificate_And_License_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listCommLanguages(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Language", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listEducationBGs(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Education_Background_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listEthnicitys(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Ethnic_Group", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listExperiences(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Experience_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listInfoNeeds(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Knowledge_Item", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listMaritalStatus(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Marital_Status_Value", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listTrainingObts(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Training_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listAuthoritys(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Authority_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listLiabilitys(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Liability_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listResponsibilitys(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Resposibility_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listRights(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Right_Type", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listEventAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Event", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listOrgAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Organization_Actor", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listProcAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Process", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listProdAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Product", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public ArrayList<String> listProjAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "Project", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList<String> listCOPAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(list, "COP_Value", p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList <String> listGeoAffiliations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Geographic_Area", false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public ArrayList <String> listLocations(PersistentOntology p) {
        ArrayList<String> list = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(list, hierarchy, counter, "Geographic_Area", false, p);
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

    public void writeOnt(OutputStream out, PersistentOntology p) {
        getOntService().writeOnt(out, p);
    }

    public ArrayList<String> listSubClasses(String name, PersistentOntology p) {
        ArrayList<String> results = new ArrayList<String>() ;
        ArrayList<Integer> hierarchy = new ArrayList<Integer>() ;
        int counter = 0 ;
        try {
            getOntService().listAbsoluteSubClasses(results, hierarchy, counter, name, false, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results ;
    }

    public ArrayList<String> listInstances(String name, PersistentOntology p) {
        ArrayList<String> res = new ArrayList<String>() ;
        try {
            getOntService().listAllInstancesOfClass(res, name, p);
        } catch (IOException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OntServicePortalImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res ;
    }

}
