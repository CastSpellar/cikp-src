/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.*;
import java.util.Iterator;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Bruno
 */
public class IndividualActorServiceImpl implements IndividualActorService {

    private OntServiceImpl ont ;
    private RoleServiceImpl r ;

    public IndividualActor createActor(IndividualActor actor) {
        try {
            OntService onts = getOnt() ;
            RoleService rs = getRs() ;
            onts.createIndividual(actor.getActortype(), actor.getUsername());
            onts.addLiteralByProperty("has_Age", actor.getUsername(), actor.getAge());
            onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), (actor.getEmail_address() == null ? "" : actor.getEmail_address()));
            onts.addLiteralByProperty("has_Family_Name", actor.getUsername(), (actor.getFamily_name() == null ? "" : actor.getFamily_name()));
            onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), (actor.getFax_number() == null ? "" : actor.getFax_number()));
            onts.addLiteralByProperty("has_Given_Name", actor.getUsername(), (actor.getGiven_name() == null ? "" : actor.getGiven_name()));
            onts.addLiteralByProperty("has_Home_Phone_Number", actor.getUsername(), (actor.getHome_phone_number() == null ? "" : actor.getHome_phone_number()));
            onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), (actor.getMailing_address() == null ? "" : actor.getMailing_address()));
            onts.addLiteralByProperty("has_Middle_Name", actor.getUsername(), (actor.getMiddle_name() == null ? "" : actor.getMiddle_name()));
            onts.addLiteralByProperty("has_Mobile_Phone_Number", actor.getUsername(), (actor.getMobile_phone_number() == null ? "" : actor.getMobile_phone_number()));
            onts.addLiteralByProperty("has_Name", actor.getUsername(), (actor.getName() == null ? "" : actor.getName()));
            onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), (actor.getWork_phone_number() == null ? "" : actor.getWork_phone_number()));
            onts.addLiteralByProperty("has_Ability", actor.getUsername(), (actor.getAbility() == null ? "" : actor.getAbility()));
            onts.addLiteralByProperty("has_Certificate_And_License", actor.getUsername(), (actor.getCetificate_and_license() == null ? "" : actor.getCetificate_and_license()));
            onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), (actor.getCommunication_language() == null ? "" : actor.getCommunication_language()));
            onts.addLiteralByProperty("has_Education_Background", actor.getUsername(), (actor.getEducation_background() == null ? "" : actor.getEducation_background()));
            onts.addLiteralByProperty("has_Ethnicity_Status", actor.getUsername(), (actor.getEthnicity() == null ? "" : actor.getEthnicity()));
            onts.addLiteralByProperty("has_Experience", actor.getUsername(), (actor.getExperience() == null ? "" : actor.getExperience()));
            onts.addLiteralByProperty("has_Gender", actor.getUsername(), (actor.getGender() == null ? "" : actor.getGender()));
            onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), (actor.getGeographic_affiliation() == null ? "" : actor.getGeographic_affiliation()));
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), (actor.getInformation_and_knowledge_need() == null ? "" : actor.getInformation_and_knowledge_need()));
            onts.addLiteralByProperty("has_Knowledge", actor.getUsername(), (actor.getKnowledge() == null ? "" : actor.getKnowledge()));
            onts.addLiteralByProperty("has_Marital_Status", actor.getUsername(), (actor.getMarital_status() == null ? "" : actor.getMarital_status()));
            onts.addLiteralByProperty("has_Skill", actor.getUsername(), (actor.getSkill() == null ? "" : actor.getSkill()));
            onts.addLiteralByProperty("has_Training_Obtained", actor.getUsername(), (actor.getTraining_obtained() == null ? "" : actor.getTraining_obtained()));
            onts.addLiteralByProperty("has_COP_Affiliation", actor.getUsername(), (actor.getCop_affiliation() == null ? "" : actor.getCop_affiliation()));
            onts.addLiteralByProperty("has_Organization_Affiliation", actor.getUsername(), (actor.getOrganizational_affiliation() == null ? "" : actor.getOrganizational_affiliation()));
            if (actor.getRoles() != null) {
                Iterator iter = actor.getRoles().iterator();
                while (iter.hasNext()) {
                    Role role = (Role) iter.next();
                    role.setRoleentityname(role.getRoleentityname() + actor.getUsername()) ;
                    rs.createRole(role) ;
                }
            }
            return actor;
        } catch (IOException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    public IndividualActor getIndividualActorByName(String username) {
        IndividualActor actor = new IndividualActor() ;
        try {
            RoleService rs = getRs() ;
            actor.setActortype(getOnt().getIndividualClass(username));
            actor.setAge((Integer)getOnt().getLiteralByProperty(username, "has_Age"));
            actor.setEmail_address((String)getOnt().getLiteralByProperty(username, "has_Email_Address")) ;
            actor.setFamily_name((String)getOnt().getLiteralByProperty(username, "has_Family_Name")) ;
            actor.setFax_number((String)getOnt().getLiteralByProperty(username, "has_Fax_Number")) ;
            actor.setGiven_name((String)getOnt().getLiteralByProperty(username, "has_Given_Name")) ;
            actor.setHome_phone_number((String)getOnt().getLiteralByProperty(username, "has_Home_Phone_Number")) ;
            actor.setMailing_address((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address")) ;
            actor.setMiddle_name((String)getOnt().getLiteralByProperty(username, "has_Middle_Name")) ;
            actor.setMobile_phone_number((String)getOnt().getLiteralByProperty(username, "has_Mobile_Phone_Number")) ;
            actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name")) ;
            actor.setWork_phone_number((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number")) ;
            actor.setAbility((String) getOnt().getLiteralByProperty(username, "has_Ability")) ;
            actor.setCetificate_and_license((String)getOnt().getLiteralByProperty(username, "has_Certificate_And_License")) ;
            actor.setCommunication_language((String)getOnt().getLiteralByProperty(username, "has_Communication_Language")) ;
            actor.setEducation_background((String)getOnt().getLiteralByProperty(username, "has_Education_Background")) ;
            actor.setEthnicity((String)getOnt().getLiteralByProperty(username, "has_Ethnicity_Status")) ;
            actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience")) ;
            actor.setGender((String)getOnt().getLiteralByProperty(username, "has_Gender")) ;
            actor.setGeographic_affiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation")) ;
            actor.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need")) ;
            actor.setKnowledge((String)getOnt().getLiteralByProperty(username, "has_Knowledge")) ;
            actor.setMarital_status((String)getOnt().getLiteralByProperty(username, "has_Marital_Status")) ;
            actor.setSkill((String)getOnt().getLiteralByProperty(username, "has_Skill")) ;
            actor.setTraining_obtained((String)getOnt().getLiteralByProperty(username, "has_Training_Obtained")) ;
            actor.setCop_affiliation((String)getOnt().getLiteralByProperty(username, "has_COP_Affiliation")) ;
            actor.setOrganizational_affiliation((String)getOnt().getLiteralByProperty(username, "has_Organization_Affiliation")) ;
            actor.setRoles(rs.listActorRoles(username));
        } catch (IOException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actor ;
    }

    /**
     * @return the ont
     */
    public OntServiceImpl getOnt() {
        return new OntServiceImpl() ;
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntServiceImpl ont) {
        this.ont = ont;
    }

    /**
     * @return the rs
     */
    public RoleServiceImpl getRs() {
        return new RoleServiceImpl() ;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(RoleServiceImpl r) {
        this.r = r;
    }

}
