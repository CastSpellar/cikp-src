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
public class KeyWordPortalServiceImpl implements KeyWordPortalService {

    private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession() ;
    }

    public KeywordPortal store(KeywordPortal k, Session session) {
        session.save(k) ;
        return k ;
    }

    public KeywordPortal getKeyWord(KeywordPortal k, Session session) {
        KeywordPortal res = (KeywordPortal) session.createQuery(
        "select k from KeywordPortal as k where k.keyword = ?").setString(0, k.getKeyword())
        .uniqueResult() ;
        return res ;
    }

}
