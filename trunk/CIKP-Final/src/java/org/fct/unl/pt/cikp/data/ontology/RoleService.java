/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.ArrayList;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Figueiras
 */
public interface RoleService {

    public Role createRole(Role role, PersistentOntology p) ;
    public Role getRoleByName(String rolename, PersistentOntology p) ;
    public ArrayList<Role> listActorRoles(String username, PersistentOntology p) throws IOException, MissingParamException, ClassNotFoundException;
}
