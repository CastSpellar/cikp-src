/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.knowledge.item;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;

/**
 *
 * @author Figueiras
 */
public class KnowledgeItemSupport extends ActionSupport implements Preparable, SessionAware, ApplicationAware {

    private Map appVars ;

    private Map session ;

    private CikpService cikpService ;

    public void prepare() throws Exception {
        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl() ;
            po.setS_reload(false) ;
            po.setConfigFilePath(Constants.XML_FILE_PATH) ;
            appVars.put(Constants.PO, po) ;
        }
        //ArrayList<String> fileTypes = getCikpService().listClasses() ;
        ArrayList<String> subjectDomains = getCikpService().getSubClasses("Subject_Domain", po) ;
        session.put(Constants.SUBJECT_DOMAINS, subjectDomains) ;
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
