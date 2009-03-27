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
public class UserServiceImpl implements UserService {

    public Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession() ;
    }

    public boolean existsUserName(UserPortal u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        UserPortal res = (UserPortal) session.createQuery(
        "select u from UserPortal as u where u.userUsername = ?").setString(0, u.getUserUsername())
        .uniqueResult() ;
        session.getTransaction().commit();
        return res == null ? false : true ;
    }

    public UserPortal register(UserPortal u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        session.save(u) ;
        session.getTransaction().commit();
        return u ;
    }

    public UserPortal authenticateUser(UserPortal u) {
        Session session  = getSession() ;
        session.beginTransaction() ;
        UserPortal user = (UserPortal) session.createQuery(
        "select u from UserPortal as u where u.userUsername = ? and u.userPassword = ?")
        .setString(0, u.getUserUsername())
        .setString(1, u.getUserPassword())
        .uniqueResult() ;
        session.getTransaction().commit();
        return user ;
    }

    public void updateUser(UserPortal u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
