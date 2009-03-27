/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.portal;

/**
 *
 * @author Bruno
 */
public interface UserService {

    public boolean existsUserName(UserPortal u) ;

    public UserPortal register(UserPortal u) ;

    public UserPortal authenticateUser(UserPortal u) ;
    
    public void updateUser(UserPortal u) ;

}
