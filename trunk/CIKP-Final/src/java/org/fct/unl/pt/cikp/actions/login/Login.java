/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.login;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;

/**
 *
 * @author Bruno
 */
public class Login extends ActionSupport implements SessionAware, ApplicationAware {

    private CikpService cikpService ;
    private String userUsername ;
    private String userPassword ;

    private Map appVars ;

    private Map<String, Object> session ;

    @Override
    public String execute() throws Exception {
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.setS_reload(false) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        }else {
            if(po.getModel() == null)
                po.reopenCon();
        }
        /*ArrayList<String> knowledges = getCikpService().listKnowledges() ;
        session.put(Constants.KNOWLEDGES, knowledges) ;*/
        ArrayList<String> geoAffiliations = getCikpService().listGeoAffiliations(po) ;
        session.put(Constants.GEOAFFILIATION, geoAffiliations) ;
        ArrayList<String> commLanguages = getCikpService().listCommLanguages(po) ;
        session.put(Constants.COMMLANG, commLanguages) ;
        UserPortal u = new UserPortal() ;
        u.setUserUsername(getUserUsername()) ;
        u.setUserPassword(getUserPassword()) ;
        u = getCikpService().authenticateUser(u) ;
        session.put(Constants.USER, u) ;
        return SUCCESS ;
    }

    @Override
    public void validate() {
        UserPortal user = new UserPortal() ;
        user.setUserUsername(userUsername) ;
        user.setUserPassword(userPassword);
        boolean existsUser = getCikpService().existsUser(user) ;
        if(!existsUser)
            addFieldError(userUsername, "Username does not exists.");
        else {
            user = getCikpService().authenticateUser(user) ;
            if(user == null)
                addFieldError("userPassword", "Incorrect password");
        }
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

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }

}
