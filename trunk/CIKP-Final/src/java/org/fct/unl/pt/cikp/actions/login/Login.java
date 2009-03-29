/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.login;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Bruno
 */
public class Login extends ActionSupport implements SessionAware {

    private CikpService cikpService ;
    private String userUsername ;
    private String userPassword ;

    private Map<String, Object> session ;

    @Override
    public String execute() throws Exception {
        /*ArrayList<String> knowledges = getCikpService().listKnowledges() ;
        session.put(Constants.KNOWLEDGES, knowledges) ;*/
        ArrayList<String> geoAffiliations = getCikpService().listGeoAffiliations() ;
        session.put(Constants.GEOAFFILIATION, geoAffiliations) ;
        ArrayList<String> commLanguages = getCikpService().listCommLanguages() ;
        session.put(Constants.COMMLANG, commLanguages) ;
        UserPortal u = new UserPortal() ;
        u.setUserUsername(getUserUsername()) ;
        u.setUserPassword(getUserPassword()) ;
        u = getCikpService().authenticateUser(u) ;
        //IndividualActor actor = new IndividualActor() ;
        session.put(Constants.USER, u) ;
        return SUCCESS ;
    }

    @Override
    public void validate() {
        
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

    /**
     * @return the userUsername
     */
    public String getUserUsername() {
        return userUsername;
    }

    /**
     * @param userUsername the userUsername to set
     */
    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setSession(Map session) {
        this.session = (Map<String, Object>) session ;
    }

}
