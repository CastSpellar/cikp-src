/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
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
public class UserSupport extends ActionSupport implements Preparable, SessionAware, ApplicationAware, ModelDriven<IndividualActor> {

    private Map session ;
    private Map appVars ;
    private CikpService cikpService ;
    private IndividualActor actor ;

    public void prepare() throws Exception {
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        } else {
            po.reopenCon() ;
        }
        UserPortal user = (UserPortal) session.get(Constants.USER) ;
        UserPortal updatedUser = getCikpService().authenticateUser(user) ;
        session.put(Constants.USER, updatedUser) ;
        IndividualActor actor = getCikpService().getIndividualActor(user.getUserUsername(), po) ;
        if(actor == null)
            actor = new IndividualActor() ;
        else
            this.actor = actor ;
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

    public IndividualActor getModel() {
        return actor ;
    }

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }

}
