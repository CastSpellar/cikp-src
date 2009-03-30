/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

/**
 *
 * @author Bruno
 */
public interface IndividualActorService {

    public IndividualActor createActor(IndividualActor actor, PersistentOntology p) ;

    public IndividualActor getIndividualActorByName(String username, PersistentOntology p) ;

}
