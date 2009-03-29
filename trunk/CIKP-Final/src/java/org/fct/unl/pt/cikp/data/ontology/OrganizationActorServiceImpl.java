package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */

public class OrganizationActorServiceImpl implements OrganizationActorService {

    private OntService ont ;

    public OrganizationActor createOrganizationActor(OrganizationActor actor) {
        try {
            OntService onts = getOnt();
            onts.createIndividual(actor.getType(), actor.getUsername());
            onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), actor.getCommunication_language());
            onts.addLiteralByProperty("has_Age", actor.getUsername(), actor.getAge()) ;
            onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), actor.getEmail_address());
            onts.addLiteralByProperty("has_Experience", actor.getUsername(), actor.getExperience());
            onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), actor.getFax_number());
            onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), actor.getGeographic_affiliation());
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), actor.getInformation_and_knowledge_need());
            onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), actor.getMailing_address());
            onts.addLiteralByProperty("has_Name", actor.getUsername(), actor.getName());
            onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), actor.getWork_phone_number());
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

    public OrganizationActor getOrganizationActorByName(String username) {
        OrganizationActor actor = new OrganizationActor() ;
        try {
            actor.setCommunication_language((String) getOnt().getLiteralByProperty(username, "has_Communication_Language"));
            actor.setAge((Integer)getOnt().getLiteralByProperty(username, "has_Age")) ;
            actor.setEmail_address((String)getOnt().getLiteralByProperty(username, "has_Email_Address"));
            actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience"));
            actor.setFax_number((String)getOnt().getLiteralByProperty(username, "has_Fax_Number"));
            actor.setGeographic_affiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation"));
            actor.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need"));
            actor.setMailing_address((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address"));
            actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name"));
            actor.setType((String)getOnt().getIndividualClass(username));
            actor.setWork_phone_number((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number"));
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
