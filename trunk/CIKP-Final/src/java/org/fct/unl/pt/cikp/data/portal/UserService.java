/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.portal;

import org.fct.unl.pt.cikp.data.portal.*;

/**
 *
 * @author Bruno
 */
public interface UserService {

    public boolean existsUserName(User u) ;

    public User register(User u) ;

    public User authenticateUser(User u) ;
    
    public void updateUser(User u) ;

}
