/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.portal;

import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class FilePortalServiceImpl implements FilePortalService {

    public FilePortal store(FilePortal fp, Session session) {
        session.save(fp) ;
        return fp ;
    }

}
