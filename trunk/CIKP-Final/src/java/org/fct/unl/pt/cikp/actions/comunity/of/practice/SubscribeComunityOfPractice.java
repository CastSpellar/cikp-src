/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.comunity.of.practice;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Figueiras
 */
public class SubscribeComunityOfPractice extends ActionSupport implements ModelDriven, SessionAware {

    private CikpService cikpService ;

    private Map session ;

    public Object getModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSession(Map arg0) {
        this.session = arg0;
    }

    /**
     * @return the cikpService
     */
    public CikpService getCikpService() {
        return new CikpServiceImpl() ;
    }

    /**
     * @param cikpService the cikpService to set
     */
    public void setCikpService(CikpService cikpService) {
        this.cikpService = cikpService;
    }

}
