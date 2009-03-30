/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.administrator;

import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.fct.unl.pt.cikp.constants.Constants;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntologyImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Figueiras
 */
public class DownloadOnt extends ActionSupport implements ApplicationAware {

    private Map appVars ;

    private CikpService service ;

    public InputStream getInputStream() throws IOException, MissingParamException, ClassNotFoundException {

        PersistentOntology po = (PersistentOntology) appVars.get(Constants.PO) ;
        if(po == null) {
            po = new PersistentOntologyImpl() ;
            po.setS_reload(false) ;
            po.setConfigFilePath(Constants.XML_FILE_PATH) ;
            appVars.put(Constants.PO, po) ;
        }
        OutputStream out = new ByteArrayOutputStream() ;
        getService().writeOnt(out, po) ;

        InputStream is = new ByteArrayInputStream(out.toString().getBytes()) ;

        //InputStream is = new ByteArrayInputStream(new String("<teste><teste2>teste</teste2></teste>").getBytes()) ;
        return is ;
    }

    /**
     * @return the service
     */
    public CikpService getService() {
        return new CikpServiceImpl();
    }

    /**
     * @param service the service to set
     */
    public void setService(CikpService service) {
        this.service = service;
    }

    public void setApplication(Map arg0) {
        this.appVars = arg0 ;
    }
}
