/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
public class DefineActor extends ActionSupport implements ModelDriven, SessionAware, ApplicationAware {

    private CikpService cikpService ;

    private Map appVars ;

    private Map session ;

    private IndividualActor actor = new IndividualActor() ;

    @Override
    public String execute() throws Exception {
        String serverPath = ServletActionContext.getServletContext()
                .getRealPath("/jenaconf") ;
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl(serverPath) ;
            po.load() ;
            appVars.put(Constants.PO, po) ;
        } else {
            po.closeCon() ;
            po.reopenCon();
        }

        UserPortal u = (UserPortal) session.get(Constants.USER) ;
        actor.setUsername(u.getUserUsername()) ;
        IndividualActor createdIndividualActor = getCikpService().createIndividualActor(actor, po);
        session.put(Constants.ACTOR, createdIndividualActor) ;
        return SUCCESS ;
    }

    public Object getModel() {
        return actor ;
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

    public void setSession(Map session) {
        this.session = session ;
    }

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }

}
