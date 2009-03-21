<%-- 
    Document   : knowledge_item_profile
    Created on : 21/Mar/2009, 3:17:52
    Author     : Figueiras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="knowledgeitem.title" /></title>
        <script type="text/javascript">
            function init() {
                var tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineKnowledgeItem_kitype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
            }
         </script>
    </head>
    <body>
        <div id="right">
            <div class="box" id="knowledge_item_div">
                <s:form action="DefineKnowledgeItem" method="POST">
                     <table width="520px">
                        <tr>
                            <td >
                                <s:text name="knowledgeitem.file" />
                            </td>
                            <td colspan="2">
                                <s:textfield name="kifile" />
                            </td>
                            <td>
                                <input type="button" value="<s:text name="knowledgeitem.browsefile" />" onclick="alert('Available Soon...') ;" class="button" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:text name="knowledgeitem.type" />
                            </td>
                            <td>
                                <s:textfield name="kitype" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <s:text name="knowledgeitem.filetype" />
                            </td>
                            <td width="30%">
                                <s:select name="filetype" headerKey="-1" headerValue="-- Select File Type --" list="{'1','2'}" />
                            </td>
                            <td width="20%">
                                <s:text name="knowledgeitem.subjectdomain" />
                            </td>
                            <td width="30%">
                                <s:select name="subjectdomain" headerKey="-1" headerValue="-- Select Subject Domain --" list="{'1','2'}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:text name="knowledgeitem.keyword" />
                            </td>
                            <td>
                                <s:textfield name="keyword" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" value="<s:text name="knowledgeitem.additem" />" onclick="alert('Available Soon...') ;" class="button" />
                                <s:submit key="knowledgeitem.submit" onclick="alert('Available Soon...') ;" cssClass="button" />
                                <input type="button" value="<s:text name="knowledgeitem.cancel" />" onclick="window.location.href='<s:url action="UserInterface" />'" class="button" />
                            </td>
                        </tr>
                     </table>
                </s:form>
            </div>
        </div>
        <div id="left">
            <div id="top"></div>
            <div id="left_back">
                <h3><s:text name="knowledgeitem.onttree" /></h3>
                <div id="tree_div" class="title_back">
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>