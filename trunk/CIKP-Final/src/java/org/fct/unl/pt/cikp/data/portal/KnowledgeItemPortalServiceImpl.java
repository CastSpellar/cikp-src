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
public class KnowledgeItemPortalServiceImpl implements KnowledgeItemPortalService {

    private KeyWordPortalService kwService ;

    private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession() ;
    }

    public KnowledgeItemPortal store(KnowledgeItemPortal ki, Session session) {
        Set<KeywordPortal> keyWords = new HashSet<KeywordPortal>(0) ;
        for(KeywordPortal k: ki.getKeywordPortals()) {
            KeywordPortal kwP = getKwService().getKeyWord(k, session) ;
            if(kwP == null)
                kwP = getKwService().store(k, session) ;
            keyWords.add(kwP);
        }
        ki.setKeywordPortals(keyWords) ;
        session.save(ki) ;
        return ki ;
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

    public KnowledgeItemPortal getKnowledgeItem(KnowledgeItemPortal ki, Session session) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
