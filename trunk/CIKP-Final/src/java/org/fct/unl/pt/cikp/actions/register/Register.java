/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fct.unl.pt.cikp.actions.register;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Bruno
 */
public class Register extends ActionSupport implements ModelDriven {

    private UserPortal userPortal = new UserPortal();
    private String password2;
    private CikpService cikpService;

    @Override
    //@Validations(visitorFields = {@VisitorFieldValidator(message = "Default message", fieldName = "model", appendPrefix = false)})
    public String execute() throws Exception {
        getCikpService().registerUser(userPortal);
        return SUCCESS ;
        /*String p = getPassword2();
        boolean aux = isUserorgcheck() ;
        String str1 = ("organizationsuccess") ;
        String str2 = ("usersuccess") ;
        if (aux) {
            return str1 ;
        }
        else {
            return str2 ;
        }*/
    }

    @Override
    public void validate() {
        boolean existsUsername = getCikpService().existsUser(userPortal) ;
        if(existsUsername)
            addFieldError("user.userUsername", "Username allready taken");
    }

    public Object getModel() {
        return userPortal;
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

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
