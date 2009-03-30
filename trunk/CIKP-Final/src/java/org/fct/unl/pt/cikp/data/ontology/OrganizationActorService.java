package org.fct.unl.pt.cikp.data.ontology;

import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;

/**
 *
 * @author Paulo Figueiras
 */

public interface OrganizationActorService {
    public OrganizationActor createOrganizationActor(OrganizationActor actor, PersistentOntology p) ;

    public OrganizationActor getOrganizationActorByName(String username, PersistentOntology p) ;
}
