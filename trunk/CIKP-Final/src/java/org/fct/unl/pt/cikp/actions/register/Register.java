/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fct.unl.pt.cikp.actions.register;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import org.fct.unl.pt.cikp.data.portal.User;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Bruno
 */
public class Register extends ActionSupport implements ModelDriven {

    private User user = new User();
    private String password2;
    private CikpService cikpService;

    @Override
    //@Validations(visitorFields = {@VisitorFieldValidator(message = "Default message", fieldName = "model", appendPrefix = false)})
    public String execute() throws Exception {
        getCikpService().registerUser(user);
        String p = getPassword2();
        return SUCCESS;
    }

    @Override
    public void validate() {
        /*if ( getPassword().length() == 0 ){
        addFieldError( "password", getText("password.required") );
        }
        if ( getUsername().length() == 0 ){
        addFieldError( "username", getText("username.required") );
        }*/
    }

    public Object getModel() {
        return user;
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
