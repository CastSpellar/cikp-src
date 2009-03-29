<%-- 
    Document   : register
    Created on : 9/Mar/2009, 23:10:38
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><s:text name="register.title" /></title>
    </head>
    <body>
        <div id="left">
            <div id="left_back">
                <h3><s:text name="register.header" /></h3>
                <div class="title_back">
                    <s:form action="Register" method="POST">
                        <table style="width: 300px;">
                            <tr>
                                <td colspan="2" align="right">
                                    <a href="<s:url value="../login/login.action" />"><s:text name="register.login" /></a>
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.firstname" />
                                </td>
                                <td>
                                    <s:textfield name="userFirstname" size="20" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.lastname" />
                                </td>
                                <td>
                                    <s:textfield name="userLastname" size="20" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.company" />
                                </td>
                                <td>
                                    <s:textfield name="userCompany" size="20" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.telephone" />
                                </td>
                                <td>
                                    <s:textfield name="userTelephone" size="20" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.email" />
                                </td>
                                <td>
                                    <s:textfield name="userEmail" size="20" cssClass="registerText" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.username" />
                                </td>
                                <td>
                                    <s:textfield name="userUsername" size="20" cssClass="registerText" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.password" />
                                </td>
                                <td>
                                    <s:password name="userPassword" size="20" cssClass="registerText" />
                                </td>
                            </tr>
                            <tr>
                                <td nowrap="nowrap">
                                    <s:text name="register.password2" />
                                </td>
                                <td>
                                    <s:password name="password2" size="20" cssClass="registerText" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="register.userorgcheck" />
                                </td>
                                <td>
                                    <s:checkbox name="userorgcheck" value="false" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <s:submit key="register.submit" />
                                    <s:reset key="register.reset" />
                                </td>
                            </tr>
                        </table>
                    </s:form>
                </div>
            </div>
            <div id="bottom">
            </div>
        </div>
    </body>
</html>
