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
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;

/**
 *
 * @author Figueiras
 */
public class DownloadOnt extends ActionSupport {
    private CikpService service ;

    public InputStream getInputStream() throws IOException {
        OutputStream out = new ByteArrayOutputStream() ;
        getService().writeOnt(out) ;

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
}
