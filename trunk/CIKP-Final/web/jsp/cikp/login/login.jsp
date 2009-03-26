<%-- 
    Document   : login
    Created on : 9/Mar/2009, 23:17:01
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><s:text name="login.title" /></title>
    </head>
    <body>
        <div id="left">
            <div id="left_back">
                <h3><s:text name="login.header" /></h3>
                <div class="title_back">
                    <s:form action="Login" method="POST">
                    <table>
                        <tr>
                            <td colspan="2" align="right">
                                <a href="<s:url value="../register/register.action" />"><s:text name="login.newuser" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:text name="login.username" />
                            </td>
                            <td>
                                <s:textfield name="userUsername" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:text name="login.password" />
                            </td>
                            <td>
                                <s:password name="userPassword" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <s:reset name="login.reset">
                                </s:reset>
                                <s:submit value="login.submit">
                                </s:submit>
                            </td>
                        </tr>
                    </table>
                    </s:form>
                </div>
            </div>
            <div id="bottom">
                <table>
                    <tr>
                        <td style="padding-left:40px;"><a href="<s:url value="/login/username_recovery.action" />"><s:text name="login.retrieveusername" /></a></td>
                        <td style="padding-left: 10px;"><a href="<s:url value="/login/password_recovery.action" />"><s:text name="login.retrievepasswd" /></a></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
