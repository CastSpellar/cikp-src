/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.organization;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActor;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.data.portal.UserPortal;

/**
 *
 * @author Figueiras
 */
public class DefineOrganization extends ActionSupport implements ModelDriven, SessionAware {

    private CikpService cikpService ;

    private Map session ;

    private OrganizationActor actor = new OrganizationActor() ;

    @Override
    public String execute() throws Exception {
        UserPortal u = (UserPortal) session.get(Constants.USER) ;
        actor.setUsername(u.getUserUsername()) ;
        OrganizationActor createdOrganizationActor = getCikpService().createOrganizationActor(actor);
        session.put(Constants.ORGANIZATION, createdOrganizationActor) ;
        return SUCCESS ;
    }

    public Object getModel() {
        return actor ;
    }

    public void setSession(Map session) {
        this.session = session ;
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
