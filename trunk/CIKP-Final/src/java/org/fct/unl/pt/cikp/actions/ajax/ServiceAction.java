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
import java.util.ArrayList;
import java.util.List;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.data.ajax.AttributeControl;
import org.fct.unl.pt.cikp.data.portal.OntologyControlsPortal;

public class ServiceAction extends ActionSupport{

    private CikpService cikpService ;

    public String service() {
        return SUCCESS;
    }

    @SMDMethod
    public AttributeControl getAttributeControl(String name){
        AttributeControl attr = new AttributeControl() ;
        if(name.endsWith("_inst")) {
            name = name.replace("_inst", "") ;
            OntologyControlsPortal control = getService().getControl(name) ;
            attr.setControlBind(control.getControlId());
            attr.setControlName(control.getPropertyName());
            attr.setControlType(control.getControlType());
            if(control.getControlType().compareTo("select") == 0) {
                attr.setValues(getService().listInstances(control.getPropertyName()));
            }
            //values = getService().listInstances(name) ;
        } else {
            OntologyControlsPortal control = getService().getControl(name) ;
            attr.setControlBind(control.getControlId());
            attr.setControlName(control.getPropertyName());
            attr.setControlType(control.getControlType());
            if(control.getControlType().compareTo("select") == 0) {
                attr.setValues(getService().getSubClasses(control.getPropertyName()));
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
}
