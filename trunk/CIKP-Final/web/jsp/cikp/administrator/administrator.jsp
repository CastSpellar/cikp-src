<%-- 
    Document   : administrator
    Created on : 26/Mar/2009, 23:58:43
    Author     : Figueiras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><s:text name="administrator.title" /></title>
    </head>
    <body>
        <div id="left">
            <div id="left_back">
                <h3><s:text name="administrator.header" /></h3>
                <div class="title_back">
                    <table>
                        <tr>
                            <td colspan="3" align="left">
                               <h4><s:text name="administrator.createontfile" /></h4>
                            </td>
                            <td style="padding-left:20px;">
                                <%--<input type="button" id="administratorcreatefile" value="<s:text name="administrator.createfile" />" />--%>
                                <a href="<s:url action="DownloadOnt" />"><s:text name="administrator.createfile" /></a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="bottom">
                <table>
                    <tr>
                        <td>
                            <br/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
