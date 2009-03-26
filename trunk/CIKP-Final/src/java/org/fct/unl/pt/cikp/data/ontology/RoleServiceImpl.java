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
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Figueiras
 */
public class RoleServiceImpl implements RoleService {

    private OntServiceImpl ont ;

    public Role createRole(Role role) {
        try {
            OntServiceImpl onts = getOnt();
            onts.createIndividual(role.getRoletype(), role.getRoleentityname());
            onts.addLiteralByProperty("has_Authority", role.getRoleentityname(), role.getAuthority() == null ? "" : role.getAuthority());
            onts.addLiteralByProperty("has_Event_Affiliation", role.getRoleentityname(), role.getEvent_affiliation() == null ? "" : role.getEvent_affiliation());
            onts.addLiteralByProperty("has_Experience", role.getRoleentityname(), role.getExperience() == null ? "" : role.getExperience());
            onts.addLiteralByProperty("has_Information_And_Knowledge_Need", role.getRoleentityname(), role.getInformation_and_knowledge_need() == null ? "" : role.getInformation_and_knowledge_need());
            onts.addLiteralByProperty("has_Knowledge", role.getRoleentityname(), role.getKnowledge() == null ? "" : role.getKnowledge());
            onts.addLiteralByProperty("has_Liability", role.getRoleentityname(), role.getLiability() == null ? "" : role.getLiability());
            onts.addLiteralByProperty("has_Organization_Affiliation", role.getRoleentityname(), role.getOrganizational_affiliation() == null ? "" : role.getOrganizational_affiliation());
            onts.addLiteralByProperty("has_Process_Affiliation", role.getRoleentityname(), role.getProcess_affiliation() == null ? "" : role.getProcess_affiliation());
            onts.addLiteralByProperty("has_Product_Affiliation", role.getRoleentityname(), role.getProduct_affiliation() == null ? "" : role.getProduct_affiliation());
            onts.addLiteralByProperty("has_Project_Affiliation", role.getRoleentityname(), role.getProject_affiliation() == null ? "" : role.getProject_affiliation());
            onts.addLiteralByProperty("has_Responsibility", role.getRoleentityname(), role.getResponsibility() == null ? "" : role.getResponsibility());
            onts.addLiteralByProperty("has_Right", role.getRoleentityname(), role.getRight() == null ? "" : role.getRight());
            onts.addLiteralByProperty("has_Skill", role.getRoleentityname(), role.getSkill() == null ? "" : role.getSkill());
            onts.addLiteralByProperty("has_Training_Obtained", role.getRoleentityname(), role.getTraining_obtained() == null ? "" : role.getTraining_obtained());
        } catch (IOException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role ;
    }

    public Role getRoleByName(String rolename) {
        Role role = new Role() ;
        try {
            role.setRoletype(getOnt().getIndividualClass(rolename)) ;
            role.setAuthority((String)getOnt().getLiteralByProperty(rolename, "has_Authority")) ;
            role.setEvent_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Event_Affiliation")) ;
            role.setExperience((String)getOnt().getLiteralByProperty(rolename, "has_Experience")) ;
            role.setInformation_and_knowledge_need((String)getOnt().getLiteralByProperty(rolename, "has_Information_And_Knowledge_Need")) ;
            role.setKnowledge((String)getOnt().getLiteralByProperty(rolename, "has_Knowledge")) ;
            role.setLiability((String)getOnt().getLiteralByProperty(rolename, "has_Liability")) ;
            role.setOrganizational_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Orgenizational_Affiliation")) ;
            role.setProcess_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Process_Affiliation")) ;
            role.setProduct_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Product_Affiliation")) ;
            role.setProject_affiliation((String)getOnt().getLiteralByProperty(rolename, "has_Project_Affiliation")) ;
            role.setResponsibility((String)getOnt().getLiteralByProperty(rolename, "has_Responsibility")) ;
            role.setRight((String)getOnt().getLiteralByProperty(rolename, "has_Right")) ;
            role.setSkill((String)getOnt().getLiteralByProperty(rolename, "has_Skill")) ;
            role.setTraining_obtained((String)getOnt().getLiteralByProperty(rolename, "has_Training_Obtained"));
        } catch (IOException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return role ;
    }

    public ArrayList<Role> listActorRoles(String username) throws IOException, MissingParamException, ClassNotFoundException {
        ArrayList<Role> rolelist = new ArrayList<Role>() ;
        ArrayList<String> list = new ArrayList<String>() ;
        getOnt().listAllInstancesOfClass(list, "Role") ;
        if(!list.isEmpty()){
            Iterator i = list.iterator() ;
            while(i.hasNext()) {
                String aux = (String) i.next() ;
                if(aux.endsWith(username)) {
                    rolelist.add(getRoleByName(aux)) ;
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
