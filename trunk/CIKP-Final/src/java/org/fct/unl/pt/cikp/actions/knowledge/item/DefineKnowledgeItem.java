/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.knowledge.item;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Figueiras
 */
public class DefineKnowledgeItem extends ActionSupport implements ModelDriven, SessionAware {

    private CikpService cikpService ;

    private Map session ;

    private KnowledgeItem item = new KnowledgeItem() ;

    @Override
    public String execute() throws Exception {
        return SUCCESS ;
    }

    public Object getModel() {
        return item ;
    }

    public void setSession(Map arg0) {
        this.session = arg0;
    }

    /**
     * @return the cikpService
     */
    public CikpService getCikpService() {
        return new CikpServiceImpl();
    }

    /**
     * @param cikpService the cikpService to set
     */
    public void setCikpService(CikpService cikpService) {
        this.cikpService = cikpService;
    }
}
