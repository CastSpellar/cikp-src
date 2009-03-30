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
public interface OntologyControlsPortalService {

    public OntologyControlsPortal getControl(String name, Session session) ;

}
