/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;
import org.fct.unl.pt.cikp.constants.Constants;

/**
 *
 * @author Bruno
 */
public class AuthenticationInterceptor implements Interceptor {

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map  session = actionInvocation.getInvocationContext().getSession();
        return null ;
        /*User user = (User) session.get( Struts2PortfolioConstants.USER );
        if (user == null) {
            return Action.LOGIN;
        }
        else {
        Action action = ( Action ) actionInvocation.getAction();
        if (action instanceof UserAware) {
             ((UserAware)action).setUser(user);
         }
         return actionInvocation.invoke();*/
    }

}
