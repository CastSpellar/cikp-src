/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ajax;

import java.util.List;

/**
 *
 * @author Bruno
 */
public class AttributeControl {

    private String controlName ;
    private String controlType ;
    private List<String> values ;

    /**
     * @return the controlName
     */
    public String getControlName() {
        return controlName;
    }

    /**
     * @param controlName the controlName to set
     */
    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    /**
     * @return the controlType
     */
    public String getControlType() {
        return controlType;
    }

    /**
     * @param controlType the controlType to set
     */
    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    /**
     * @return the values
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(List<String> values) {
        this.values = values;
    }

}
