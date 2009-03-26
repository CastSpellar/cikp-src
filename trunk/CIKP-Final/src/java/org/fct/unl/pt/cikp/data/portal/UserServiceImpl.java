/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.data.portal;

import org.fct.unl.pt.cikp.data.portal.*;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class UserServiceImpl implements UserService {

    public Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession() ;
    }

    public boolean existsUserName(User u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        User res = (User) session.createQuery(
        "select u from User as u where u.userUsername = ?").setString(0, u.getUserUsername())
        .uniqueResult() ;
        session.getTransaction().commit();
        return res == null ? false : true ;
    }

    public User register(User u) {
        Session session = getSession() ;
        session.beginTransaction() ;
        session.save(u) ;
        session.getTransaction().commit();
        return u ;
    }

    public User authenticateUser(User u) {
        Session session  = getSession() ;
        session.beginTransaction() ;
        User user = (User) session.createQuery(
        "select u from User as u where u.userUsername = ? and u.userPassword = ?")
        .setString(0, u.getUserUsername())
        .setString(1, u.getUserPassword())
        .uniqueResult() ;
        session.getTransaction().commit();
        return user ;
    }

    public void updateUser(User u) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
