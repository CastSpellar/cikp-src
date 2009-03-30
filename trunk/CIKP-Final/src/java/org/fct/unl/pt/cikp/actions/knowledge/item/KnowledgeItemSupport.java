/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.knowledge.item;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Figueiras
 */
public class KnowledgeItemSupport extends ActionSupport implements Preparable, SessionAware {

    private Map session ;

    private CikpService cikpService ;

    public void prepare() throws Exception {
        //ArrayList<String> fileTypes = getCikpService().listClasses() ;
        ArrayList<String> subjectDomains = getCikpService().getSubClasses("Subject_Domain") ;
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

}
