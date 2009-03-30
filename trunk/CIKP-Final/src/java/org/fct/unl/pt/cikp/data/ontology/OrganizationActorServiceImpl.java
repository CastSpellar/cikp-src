package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */

public class OrganizationActorServiceImpl implements OrganizationActorService {

    private OntService ont ;

    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology p) {
        try {
            OntService onts = getOnt();
            onts.createIndividual(actor.getType(), actor.getUsername(), p);
            onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), actor.getCommunication_language(), p);
            onts.addLiteralByProperty("has_Age", actor.getUsername(), actor.getAge(), p) ;
            onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), actor.getEmail_address(), p);
            onts.addLiteralByProperty("has_Experience", actor.getUsername(), actor.getExperience(), p);
            onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), actor.getFax_number(), p);
            onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), actor.getGeographic_affiliation(), p);
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), actor.getInformation_and_knowledge_need(), p);
            onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), actor.getMailing_address(), p);
            onts.addLiteralByProperty("has_Name", actor.getUsername(), actor.getName(), p);
            onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), actor.getWork_phone_number(), p);
            return actor;
        } catch (IOException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    public OrganizationActor getOrganizationActorByName(String username, PersistentOntology p) {
        OrganizationActor actor = new OrganizationActor() ;
        try {
            actor.setCommunication_language((String) getOnt().getLiteralByProperty(username, "has_Communication_Language", p));
            actor.setAge((Integer)getOnt().getLiteralByProperty(username, "has_Age", p)) ;
            actor.setEmail_address((String)getOnt().getLiteralByProperty(username, "has_Email_Address", p));
            actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience", p));
            actor.setFax_number((String)getOnt().getLiteralByProperty(username, "has_Fax_Number", p));
            actor.setGeographic_affiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation", p));
            actor.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need", p));
            actor.setMailing_address((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address", p));
            actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name", p));
            actor.setType((String)getOnt().getIndividualClass(username, p));
            actor.setWork_phone_number((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number", p));
        } catch (IOException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrganizationActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actor ;
    }

    /**
     * @return the ont
     */
    public OntService getOnt() {
        return new OntServiceImpl();
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntService ont) {
        this.ont = ont;
    }
}
