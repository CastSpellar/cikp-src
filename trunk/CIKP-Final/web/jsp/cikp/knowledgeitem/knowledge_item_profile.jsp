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
         <script type="text/javascript">
            if ( typeof window.addEventListener != "undefined" )
                window.addEventListener( "load", init, false );
            else if ( typeof window.attachEvent != "undefined" ) {
                window.attachEvent( "onload", init );
            }
            else {
                if ( window.onload != null ) {
                    var oldOnload = window.onload;
                    window.onload = function ( e ) {
                        oldOnload( e );
                        init();
                    };
                }
                else
                    window.onload = init;
            }
        </script>
    </head>
    <body>
        <div id="right">
            <div class="box">
                <table width="520px">
                        <tr>
                            <td colspan="4" align="center">
                                <h4><s:text name="knowledgeitem.pagename" /></h4>
                            </td>
                        </tr>
                </table>
            </div>
            <div class="box" id="knowledge_item_div">
                <s:form action="DefineKnowledgeItem" method="POST" enctype="multipart/form-data">
                     <table width="520px" id="staticAttr_tab">
                        <tr>
                            <td >
                                <s:text name="knowledgeitem.file" />
                            </td>
                            <td colspan="3">
                                <s:file name="upload" key="file" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:text name="Type:" />
                            </td>
                            <td>
                                <s:textfield name="knowledge_item_type" />
                            </td>
                        </tr>
                     </table>
                     <table id="dynamicAttr_tab">
                        <tr>
                            <td class="fieldName">
                                <s:text name="Subject Domain:" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="subject_domain" headerKey="-1" headerValue="-- Select --" list="#session['subject_domains']" />
                            </td>
                        </tr>
                    </table>
                    <table id="keywords_tab">
                        <tr>
                            <td>
                                <s:text name="KeyWord:" />
                            </td>
                            <td>
                                <s:textfield name="knowledge_item_keyword" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input type="button" id="addKeyword_btn" value="Add Keyword" class="button" />
                            </td>
                        </tr>
                    </table>
                    <br />
                    <table id="controls_tab">
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" value="<s:text name="knowledgeitem.addattr" />" onclick="alert('Available Soon...') ;" class="button" />
                                <s:submit key="knowledgeitem.submit" cssClass="button" />
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