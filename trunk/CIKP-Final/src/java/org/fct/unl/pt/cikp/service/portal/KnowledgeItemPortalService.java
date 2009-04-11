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
public interface KnowledgeItemPortalService {

    public KnowledgeItemPortal store(KnowledgeItemPortal ki, Session session) ;

    public KnowledgeItemPortal getKnowledgeItem(KnowledgeItemPortal ki, Session session) ;

}
