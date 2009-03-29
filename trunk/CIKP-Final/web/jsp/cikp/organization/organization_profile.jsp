<%-- 
    Document   : user_profile
    Created on : 17/Mar/2009, 18:12:18
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="organizationprofile.title" />"</title>
        <script>

            var tree ;
            var organization_attributes_tree ;
            var ui_manager ;

            function init() {
                tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineOrganization_actortype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
                organization_attributes_tree = new OntXTree('<s:url value="/ontxml/organization_attribute.xml" />') ;
                organization_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineOrganization_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
                <%--ui_manager = new UiAttrManager('<s:url value="/ontxml/organization_attribute_conf.xml" />', 'organization_div', 'organization_attr_tab') ;--%>
            }

            function showOrgAttrTree(){
                /*var human_attributes_tree_div = new Element('div', { 'class': 'show_tree', id: 'atributes_tree_div' }) ;
                alert('div created') ;
                $('left_back').appendChild(human_attributes_tree_div);
                alert('div added') ;*/
                // insert it in the document
                /*var human_attributes_tree = new OntXTree('<s:url value="/ontxml/organization_attribute.xml" />') ;
                alert('tree created') ;
                human_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
                alert('tree generated') ;*/
                $('attributes_tree_div_container').removeClassName('hidden_tree') ;
                $('attributes_tree_div_container').addClassName('show_tree');
            }

            function hideOrgAttrTree() {
                $('attributes_tree_div_container').removeClassName('show_tree') ;
                $('attributes_tree_div_container').addClassName('hidden_tree');
            }

            function getAllChecked() {
                alert(organization_attributes_tree.getAllChecked());
            }

            function addAttributesBtnClick(){
                var checked = organization_attributes_tree.getAllChecked() ;
                if(checked == '')
                    return ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Organization_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Organization_Abstract_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Organization_Physical_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Organization_Affiliation ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Contact_Address ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Work_Contact_Number ', '') ;
                //alert(checked) ;
                var checkedArr = checked.split(' ') ;
                var index = 0 ;
                while(index < checkedArr.length) {
                    checkedArr[index] = checkedArr[index].replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#', '') ;
                    index++ ;
                }
                //var tab = ui_manager.generateTable(checkedArr) ;
                ui_manager.generateTable(checkedArr) ;
                hideOrgAttrTree() ;
                //$('right').appendChild(tab) ;
                //var table = manager.generateTable() ;
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
                            <h4><s:text name="organizationprofile.pagename" /></h4>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="box" id="actor_div">
                <s:form action="DefineOrganization" method="POST">
                    <table>
                        <tr>
                            <td colspan="3" align="right">
                                <s:text name="organizationprofile.actortype" />
                            </td>
                            <td>
                                <s:textfield name="actortype" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                    </table>
                    <table id="human_attr_tab">
                        <tr>
                            <td class="fieldName">
                                <s:text name="organizationprofile.name" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="name" />
                            </td>
                            <td class="fieldName">
                                <s:text name="organizationprofile.age" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="age" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="organizationprofile.workphone" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="work_phone_number" />
                            </td>
                            <td class="fieldName">
                                <s:text name="organizationprofile.commlang" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="communication_language" headerKey="-1" headerValue="-- Select --" list="{'Portuguese', 'English'}" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="organizationprofile.geoaffiliation" />
                            </td>
                            <td class="fieldValue">
                                <s:select name="geographic_affiliation" headerKey="-1" headerValue="-- Select --" list="{'Portugal', 'Canada'}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                    </table>

                    <table id="added_controls">

                    </table>

                    <table id="human_attr_control_tab">
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" value="<s:text name="organizationprofile.addattr" />" onclick="showOrgAttrTree();" class="button" />
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="box" id="controls_div">
                    <table align="center">
                        <tr>
                            <td colspan="4" align="right">
                                <s:submit key="organizationprofile.submit" cssClass="button" />
                                <input type="button" value="<s:text name="organizationprofile.cancel" />" onclick="window.location.href='<s:url action="UserInterface" />'" class="button" />
                            </td>
                        </tr>
                    </table>
                </div>
            </s:form>
        </div>
        <div id="left">
            <div id="top"></div>
            <div id="left_back">
                <h3><s:text name="organizationserprofile.onttree" /></h3>
                <div id="tree_div" class="title_back">
                </div>
                <div id="attributes_tree_div_container" class="hidden_tree">
                    <h3><s:text name="organizationprofile.attributestree" /></h3>
                    <div id="atributes_tree_div" class="title_back">
                    </div>
                    <div id="attr_control_div">
                        <input type="button" value="<s:text name="organizationprofile.additem" />" class="button" onclick="addAttributesBtnClick();" />
                    </div>
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
