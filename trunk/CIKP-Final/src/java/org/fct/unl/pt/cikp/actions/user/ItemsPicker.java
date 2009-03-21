/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.user;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Bruno
 */
public class ItemsPicker extends ActionSupport implements ServletRequestAware, SessionAware{

    private Map session ;
    private HttpServletRequest request ;
    private CikpService service ;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request ;
    }

    @Override
    public String execute() throws Exception {
        String attrClass = request.getParameter(Constants.ATTR_CLASS) ;
        
        return SUCCESS ;
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
    public void setService(CikpService service) {
        this.service = service;
    }

    public void setSession(Map session) {
        this.session = session ;
    }

}
