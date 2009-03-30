package org.fct.unl.pt.cikp.data.ontology;

import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

/**
 *
 * @author Paulo Figueiras
 */

public interface KnowledgeItemService {
    public KnowledgeItem createKnowledgeItem(KnowledgeItem ki, PersistentOntology p) ;
}
