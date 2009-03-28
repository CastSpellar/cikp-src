<%-- 
    Document   : knowledge_item_subscription
    Created on : 22/Mar/2009, 17:45:24
    Author     : Figueiras
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="knowledgeitem.subscribetitle" />"</title>
        <script type="text/javascript">

            function init() {
                var tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('SubscribeKnowledgeItem_kisubscribetype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
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
                                <h4><s:text name="knowledgeitem.subscribepagename" /></h4>
                            </td>
                        </tr>
                </table>
            </div>
            <div class="box" id="knowledge_item_subscription_div">
                <s:form action="SubscribeKnowledgeItem" method="POST">
                    <table width="520px">
                        <tr>
                            <td colspan="3">
                                <s:text name="knowledgeitem.subscribetype" />
                            </td>
                            <td>
                                <s:textfield name="kisubscribetype" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribefiletype" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="kisubscribefiletype" headerKey="-1" headerValue="-- Select File Type --" list="{'.doc', '.pdf'}" />
                            </td>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribesubjectdomain" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="kisubscribesubjectdomain" headerKey="-1" headerValue="-- Select Domain Subject --" list="{'domain_1', 'domain_2'}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribekeyword" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="kisubscribekeyword" />
                            </td>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribegeoaffiliation" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="kisubscribegeoaffiliation" headerKey="-1" headerValue="-- Select Geographic Affiliation --" list="{'Canada', 'Portugal'}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribeprojaffiliation" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="kisubscribeprojaffiliation" headerKey="-1" headerValue="-- Select Project Affiliation --" list="{'Project_1', 'Project_2'}" />
                            </td>
                            <td class="fieldName">
                                <s:text name="knowledgeitem.subscribecomlanguage" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="kisubscribecomlanguage" headerKey="-1" headerValue="-- Select Composition Language --" list="{'English', 'Portuguese'}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" value="<s:text name="knowledgeitem.subscribeadditem" />" onclick="javascript:alert('Available Soon.') ;" class="button" />
                            </td>
                        </tr>
                    </table>
                    <div class="box" id="controls_div">
                        <table align="center">
                            <tr>
                                <td colspan="4" align="right">
                                    <s:submit key="knowledgeitem.subscribesubmit" cssClass="button" />
                                    <input type="button" value="<s:text name="knowledgeitem.subscribecancel" />" onclick="window.location.href='<s:url action="UserInterface" />'" class="button" />
                                </td>
                            </tr>
                        </table>
                    </div>
                </s:form>
            </div>
        </div>
        <div id="left">
            <div id="top"></div>
            <div id="left_back">
                <h3><s:text name="knowledgeitem.subscribeonttree" /></h3>
                <div id="tree_div" class="title_back">
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
