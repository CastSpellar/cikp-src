/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.ArrayList;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Figueiras
 */
public interface RoleService {

    public Role createRole(Role role) ;
    public Role getRoleByName(String rolename) ;
    public ArrayList<Role> listActorRoles(String username) throws IOException, MissingParamException, ClassNotFoundException;
}
