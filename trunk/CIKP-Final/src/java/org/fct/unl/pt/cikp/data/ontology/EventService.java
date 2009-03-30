/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

/**
 *
 * @author Figueiras
 */
public interface EventService {
    public Event createEvent(Event ev, PersistentOntology p) ;
}
