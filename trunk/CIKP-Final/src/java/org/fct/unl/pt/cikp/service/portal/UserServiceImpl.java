/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.service.portal;

import org.fct.unl.pt.cikp.data.portal.*;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class UserServiceImpl implements UserService {

    public boolean existsUserName(UserPortal u, Session session) {
        UserPortal res = (UserPortal) session.createQuery(
        "select u from UserPortal as u where u.userUsername = ?").setString(0, u.getUserUsername())
        .uniqueResult() ;
        return res == null ? false : true ;
    }

    public UserPortal register(UserPortal u, Session session) {
        session.save(u) ;
        return u ;
    }

    public UserPortal authenticateUser(UserPortal u, Session session) {
        UserPortal user = (UserPortal) session.createQuery(
        "select u from UserPortal as u where u.userUsername = ? and u.userPassword = ?")
        .setString(0, u.getUserUsername())
        .setString(1, u.getUserPassword())
        .uniqueResult() ;
        return user ;
    }

    public void updateUser(UserPortal u, Session session) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
