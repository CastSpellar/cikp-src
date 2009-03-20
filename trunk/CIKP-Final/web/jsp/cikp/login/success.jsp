<%-- 
    Document   : success
    Created on : 12/Mar/2009, 1:06:22
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Refresh" content="2;URL=<s:url value="/user/user_profile.action" />">
        <title><s:text name="welcome.title" /></title>
    </head>
    <body>
        <h1><s:text name="welcome.msg" />&nbsp;<%= request.getParameter("userUsername") %></h1>
    </body>
</html>
