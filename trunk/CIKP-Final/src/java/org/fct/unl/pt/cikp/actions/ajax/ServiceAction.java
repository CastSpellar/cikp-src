/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.ajax;

/**
 *
 * @author CastSpellar
 */
import com.googlecode.jsonplugin.annotations.SMDMethod;
//import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.ajax.AttributeList;
import org.fct.unl.pt.cikp.data.ajax.RoleList;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.ontology.Role;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortal;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

public class ServiceAction extends ActionSupport implements ApplicationAware, SessionAware{

    private Map appVars ;

    private CikpService cikpService ;
    private Map session;

    public String service() {
        return SUCCESS;
    }

    @SMDMethod
    public AttributeControl getAttributeControl(String name) throws IOException, MissingParamException, ClassNotFoundException{
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        }else {
            if(po.getModel() == null)
                po.reopenCon();
        }
        UserPortal user = (UserPortal) session.get(Constants.USER);
        IndividualActor actor = getService().getIndividualActor(user.getUserUsername(), po);
        AttributeControl attr = new AttributeControl() ;
        if(name.endsWith("_inst")) {
            name = name.replace("_inst", "") ;
            OntologyControlsPortal control = getService().getControl(name) ;
            attr.setControlBind(control.getControlId());
            attr.setControlName(control.getPropertyName());
            attr.setControlType(control.getControlType());
            if(control.getControlType().compareTo("select") == 0) {
                attr.setValues(getService().listInstances(control.getPropertyName(), po));
            }
            //values = getService().listInstances(name) ;
        } else {
            OntologyControlsPortal control = getService().getControl(name) ;
            attr.setControlBind(control.getControlId());
            attr.setControlName(control.getPropertyName());
            attr.setControlType(control.getControlType());
            attr.setValue(getAttributeValue(name, actor));
            if(control.getControlType().compareTo("select") == 0) {
                attr.setValues(getService().getSubClasses(control.getPropertyName(), po));
            }
        }
        return attr ;

