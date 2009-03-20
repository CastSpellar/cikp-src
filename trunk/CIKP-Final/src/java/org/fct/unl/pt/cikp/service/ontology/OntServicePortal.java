/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.ontology;

import java.util.ArrayList;
import org.fct.unl.pt.cikp.data.ontology.IndividualActor;

/**
 *
 * @author Bruno
 */
public interface OntServicePortal {

    public ArrayList<String> listSkills() ;

    public ArrayList<String> listAuthoritys() ;

    public ArrayList<String> listKnowledges() ;

    public IndividualActor createIndividualActor(IndividualActor actor) ;

}
