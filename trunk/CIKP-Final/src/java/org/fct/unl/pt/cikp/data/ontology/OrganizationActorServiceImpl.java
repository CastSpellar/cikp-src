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
            onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), actor.getCommlanguage());
            onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), actor.getEmail());
            onts.addLiteralByProperty("has_Experience", actor.getUsername(), actor.getExperience());
            onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), actor.getFaxnumber());
            onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), actor.getGeoaffiliation());
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), actor.getInfoneed());
            onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), actor.getMailingaddress());
            onts.addLiteralByProperty("has_Name", actor.getUsername(), actor.getName());
            onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), actor.getWorkphone());
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
            actor.setCommlanguage((String) getOnt().getLiteralByProperty(username, "has_Communication_Language"));
            actor.setEmail((String)getOnt().getLiteralByProperty(username, "has_Email_Address"));
            actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience"));
            actor.setFaxnumber((String)getOnt().getLiteralByProperty(username, "has_Fax_Number"));
            actor.setGeoaffiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation"));
            actor.setInfoneed((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need"));
            actor.setMailingaddress((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address"));
            actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name"));
            actor.setType((String)getOnt().getIndividualClass(username));
            actor.setWorkphone((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number"));
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
