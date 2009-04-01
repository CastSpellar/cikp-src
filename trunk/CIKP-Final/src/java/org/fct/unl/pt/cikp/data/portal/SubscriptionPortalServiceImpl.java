/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fct.unl.pt.cikp.data.portal;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class SubscriptionPortalServiceImpl implements SubscriptionPortalService {

    private KeyWordPortalService kwService ;

    public SubscriptionPortal store(SubscriptionPortal subscription, Session session) {
        Set<KeywordPortal> keyWords = new HashSet<KeywordPortal>(0) ;
        for(KeywordPortal k: subscription.getKeywordPortals()) {
            KeyWordPortalService ks = getKwService() ;
            KeywordPortal kwp = ks.getKeyWord(k, session) ;
            //KeywordPortal kwP = getKwService().getKeyWord(k, session) ;
            if(kwp == null)
                kwp = getKwService().store(k, session) ;
            keyWords.add(kwp);
        }
        subscription.setKeywordPortals(keyWords) ;
        session.save(subscription);
        return subscription;
    }

    public SubscriptionPortal getSubscriptionPortal(SubscriptionPortal subscription, Session session) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the kwService
     */
    public KeyWordPortalService getKwService() {
        return new KeyWordPortalServiceImpl() ;
    }

    /**
     * @param kwService the kwService to set
     */
    public void setKwService(KeyWordPortalService kwService) {
        this.kwService = kwService;
    }
}
