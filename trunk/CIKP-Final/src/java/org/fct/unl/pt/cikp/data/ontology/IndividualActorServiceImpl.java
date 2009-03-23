/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.ArrayList;
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

    public IndividualActor createActor(IndividualActor actor) {
        try {
            OntServiceImpl onts = getOnt();
            onts.createIndividual(actor.getActortype(), actor.getUsername());
            onts.addLiteralByProperty("has_Age", actor.getUsername(), actor.getAge());
            onts.addLiteralByProperty("has_Email_Address", actor.getUsername(), (actor.getEmail() == null ? "" : actor.getEmail()));
            onts.addLiteralByProperty("has_Family_Name", actor.getUsername(), (actor.getFamilyname() == null ? "" : actor.getFamilyname()));
            onts.addLiteralByProperty("has_Fax_Number", actor.getUsername(), (actor.getFaxnumber() == null ? "" : actor.getFaxnumber()));
            onts.addLiteralByProperty("has_Given_Name", actor.getUsername(), (actor.getGivenname() == null ? "" : actor.getGivenname()));
            onts.addLiteralByProperty("has_Home_Phone_Number", actor.getUsername(), (actor.getHomephone() == null ? "" : actor.getHomephone()));
            onts.addLiteralByProperty("has_Mailing_Address", actor.getUsername(), (actor.getMailingaddress() == null ? "" : actor.getMailingaddress()));
            onts.addLiteralByProperty("has_Middle_Name", actor.getUsername(), (actor.getMiddlename() == null ? "" : actor.getMiddlename()));
            onts.addLiteralByProperty("has_Mobile_Phone_Number", actor.getUsername(), (actor.getMobilephone() == null ? "" : actor.getMobilephone()));
            onts.addLiteralByProperty("has_Name", actor.getUsername(), (actor.getName() == null ? "" : actor.getName()));
            onts.addLiteralByProperty("has_Work_Phone_Number", actor.getUsername(), (actor.getWorkphone() == null ? "" : actor.getWorkphone()));
            onts.addLiteralByProperty("has_Ability", actor.getUsername(), (actor.getAbility() == null ? "" : actor.getAbility()));
            onts.addLiteralByProperty("has_Certificate_And_License", actor.getUsername(), (actor.getCetificateandlicense() == null ? "" : actor.getCetificateandlicense()));
            onts.addLiteralByProperty("has_Communication_Language", actor.getUsername(), (actor.getCommlanguage() == null ? "" : actor.getCommlanguage()));
            onts.addLiteralByProperty("has_Education_Background", actor.getUsername(), (actor.getEducationbg() == null ? "" : actor.getEducationbg()));
            onts.addLiteralByProperty("has_Ethnicity_Status", actor.getUsername(), (actor.getEthnicitystatus() == null ? "" : actor.getEthnicitystatus()));
            onts.addLiteralByProperty("has_Experience", actor.getUsername(), (actor.getExperience() == null ? "" : actor.getExperience()));
            onts.addLiteralByProperty("has_Gender", actor.getUsername(), (actor.getGender() == null ? "" : actor.getGender()));
            onts.addLiteralByProperty("has_Geographic_Affiliation", actor.getUsername(), (actor.getGeoaffiliation() == null ? "" : actor.getGeoaffiliation()));
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", actor.getUsername(), (actor.getInfoneed() == null ? "" : actor.getInfoneed()));
            onts.addLiteralByProperty("has_Knowledge", actor.getUsername(), (actor.getKnowledge() == null ? "" : actor.getKnowledge()));
            onts.addLiteralByProperty("has_Marital_Status", actor.getUsername(), (actor.getMaritalstatus() == null ? "" : actor.getMaritalstatus()));
            onts.addLiteralByProperty("has_Skill", actor.getUsername(), (actor.getSkill() == null ? "" : actor.getSkill()));
            onts.addLiteralByProperty("has_Training_Obtained", actor.getUsername(), (actor.getTrainingobt() == null ? "" : actor.getTrainingobt()));
            onts.addLiteralByProperty("has_COP_Affiliation", actor.getUsername(), (actor.getCopaffiliation() == null ? "" : actor.getCopaffiliation()));
            onts.addLiteralByProperty("has_Organization_Affiliation", actor.getUsername(), (actor.getOrgaffiliation() == null ? "" : actor.getOrgaffiliation()));
            if (actor.getRoles() != null) {
                Iterator iter = actor.getRoles().iterator();
                int counter = 0;
                while (iter.hasNext()) {
                    String role = (String) iter.next();
                    String aux = role + "_" + actor.getUsername();
                    onts.createIndividual(role, aux);
                    if (actor.getRoleauthority() != null) {
                        onts.addLiteralByProperty("has_Authority", aux, actor.getRoleauthority().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Authority", aux, "");
                    }
                    if (actor.getRoleeventaffiliation() != null) {
                        onts.addLiteralByProperty("has_Event_Affiliation", aux, actor.getRoleeventaffiliation().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Event_Affiliation", aux, "");
                    }
                    if (actor.getRoleexperience() != null) {
                        onts.addLiteralByProperty("has_Experience", aux, actor.getRoleexperience().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Experience", aux, "");
                    }
                    if (actor.getRoleinfoneed() != null) {
                        onts.addLiteralByProperty("has_Information_And_Knowledge_Need", aux, actor.getRoleinfoneed().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Information_And_Knowledge_Need", aux, "");
                    }
                    if (actor.getRoleknowledge() != null) {
                        onts.addLiteralByProperty("has_Knowledge", aux, actor.getRoleknowledge().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Knowledge", aux, "");
                    }
                    if (actor.getRoleliability() != null) {
                        onts.addLiteralByProperty("has_Liability", aux, actor.getRoleliability().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Liability", aux, "");
                    }
                    if (actor.getRoleorgaffiliation() != null) {
                        onts.addLiteralByProperty("has_Organization_Affiliation", aux, actor.getRoleorgaffiliation().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Organization_Affiliation", aux, "");
                    }
                    if (actor.getRoleprocaffiliation() != null) {
                        onts.addLiteralByProperty("has_Process_Affiliation", aux, actor.getRoleprocaffiliation().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Process_Affiliation", aux, "");
                    }
                    if (actor.getRoleprodaffiliation() != null) {
                        onts.addLiteralByProperty("has_Product_Affiliation", aux, actor.getRoleprodaffiliation().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Product_Affiliation", aux, "");
                    }
                    if (actor.getRoleprojaffiliation() != null) {
                        onts.addLiteralByProperty("has_Project_Affiliation", aux, actor.getRoleprojaffiliation().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Project_Affiliation", aux, "");
                    }
                    if (actor.getRoleresponsibility() != null) {
                        onts.addLiteralByProperty("has_Responsibility", aux, actor.getRoleresponsibility().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Responsibility", aux, "");
                    }
                    if (actor.getRoleright() != null) {
                        onts.addLiteralByProperty("has_Right", aux, actor.getRoleright().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Right", aux, "");
                    }
                    if (actor.getRoleskill() != null) {
                        onts.addLiteralByProperty("has_Skill", aux, actor.getRoleskill().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Skill", aux, "");
                    }
                    if (actor.getRoletrainingobt() != null) {
                        onts.addLiteralByProperty("has_Training_Obtained", aux, actor.getRoletrainingobt().get(counter));
                    } else {
                        onts.addLiteralByProperty("has_Training_Obtained", aux, "");
                    }
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
            actor.setActortype(getOnt().getIndividualClass(username));
            actor.setAge((Integer)getOnt().getLiteralByProperty(username, "has_Age"));
            actor.setEmail((String)getOnt().getLiteralByProperty(username, "has_Email_Address")) ;
            actor.setFamilyname((String)getOnt().getLiteralByProperty(username, "has_Family_Name")) ;
            actor.setFaxnumber((String)getOnt().getLiteralByProperty(username, "has_Fax_Number")) ;
            actor.setGivenname((String)getOnt().getLiteralByProperty(username, "has_Given_Name")) ;
            actor.setHomephone((String)getOnt().getLiteralByProperty(username, "has_Home_Phone_Number")) ;
            actor.setMailingaddress((String)getOnt().getLiteralByProperty(username, "has_Mailing_Address")) ;
            actor.setMiddlename((String)getOnt().getLiteralByProperty(username, "has_Middle_Name")) ;
            actor.setMobilephone((String)getOnt().getLiteralByProperty(username, "has_Mobile_Phone_Number")) ;
            actor.setName((String)getOnt().getLiteralByProperty(username, "has_Name")) ;
            actor.setWorkphone((String)getOnt().getLiteralByProperty(username, "has_Work_Phone_Number")) ;
            actor.setAbility((String) getOnt().getLiteralByProperty(username, "has_Ability")) ;
            actor.setCetificateandlicense((String)getOnt().getLiteralByProperty(username, "has_Certificate_And_License")) ;
            actor.setCommlanguage((String)getOnt().getLiteralByProperty(username, "has_Communication_Language")) ;
            actor.setEducationbg((String)getOnt().getLiteralByProperty(username, "has_Education_Background")) ;
            actor.setEthnicitystatus((String)getOnt().getLiteralByProperty(username, "has_Ethnicity_Status")) ;
            actor.setExperience((String)getOnt().getLiteralByProperty(username, "has_Experience")) ;
            actor.setGender((String)getOnt().getLiteralByProperty(username, "has_Gender")) ;
            actor.setGeoaffiliation((String)getOnt().getLiteralByProperty(username, "has_Geographic_Affiliation")) ;
            actor.setInfoneed((String)getOnt().getLiteralByProperty(username, "has_Information_And_Knowledge_Need")) ;
            actor.setKnowledge((String)getOnt().getLiteralByProperty(username, "has_Knowledge")) ;
            actor.setMaritalstatus((String)getOnt().getLiteralByProperty(username, "has_Marital_Status")) ;
            actor.setSkill((String)getOnt().getLiteralByProperty(username, "has_Skill")) ;
            actor.setTrainingobt((String)getOnt().getLiteralByProperty(username, "has_Training_Obtained")) ;
            actor.setCopaffiliation((String)getOnt().getLiteralByProperty(username, "has_COP_Affiliation")) ;
            actor.setOrgaffiliation((String)getOnt().getLiteralByProperty(username, "has_Organization_Affiliation")) ;
            ArrayList<String> list = new ArrayList<String>() ;
            getOnt().listAllInstancesOfClass(list, "Role");
            if(!list.isEmpty()){
                Iterator i = list.iterator() ;
                ArrayList<String> listroles = new ArrayList<String>() ;
                ArrayList<String> listroleauthority = new ArrayList<String>() ;
                ArrayList<String> listroleeventaffil = new ArrayList<String>() ;
                ArrayList<String> listroleexperience = new ArrayList<String>() ;
                ArrayList<String> listroleinfoneed = new ArrayList<String>() ;
                ArrayList<String> listroleknowledge = new ArrayList<String>() ;
                ArrayList<String> listroleliability = new ArrayList<String>() ;
                ArrayList<String> listroleorgaffil = new ArrayList<String>() ;
                ArrayList<String> listroleprocaffil = new ArrayList<String>() ;
                ArrayList<String> listroleprodaffil = new ArrayList<String>() ;
                ArrayList<String> listroleprojaffil = new ArrayList<String>() ;
                ArrayList<String> listroleresponsibility = new ArrayList<String>() ;
                ArrayList<String> listroleright = new ArrayList<String>() ;
                ArrayList<String> listroleskill = new ArrayList<String>() ;
                ArrayList<String> listroletrainingobt = new ArrayList<String>() ;
                while(i.hasNext()) {
                    String aux = (String)i.next() ;
                    if(aux.endsWith(username)) {
                        listroles.add(aux);
                        listroleauthority.add((String)getOnt().getLiteralByProperty(aux, "has_Authority"));
                        listroleeventaffil.add((String)getOnt().getLiteralByProperty(aux, "has_Event_Affiliation"));
                        listroleexperience.add((String)getOnt().getLiteralByProperty(aux, "has_Experience"));
                        listroleinfoneed.add((String)getOnt().getLiteralByProperty(aux, "has_Information_And_Knowledge_Need"));
                        listroleknowledge.add((String)getOnt().getLiteralByProperty(aux, "has_Knowledge"));
                        listroleliability.add((String)getOnt().getLiteralByProperty(aux, "has_Liability"));
                        listroleorgaffil.add((String)getOnt().getLiteralByProperty(aux, "has_Organization_Affiliation"));
                        listroleprocaffil.add((String)getOnt().getLiteralByProperty(aux, "has_Process_Affiliation"));
                        listroleprodaffil.add((String)getOnt().getLiteralByProperty(aux, "has_Product_Affiliation"));
                        listroleprojaffil.add((String)getOnt().getLiteralByProperty(aux, "has_Project_Affiliation"));
                        listroleresponsibility.add((String)getOnt().getLiteralByProperty(aux, "has_Responsibility"));
                        listroleright.add((String)getOnt().getLiteralByProperty(aux, "has_Right"));
                        listroleskill.add((String)getOnt().getLiteralByProperty(aux, "has_Skill"));
                        listroletrainingobt.add((String)getOnt().getLiteralByProperty(aux, "has_Training_Obtained"));

                    }
                }
                actor.setRoleauthority(listroleauthority);
                actor.setRoleeventaffiliation(listroleeventaffil);
                actor.setRoleexperience(listroleexperience);
                actor.setRoleinfoneed(listroleinfoneed);
                actor.setRoleknowledge(listroleknowledge);
                actor.setRoleliability(listroleliability);
                actor.setRoleorgaffiliation(listroleorgaffil);
                actor.setRoleprocaffiliation(listroleprocaffil);
                actor.setRoleprodaffiliation(listroleprodaffil);
                actor.setRoleprojaffiliation(listroleprojaffil);
                actor.setRoleresponsibility(listroleresponsibility);
                actor.setRoleright(listroleright);
                actor.setRoleskill(listroleskill);
                actor.setRoletrainingobt(listroletrainingobt);
            }
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

}
