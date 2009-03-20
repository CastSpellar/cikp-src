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
            onts.addLiteralByProperty("has_Information_Need", actor.getUsername(), actor.getInfoneed());
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
