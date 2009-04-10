<%-- 
    Document   : user_interface
    Created on : 19/Mar/2009, 14:27:45
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="userinterface.title" /></title>
    </head>
    <body>
        <div id="right">
            <div class="box">
                <table width="520px">
                    <tr>
                        <td colspan="4" align="center">
                            <h4><s:text name="userinterface.pagename" /></h4>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="box">
                <table width="520px">
                    <tr>
                        <td colspan="4">
                            <h3>
                                My Published Items
                            </h3>
                        </td>
                        <td colspan="4">
                            <%--<input type="button" value="View Items" style="width: 70px" />--%>
                        </td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            <p style="height: 5px;"></p>
                        </td>
                    </tr>
                    <tr>
                        <td width="27" class="table_received_items_padding">
                            <h4>
                                New
                            </h4>
                        </td>
                        <td width="61" class="table_received_items_padding">
                            <h4>
                                Relevance
                            </h4>
                        </td>
                        <td width="63" class="table_received_items_padding">
                            <h4>
                                Name
                            </h4>
                        </td>
                        <td width="65" class="table_received_items_padding">
                            <h4>
                                Description
                            </h4>
                        </td>
                        <td width="38" class="table_received_items_padding">
                            <h4>
                                Date
                            </h4>
                        </td>
                        <td width="85" class="table_received_items_padding">
                            <h4>
                                Publisher
                            </h4>
                        </td>
                        <td width="72" class="table_received_items_padding">
                            <h4>
                                Attachment
                            </h4>
                        </td>
                        <td width="73" class="table_received_items_padding">
                            <h4>
                                Popularity
                            </h4>
                        </td>
                    </tr>
                    <s:iterator value="#session['user'].knowledgeItemPortals">
                    <tr>
                        <td>
                            Yes
                        </td>
                        <td>
                            None
                        </td>
                        <td>
                            <%--CIKP_doc--%>
                            <s:property value="name" />
                        </td>
                        <td>
                            
                            <%--Something--%>
                        </td>
                        <td>
                            <s:property value="knowledgeItemCreationDate" />
                            <%--Today--%>
                        </td>
                        <td>
                            <s:property value="knowledgeItemSource" />
                            <%--Bruno Oliveira--%>
                        </td>
                        <td>
                            <s:property value="filePortal.fileName" />
                            <%--None--%>
                        </td>
                        <td>
                            Poor
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
            <div class="box">
                <table width="520px">
                    <tr>
                        <td colspan="4">
                            <h3>
                                <s:text name="userinterface.myreceiveitems" />
                            </h3>
                        </td>
                        <td colspan="4">
                            <input type="button" value="View Items" style="width: 70px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p style="height: 5px;"></p>
                        </td>
                    </tr>
                    <tr>
                        <td width="27" class="table_received_items_padding">
                            <h4>
                                New
                            </h4>
                        </td>
                        <td width="61" class="table_received_items_padding">
                            <h4>
                                Relevance
                            </h4>
                        </td>
                        <td width="63" class="table_received_items_padding">
                            <h4>
                                Name
                            </h4>
                        </td>
                        <td width="65" class="table_received_items_padding">
                            <h4>
                                Description
                            </h4>
                        </td>
                        <td width="38" class="table_received_items_padding">
                            <h4>
                                Date
                            </h4>
                        </td>
                        <td width="85" class="table_received_items_padding">
                            <h4>
                                Publisher
                            </h4>
                        </td>
                        <td width="72" class="table_received_items_padding">
                            <h4>
                                Attachment
                            </h4>
                        </td>
                        <td width="73" class="table_received_items_padding">
                            <h4>
                                Popularity
                            </h4>
                        </td>
                    </tr>
                    <s:iterator value="#session['user'].subscriptionPortals">
                    <s:iterator value="knowledgeItemPortals">
                    <tr>
                        <td>
                            Yes
                        </td>
                        <td>
                            None
                        </td>
                        <td>
                            <%--CIKP_doc--%>
                            <s:property value="knowledge_item_file_name" />
                        </td>
                        <td>

                            <%--Something--%>
                        </td>
                        <td>
                            <s:property value="knowledge_item_creation_date" />
                            <%--Today--%>
                        </td>
                        <td>
                            <s:property value="knowledge_item_source" />
                            <%--Bruno Oliveira--%>
                        </td>
                        <td>
                            <s:property value="filePortal.fileName" />
                            <%--None--%>
                        </td>
                        <td>
                            Poor
                        </td>
                    </tr>
                    </s:iterator>
                    </s:iterator>
                    <%--<tr>
                        <td>
                            Yes
                        </td>
                        <td>
                            None
                        </td>
                        <td>
                            CIKP_doc
                        </td>
                        <td>
                            Something
                        </td>
                        <td>
                            Today
                        </td>
                        <td>
                            Me
                        </td>
                        <td>
                            None
                        </td>
                        <td>
                            Poor
                        </td>
                    </tr>--%>
                </table>
            </div>
            <div class="box">
                <table width="520px">
                    <tr>
                        <td colspan="2">
                            <h3>
                                My Other Participated Items
                            </h3>
                        </td>
                        <td colspan="2">
                            <input type="button" value="View Items" style="width: 70px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p style="height: 5px;"></p>
                        </td>
                    </tr>
                    <tr>
                        <td width="95" class="table_received_items_padding">
                            <h4>
                                New
                            </h4>
                        </td>
                        <td width="145" class="table_received_items_padding">
                            <h4>
                                Relevance
                            </h4>
                        </td>
                        <td width="144" class="table_received_items_padding">
                            <h4>
                                Name
                            </h4>
                        </td>
                        <td width="116" class="table_received_items_padding">
                            <h4>
                                Description
                            </h4>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            No
                        </td>
                        <td>
                            Important
                        </td>
                        <td>
                            CIKP_2_doc
                        </td>
                        <td>
                            Something
                        </td>
                    </tr>
                </table>
            </div>
            <div class="box">
                <table width="400px">
                    <tr>
                        <td>
                            <h3>
                                My Tagged Users
                            </h3>
                        </td>
                        <td>
                            <input type="button" value="View" style="width: 70px" class="button" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="left">
            <div id="top"></div>
            <div id="left_back">
                <h3>My Profile</h3>
                <div class="title_back">
                    <s:push value="#session.user">
                        <table class="usertab">
                            <tr>
                                <td>
                                    <s:text name="userinterface.username" />
                                </td>
                                <td>
                                    <s:property value="userUsername" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="userinterface.firstname" />
                                </td>
                                <td>
                                    <s:property value="userFirstname" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="userinterface.lastname" />
                                </td>
                                <td>
                                    <s:property value="userLastname" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="userinterface.company" />
                                </td>
                                <td>
                                    <s:property value="userCompany" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="userinterface.telephone" />
                                </td>
                                <td>
                                    <s:property value="userTelephone" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <s:text name="userinterface.email" />
                                </td>
                                <td>
                                    <s:property value="userEmail" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <input type="button" value="<s:text name="userinterface.viewprofile" />" class="button" />
                                    <input type="button" value="<s:text name="userinterface.editprofile" />" onclick="window.location.href='<s:url action="user_profile" />'" class="button" />
                                </td>
                            </tr>
                        </table>

                    </s:push>
                </div>
                <br />
                <h3>My Buddies</h3>
                <div class="title_back">
                    <table width="290px">
                        <tr>
                            <td align="center" width="205px">
                                User
                            </td>
                            <td align="center">
                                CoP
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                Pedro Figueiras
                            </td>
                            <td align="left">
                                CoP_name
                            </td>
                        </tr>
                        <tr>
                            <td align="left">
                                Bruno Oliveira
                            </td>
                            <td align="left">
                                CoP_name
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input type="button" value="View Buddies" style="width: 80px" class="button" />
                                <input type="button" value="Edit Buddies" style="width: 80px" class="button" />
                            </td>
                        </tr>
                    </table>
                </div>
                <br />

            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
