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
public class SubscriptionPortalServiceImpl implements SubscriptionPortalService{

    public SubscriptionPortal store(SubscriptionPortal subscription, Session session) {
        session.save(subscription) ;
        return subscription ;
    }

    public SubscriptionPortal getSubscriptionPortal(SubscriptionPortal subscription, Session session) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
