/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.administrator;

import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author Figueiras
 */
public class DownloadOnt extends ActionSupport {
    public InputStream getInputStream() {
        InputStream is = new ByteArrayInputStream(new String("<teste><teste2>teste</teste2></teste>").getBytes()) ;
        return is ;
    }
}
