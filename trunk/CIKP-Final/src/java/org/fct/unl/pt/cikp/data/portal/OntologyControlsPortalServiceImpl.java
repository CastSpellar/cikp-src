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
public class OntologyControlsPortalServiceImpl implements OntologyControlsPortalService {

    public OntologyControlsPortal getControl(String name, Session session) {
        OntologyControlsPortal res = (OntologyControlsPortal) session.createQuery(
        "select c from OntologyControlsPortal as c where c.propertyName = ?").setString(0, name)
        .uniqueResult() ;
        return res ;
    }

}
