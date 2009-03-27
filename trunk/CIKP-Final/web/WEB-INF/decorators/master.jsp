<%-- 
    Document   : master
    Created on : 9/Mar/2009, 22:11:33
    Author     : Bruno
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title><decorator:title default="Contruction Information And Knowledge Portal" /></title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <s:head />
        <script type="text/javascript" language="javascript" src="<s:url value="/lib/prototype/prototype.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/ajax/ajax.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/xtree/dhtmlxcommon.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/xtree/dhtmlxtree.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/ontology/OntXTree.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/xml/XmlLoader.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/ui_manager/UiAttrManager.js" />"></script>
        <script type="text/javascript" src="<s:url value="/lib/menu/coolmenu.js" />"></script>
        <script>
            <s:url id="serviceURL" namespace="/ajax" action="ServiceAction" />
            var serviceURL = '${serviceURL}';
        </script>

        <link href="<s:url value="/styles/styles.css" />" type="text/css" rel="stylesheet" />
        <decorator:head />
    </head>
    <body>
        <div id="content">
            <!-- header begins -->
            <%@include file="../jspf/header-menu.jspf" %>
            <!-- header ends -->
<!-- content begins -->
            <div id="main">
                <decorator:body />
                <!--content ends -->
                <!--footer begins -->
                <div style="clear: both"></div>
            </div>
        </div>
        <div id="footer">
            <%@include file="../jspf/footer.jspf" %>
        </div>

        <!-- footer ends-->
    </body>
</html>