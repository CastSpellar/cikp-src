/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

/**
 *
 * @author Bruno
 */
public interface IndividualActorService {

    public IndividualActor createActor(IndividualActor actor) ;

    public IndividualActor getIndividualActorByName(String username) ;

}
