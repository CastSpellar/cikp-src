/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.tests;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Bruno
 */
public class TestSelect extends ActionSupport implements SessionAware, ModelDriven {

    private Map<String, Object> session ;

    private List<String> list = new LinkedList<String>() ;

    /**
     * @return the list
     */
    public List<String> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<String> list) {
        this.list = list;
    }

    public Object getModel() {
        list.add("Teste1");
        list.add("Teste2");
        return list ;
    }

    public void setSession(Map arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
