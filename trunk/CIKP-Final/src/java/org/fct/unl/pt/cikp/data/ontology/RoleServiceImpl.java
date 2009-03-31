/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Figueiras
 */
public class RoleServiceImpl implements RoleService {

    private OntServiceImpl ont ;

    public Role createRole(Role role, PersistentOntology p) {
        try {
            OntService onts = getOnt();
            onts.createIndividual(role.getRoletype(), role.getRoleentityname(), p);
            if(role.getAuthority() != null) {
                onts.addLiteralByProperty("has_Authority", role.getRoleentityname(), role.getAuthority() == null ? "" : role.getAuthority(), p);
            }
            if(role.getEvent_affiliation() != null) {
                onts.addLiteralByProperty("has_Event_Affiliation", role.getRoleentityname(), role.getEvent_affiliation() == null ? "" : role.getEvent_affiliation(), p);
            }
            if(role.getExperience() != null) {
                onts.addLiteralByProperty("has_Experience", role.getRoleentityname(), role.getExperience() == null ? "" : role.getExperience(), p);
            }
            if(role.getInformation_and_knowledge_need() != null) {
                onts.addLiteralByProperty("has_Information_And_Knowledge_Need", role.getRoleentityname(), role.getInformation_and_knowledge_need() == null ? "" : role.getInformation_and_knowledge_need(), p);
            }
            if(role.getKnowledge() != null) {
                onts.addLiteralByProperty("has_Knowledge", role.getRoleentityname(), role.getKnowledge() == null ? "" : role.getKnowledge(), p);
            }
            if(role.getLiability() != null) {
                onts.addLiteralByProperty("has_Liability", role.getRoleentityname(), role.getLiability() == null ? "" : role.getLiability(), p);
            }
            if(role.getOrganizational_affiliation() != null) {
                onts.addLiteralByProperty("has_Organization_Affiliation", role.getRoleentityname(), role.getOrganizational_affiliation() == null ? "" : role.getOrganizational_affiliation(), p);
            }
            if(role.getProcess_affiliation() != null) {
                onts.addLiteralByProperty("has_Process_Affiliation", role.getRoleentityname(), role.getProcess_affiliation() == null ? "" : role.getProcess_affiliation(), p);
            }
            if(role.getProduct_affiliation() != null) {
                onts.addLiteralByProperty("has_Product_Affiliation", role.getRoleentityname(), role.getProduct_affiliation() == null ? "" : role.getProduct_affiliation(), p);
            }
            if(role.getProject_affiliation() != null) {
                onts.addLiteralByProperty("has_Project_Affiliation", role.getRoleentityname(), role.getProject_affiliation() == null ? "" : role.getProject_affiliation(), p);
            }
            if(role.getResponsibility() != null) {
                onts.addLiteralByProperty("has_Responsibility", role.getRoleentityname(), role.getResponsibility() == null ? "" : role.getResponsibility(), p);
            }
            if(role.getRight()!= null) {
                onts.addLiteralByProperty("has_Right", role.getRoleentityname(), role.getRight() == null ? "" : role.getRight(), p);
            }
            if(role.getSkill() != null) {
                onts.addLiteralByProperty("has_Skill", role.getRoleentityname(), role.getSkill() == null ? "" : role.getSkill(), p);
            }
            if(role.getTraining_obtained() != null) {
                onts.addLiteralByProperty("has_Training_Obtained", role.getRoleentityname(), role.getTraining_obtained() == null ? "" : role.getTraining_obtained(), p);
            }
        } catch (IOException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role ;
    }

    public Role getRoleByName(String rolename, PersistentOntology p) {
        Role role = new Role() ;
        OntService onts = getOnt() ;
        try {
            if(onts.getIndividual(rolename, p) != null) {
                role.setRoletype(getOnt().getIndividualClass(rolename, p)) ;
                role.setAuthority((String)getOnt().getLiteralByProperty(rolename, "has_Authority", p)) ;
                role.setEvent_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Event_Affiliation", p)) ;
                role.setExperience((String)getOnt().getLiteralByProperty(rolename, "has_Experience", p)) ;
                role.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(rolename, "has_Information_And_Knowledge_Need", p)) ;
                role.setKnowledge((String)getOnt().getLiteralByProperty(rolename, "has_Knowledge", p)) ;
                role.setLiability((String)getOnt().getLiteralByProperty(rolename, "has_Liability", p)) ;
                role.setOrganizational_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Orgenizational_Affiliation", p)) ;
                role.setProcess_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Process_Affiliation", p)) ;
                role.setProduct_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Product_Affiliation", p)) ;
                role.setProject_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Project_Affiliation", p)) ;
                role.setResponsibility((String)getOnt().getLiteralByProperty(rolename, "has_Responsibility", p)) ;
                role.setRight((String)getOnt().getLiteralByProperty(rolename, "has_Right", p)) ;
                role.setSkill((String)getOnt().getLiteralByProperty(rolename, "has_Skill", p)) ;
                role.setTraining_obtained((String)getOnt().getLiteralByProperty(rolename, "has_Training_Obtained", p));
                return role ;
            }
            else return null ;
        } catch (IOException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex); return null ;
        }
    }

    public ArrayList<Role> listActorRoles(String username, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException {
        ArrayList<Role> rolelist = new ArrayList<Role>() ;
        ArrayList<String> list = new ArrayList<String>() ;
        getOnt().listAllInstancesOfClass(list, "Role", p) ;
        if(!list.isEmpty()){
            Iterator i = list.iterator() ;
            while(i.hasNext()) {
                String aux = (String) i.next() ;
                if(aux.endsWith(username)) {
                    rolelist.add(getRoleByName(aux, p)) ;
                }
            }
        }
        return rolelist ;
    }

    /**
     * @return the ont
     */
    public OntServiceImpl getOnt() {
        return new OntServiceImpl();
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntServiceImpl ont) {
        this.ont = ont;
    }


}
