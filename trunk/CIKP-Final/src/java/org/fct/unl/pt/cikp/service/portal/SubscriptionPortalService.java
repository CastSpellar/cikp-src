/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.portal;

import org.fct.unl.pt.cikp.data.portal.*;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface SubscriptionPortalService {

    public SubscriptionPortal store(SubscriptionPortal subscription, Session session) ;

    public SubscriptionPortal getSubscriptionPortal(SubscriptionPortal subscription, Session session) ;

}
