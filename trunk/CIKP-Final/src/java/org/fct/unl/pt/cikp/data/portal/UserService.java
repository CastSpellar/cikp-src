/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.portal;

import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface UserService {

    public boolean existsUserName(UserPortal u, Session session) ;

    public UserPortal register(UserPortal u, Session session) ;

    public UserPortal authenticateUser(UserPortal u, Session session) ;
    
    public void updateUser(UserPortal u, Session session) ;

}
