/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.organization;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.data.ontology.OrganizationActor;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.data.portal.UserPortal;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;

/**
 *
 * @author Figueiras
 */
public class DefineOrganization extends ActionSupport implements ModelDriven, SessionAware, ApplicationAware {

    private CikpService cikpService ;

    private Map session ;

    private Map appVars ;

    private OrganizationActor actor = new OrganizationActor() ;

    @Override
    public String execute() throws Exception {
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl() ;
            po.setS_reload(false) ;
            appVars.put(Constants.PO, po) ;
        }else {
            po.reopenCon();
        }
        UserPortal u = (UserPortal) session.get(Constants.USER) ;
        actor.setUsername(u.getUserUsername()) ;
        OrganizationActor createdOrganizationActor = getCikpService().createOrganizationActor(actor, po);
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

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }


}
