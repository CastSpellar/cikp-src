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
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Bruno
 */
public class IndividualActorServiceImpl implements IndividualActorService {

    private OntServiceImpl ont ;
    private RoleServiceImpl r ;

    public IndividualActor createActor(IndividualActor actor, PersistentOntology p) {
        try {
            OntService onts = getOnt() ;
            RoleService rs = getRs() ;
            onts.createIndividual(actor.getActortype(), actor.getUsername(), p);
            onts.removeLiteralByProperty("has_Age", actor.getUsername(), p, onts.getLiteralByProperty("has_Age", actor.getUsername(), p)) ;
            onts.addLiteralByProperty("has_Age", actor.getUsername(), actor.getAge(), p);
            if (actor.getEmail_address() != null) {
                onts.removeLiteralByProperty("has_Email_Address", actor.getUsername(), p, onts.getLiteralByProperty("has_Email_Address", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), (actor.getEmail_address() == null ? "" : actor.getEmail_address()), p);
            }
            if (actor.getFamily_name() != null) {
                onts.removeLiteralByProperty("has_Family_Name", actor.getUsername(), p, onts.getLiteralByProperty("has_Family_Name", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Family_Name", actor.getUsername(), (actor.getFamily_name() == null ? "" : actor.getFamily_name()), p);
            }
            if (actor.getFax_number() != null) {
                onts.removeLiteralByProperty("has_Fax_Number", actor.getUsername(), p, onts.getLiteralByProperty("has_Fax_Number", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), (actor.getFax_number() == null ? "" : actor.getFax_number()), p);
            }
            if (actor.getGiven_name() != null) {
                onts.removeLiteralByProperty("has_Given_Name", actor.getUsername(), p, onts.getLiteralByProperty("has_Given_Name", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Given_Name", actor.getUsername(), (actor.getGiven_name() == null ? "" : actor.getGiven_name()), p);
            }
            if (actor.getHome_phone_number() != null) {
                onts.removeLiteralByProperty("has_Home_Phone_Number", actor.getUsername(), p, onts.getLiteralByProperty("has_Home_Phone_Number", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Home_Phone_Number", actor.getUsername(), (actor.getHome_phone_number() == null ? "" : actor.getHome_phone_number()), p);
            }
            if (actor.getMailing_address() != null) {
                onts.removeLiteralByProperty("has_Mailing_Address", actor.getUsername(), p, onts.getLiteralByProperty("has_Mailing_Address", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), (actor.getMailing_address() == null ? "" : actor.getMailing_address()), p);
            }
            if (actor.getMiddle_name() != null) {
                onts.removeLiteralByProperty("has_Middle_Name", actor.getUsername(), p, onts.getLiteralByProperty("has_Middle_Name", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Middle_Name", actor.getUsername(), (actor.getMiddle_name() == null ? "" : actor.getMiddle_name()), p);
            }
            if (actor.getMobile_phone_number() != null) {
                onts.removeLiteralByProperty("has_Mobile_Phone_Number", actor.getUsername(), p, onts.getLiteralByProperty("has_Mobile_Phone_Number", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Mobile_Phone_Number", actor.getUsername(), (actor.getMobile_phone_number() == null ? "" : actor.getMobile_phone_number()), p);
            }
            if (actor.getName() != null) {
                onts.removeLiteralByProperty("has_Name", actor.getUsername(), p, onts.getLiteralByProperty("has_Name", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Name", actor.getUsername(), (actor.getName() == null ? "" : actor.getName()), p);
            }
            if (actor.getWork_phone_number() != null) {
                onts.removeLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), p, onts.getLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), (actor.getWork_phone_number() == null ? "" : actor.getWork_phone_number()), p);
            }
            if (actor.getAbility() != null) {
                onts.removeLiteralByProperty("has_Ability", actor.getUsername(), p, onts.getLiteralByProperty("has_Ability", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Ability", actor.getUsername(), (actor.getAbility() == null ? "" : actor.getAbility()), p);
            }
            if (actor.getCertificate_and_license() != null) {
                onts.removeLiteralByProperty("has_Certificate_And_License", actor.getUsername(), p, onts.getLiteralByProperty("has_Certificate_And_License", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Certificate_And_License", actor.getUsername(), (actor.getCertificate_and_license() == null ? "" : actor.getCertificate_and_license()), p);
            }
            if (actor.getCommunication_language() != null) {
                onts.removeLiteralByProperty("has_Communication_Language", actor.getUsername(), p, onts.getLiteralByProperty("has_Communication_Language", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), (actor.getCommunication_language() == null ? "" : actor.getCommunication_language()), p);
            }
            if (actor.getEducation_background() != null) {
                onts.removeLiteralByProperty("has_Education_Background", actor.getUsername(), p, onts.getLiteralByProperty("has_Education_Background", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Education_Background", actor.getUsername(), (actor.getEducation_background() == null ? "" : actor.getEducation_background()), p);
            }
            if (actor.getEthnicity() != null) {
                onts.removeLiteralByProperty("has_Ethnicity_Status", actor.getUsername(), p, onts.getLiteralByProperty("has_Ethnicity_Status", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Ethnicity_Status", actor.getUsername(), (actor.getEthnicity() == null ? "" : actor.getEthnicity()), p);
            }
            if (actor.getExperience() != null) {
                onts.removeLiteralByProperty("has_Experience", actor.getUsername(), p, onts.getLiteralByProperty("has_Experience", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Experience", actor.getUsername(), (actor.getExperience() == null ? "" : actor.getExperience()), p);
            }
            if (actor.getGender() != null) {
                onts.removeLiteralByProperty("has_Gender", actor.getUsername(), p, onts.getLiteralByProperty("has_Gender", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Gender", actor.getUsername(), (actor.getGender() == null ? "" : actor.getGender()), p);
            }
            if (actor.getGeographic_affiliation() != null) {
                onts.removeLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), p, onts.getLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), (actor.getGeographic_affiliation() == null ? "" : actor.getGeographic_affiliation()), p);
            }
            if (actor.getInformation_and_knowledge_need() != null) {
                onts.removeLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), p, onts.getLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), (actor.getInformation_and_knowledge_need() == null ? "" : actor.getInformation_and_knowledge_need()), p);
            }
            if (actor.getKnowledge() != null) {
                onts.removeLiteralByProperty("has_Knowledge", actor.getUsername(), p, onts.getLiteralByProperty("has_Knowledge", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Knowledge", actor.getUsername(), (actor.getKnowledge() == null ? "" : actor.getKnowledge()), p);
            }
            if (actor.getMarital_status() != null) {
                onts.removeLiteralByProperty("has_Marital_Status", actor.getUsername(), p, onts.getLiteralByProperty("has_Marital_Status", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Marital_Status", actor.getUsername(), (actor.getMarital_status() == null ? "" : actor.getMarital_status()), p);
            }
            if (actor.getSkill() != null) {
                onts.removeLiteralByProperty("has_Skill", actor.getUsername(), p, onts.getLiteralByProperty("has_Skill", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Skill", actor.getUsername(), (actor.getSkill() == null ? "" : actor.getSkill()), p);
            }
            if (actor.getTraining_obtained() != null) {
                onts.removeLiteralByProperty("has_Training_Obtained", actor.getUsername(), p, onts.getLiteralByProperty("has_Training_Obtained", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Training_Obtained", actor.getUsername(), (actor.getTraining_obtained() == null ? "" : actor.getTraining_obtained()), p);
            }
            if (actor.getCop_affiliation() != null) {
                onts.removeLiteralByProperty("has_COP_Affiliation", actor.getUsername(), p, onts.getLiteralByProperty("has_COP_Affiliation", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_COP_Affiliation", actor.getUsername(), (actor.getCop_affiliation() == null ? "" : actor.getCop_affiliation()), p);
            }
            if (actor.getOrganizational_affiliation() != null) {
                onts.removeLiteralByProperty("has_Organization_Affiliation", actor.getUsername(), p, onts.getLiteralByProperty("has_Organization_Affiliation", actor.getUsername(), p)) ;
                onts.addLiteralByProperty("has_Organization_Affiliation", actor.getUsername(), (actor.getOrganizational_affiliation() == null ? "" : actor.getOrganizational_affiliation()), p);
            }
            if (actor.getRoles() != null) {
                Iterator iter = actor.getRoles().iterator();
                while (iter.hasNext()) {
                    Role role = (Role) iter.next();
                    role.setRoleentityname(role.getRoleentityname() + actor.getUsername()) ;
                    rs.createRole(role, p) ;
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

    public IndividualActor getIndividualActorByName(String username, PersistentOntology p) {
        IndividualActor actor = new IndividualActor() ;
        OntService onts = getOnt() ;
        try {
            RoleService rs = getRs() ;
            if(onts.getIndividual(username, p) != null){
                actor.setActortype(getOnt().getIndividualClass(username, p));
                actor.setAge((Integer)getOnt().getLiteralByProperty(username, "has_Age", p));
                actor.setEmail_address((String)getOnt().getLiteralByProperty(username, "has_Email_Address", p)) ;
                actor.setFamily_name((String)getOnt().getLiteralByProperty(username, "has_Family_Name", p)) ;
                actor.setFax_number((String)getOnt().getLiteralByProperty(username, "has_Fax_Number", p)) ;
                actor.setGiven_name((String)getOnt().getLiteralByProperty(username, "has_Given_Name", p)) ;
                actor.setHome_phone_number((String)getOnt().getLiteralByProperty(username, "has_Home_Phone_Number", p)) ;
                actor.setMailing_address((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address", p)) ;
                actor.setMiddle_name((String)getOnt().getLiteralByProperty(username, "has_Middle_Name", p)) ;
                actor.setMobile_phone_number((String)getOnt().getLiteralByProperty(username, "has_Mobile_Phone_Number", p)) ;
                actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name", p)) ;
                actor.setWork_phone_number((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number", p)) ;
                actor.setAbility((String) getOnt().getLiteralByProperty(username, "has_Ability", p)) ;
                actor.setCertificate_and_license((String)getOnt().getLiteralByProperty(username, "has_Certificate_And_License", p)) ;
                actor.setCommunication_language((String)getOnt().getLiteralByProperty(username, "has_Communication_Language", p)) ;
                actor.setEducation_background((String)getOnt().getLiteralByProperty(username, "has_Education_Background", p)) ;
                actor.setEthnicity((String)getOnt().getLiteralByProperty(username, "has_Ethnicity_Status", p)) ;
                actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience", p)) ;
                actor.setGender((String)getOnt().getLiteralByProperty(username, "has_Gender", p)) ;
                actor.setGeographic_affiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation", p)) ;
                actor.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need", p)) ;
                actor.setKnowledge((String)getOnt().getLiteralByProperty(username, "has_Knowledge", p)) ;
                actor.setMarital_status((String)getOnt().getLiteralByProperty(username, "has_Marital_Status", p)) ;
                actor.setSkill((String)getOnt().getLiteralByProperty(username, "has_Skill", p)) ;
                actor.setTraining_obtained((String)getOnt().getLiteralByProperty(username, "has_Training_Obtained", p)) ;
                actor.setCop_affiliation((String)getOnt().getLiteralByProperty(username, "has_COP_Affiliation", p)) ;
                actor.setOrganizational_affiliation((String)getOnt().getLiteralByProperty(username, "has_Organization_Affiliation", p)) ;
                actor.setRoles(rs.listActorRoles(username, p));
                return actor ;
            }
            else return null ;
        } catch (IOException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndividualActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        }
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