        /*try{
            return cikpService.getAttributeControl(name);
        } catch(Exception e){*/
            /*AttributeControl attrControl = new AttributeControl() ;
            attrControl.setControlName(name) ;
            String controlType = getService().getControl(name) ;
            attrControl.setControlType(controlType) ;
            List<String> values ;
            if(name.endsWith("_inst")) {
                name = name.replace("_inst", "") ;
                values = getService().listInstances(name) ;
            } else
                values = getService().getSubClasses(name) ;*/
            /*List<String> values = new ArrayList<String>() ;
            values.add("Teste1") ;
            values.add("Teste2") ;
            values.add("Teste3") ;*/
            /*attrControl.setValues(values);
            return attrControl ;*/
        //}
        
    }

    @SMDMethod
    public RoleList getRoles() throws MissingParamException, MissingParamException, IOException, ClassNotFoundException{
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        }else {
            if(po.getModel() == null)
                po.reopenCon();
        }
        UserPortal user = (UserPortal) session.get(Constants.USER);
        IndividualActor actor = getService().getIndividualActor(user.getUserUsername(), po);
        if(actor != null ) {
            if (actor.getRoles() != null){
                List<String> roles = new LinkedList<String>();
                for(Role role : actor.getRoles())
                    roles.add(role.getRoletype());
                RoleList roleList = new RoleList();
                roleList.setRoles(roles);
                return roleList;
            }
        }
        return null;
    }

    @SMDMethod
    public AttributeList getExistingAttributes() throws MissingParamException, ClassNotFoundException, IOException{
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        }else {
            if(po.getModel() == null)
                po.reopenCon();
        }
        UserPortal user = (UserPortal) session.get(Constants.USER);
        IndividualActor actor = getService().getIndividualActor(user.getUserUsername(), po);
        if(actor != null) {
            List<String> attrlist = new LinkedList<String>();

            String tester = actor.getAbility();
            if (tester != null) attrlist.add("Ability_Type");
            //actor.getActortype();
            //actor.getAge();
            tester = actor.getCertificate_and_license();
            if (tester != null) attrlist.add("Certificate_And_License_Type");
            //actor.getCommunication_language();
            //tester = actor.getCop_affiliation();
            //if (tester != null) attrlist.add("Cop_Affiliation"); // FIXME
            tester = actor.getEducation_background();
            if (tester != null) attrlist.add("Education_Background_Type");
            tester = actor.getEmail_address();
            if (tester != null) attrlist.add("Email_Address");
            tester = actor.getEthnicity();
            if (tester != null) attrlist.add("Ethnic_Group");
            tester = actor.getExperience();
            if (tester != null) attrlist.add("Experience_Type");
            //actor.getFamily_name();
            tester = actor.getFax_number();
            if (tester != null) attrlist.add("Fax_Number");
            //actor.getGender();
            //actor.getGeographic_affiliation();
            //actor.getGiven_name();
            tester = actor.getHome_phone_number();
            if (tester != null) attrlist.add("Home_Phone_Number");
            tester = actor.getInformation_and_knowledge_need();
            if (tester != null) attrlist.add("Knowledge_Item_inst");
            tester = actor.getKnowledge();
            if (tester != null) attrlist.add("Knowledge_Type");
            tester = actor.getMailing_address();
            if (tester != null) attrlist.add("Mailing_Address");
            tester = actor.getMarital_status();
            if (tester != null) attrlist.add("Marital_Status_Value");
            tester = actor.getMiddle_name();
            if (tester != null) attrlist.add("Middle_Name");
            tester = actor.getMobile_phone_number();
            if (tester != null) attrlist.add("Mobile_Phone_Number");
            //actor.getName();
            tester = actor.getOrganizational_affiliation();
            if (tester != null) attrlist.add("Organization_Actor_inst");
            //actor.getRoles();
            tester = actor.getSkill();
            if (tester != null) attrlist.add("Skill_Type");
            tester = actor.getTraining_obtained();
            if (tester != null) attrlist.add("Training_Type");
            tester = actor.getWork_phone_number();
            if (tester != null) attrlist.add("Office_Phone_Number");

            AttributeList attributes = new AttributeList();
            attributes.setAttributes(attrlist);
            return attributes;
        }
        return null;
    }

    private String getAttributeValue(String attributeName, IndividualActor actor){
            if (attributeName.equals("Ability_Type")) return actor.getAbility();
            if (attributeName.equals("Certificate_And_License_Type")) return actor.getCertificate_and_license();
            if (attributeName.equals("Education_Background_Type")) return actor.getEducation_background();
            if (attributeName.equals("Email_Address")) return actor.getEmail_address();
            if (attributeName.equals("Ethnic_Group")) return actor.getEthnicity();
            if (attributeName.equals("Experience_Type")) return actor.getExperience();
            if (attributeName.equals("Fax_Number")) return actor.getFax_number();
            if (attributeName.equals("Home_Phone_Number")) return actor.getHome_phone_number();
            if (attributeName.equals("Knowledge_Item_inst")) return actor.getInformation_and_knowledge_need();
            if (attributeName.equals("Knowledge_Type")) return actor.getKnowledge();
            if (attributeName.equals("Mailing_Address")) return actor.getMailing_address();
            if (attributeName.equals("Marital_Status_Value")) return actor.getMarital_status();
            if (attributeName.equals("Middle_Name")) return actor.getMiddle_name();
            if (attributeName.equals("Mobile_Phone_Number")) return actor.getMobile_phone_number();
            if (attributeName.equals("Organization_Actor_inst")) return actor.getOrganizational_affiliation();
            if (attributeName.equals("Skill_Type")) return actor.getSkill();
            if (attributeName.equals("Training_Type")) return actor.getTraining_obtained();
            if (attributeName.equals("Office_Phone_Number")) return actor.getWork_phone_number();
            return null;
    }

    /**
     * @return the service
     */
    public CikpService getService() {
        return new CikpServiceImpl() ;
    }

    /**
     * @param service the service to set
     */
    public void setService(CikpService cikpService) {
        this.cikpService = cikpService;
    }

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }

    public void setSession(Map arg0) {
        this.session = arg0;
    }
}
