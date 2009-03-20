/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.register;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.fct.unl.pt.cikp.data.portal.User;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Bruno
 */
public class Register extends ActionSupport implements ModelDriven {

    private User user = new User() ;

    private CikpService cikpService ;
    
    @Override
    public String execute() throws Exception {
        getCikpService().registerUser(user) ;
        return SUCCESS ;
    }

    @Override
    public Object getModel() {
        return user ;
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
