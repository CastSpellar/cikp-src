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
        <title><s:text name="userprofile.title" />"</title>
        <script>

            var tree ;
            var human_attributes_tree ;
            var attrControl ;
            var service ;
            //var ui_manager ;
            var attributeController ;

            function init() {
                tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
                human_attributes_tree = new OntXTree('<s:url value="/ontxml/human_attribute.xml" />') ;
                human_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
                service = new CIKPWebService(serviceURL);
                attrControl = new AttributeControl('added_controls');
                <%--ui_manager = new UiAttrManager('<s:url value="/ontxml/human_attribute_conf.xml" />', 'actor_div', 'human_attr_tab') ;--%>
                attributeController = new AttributeControl('added_controls');

            }

            function addRolePrototype() {
                var tabRow = new Element('tr') ;
                tabRow.update(new Element('td', {'width':'15%'}).update('<s:text name="userprofile.role" />')) ;
                tabRow.insert(new Element('td', {'width':'35%'}).update('<s:textfield name="roles" />')) ;
                tabRow.insert(new Element('td', {'collspan': '2'})) ;
                var nextRow = new Element('tr') ;
                nextRow.
                    insert(new Element('td', {'colspan':'4', 'align':'right'}).
                    update(new Element('input' , {'class':'button', 'value':'<s:text name="userprofile.addattr" />', 'onclick':'alert(\'Available Soon\')', 'type':'button'}))) ;
                var tab = new Element('table').update(tabRow)
                tab.insert(nextRow) ;
                var newRole_div = new Element('div', {'class':'box'}).
                    update(tab) ;
                $('right').insertBefore(newRole_div, $('right').lastChild.previousSibling) ;
            }

            function removeRole(id) {

            }

            function showHumanAttrTree(){
                /*var human_attributes_tree_div = new Element('div', { 'class': 'show_tree', id: 'atributes_tree_div' }) ;
                alert('div created') ;
                $('left_back').appendChild(human_attributes_tree_div);
                alert('div added') ;*/
                // insert it in the document
                /*var human_attributes_tree = new OntXTree('<s:url value="/ontxml/human_attribute.xml" />') ;
                alert('tree created') ;
                human_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
                alert('tree generated') ;*/
                $('attributes_tree_div_container').removeClassName('hidden_tree') ;
                $('attributes_tree_div_container').addClassName('show_tree');
            }

            function hideHumanAttrTree() {
                $('attributes_tree_div_container').removeClassName('show_tree') ;
                $('attributes_tree_div_container').addClassName('hidden_tree');
            }

            function getAllChecked() {
                alert(human_attributes_tree.getAllChecked());
            }

            function addAttributesBtnClick(){
                var checked = human_attributes_tree.getAllChecked() ;
                if(checked == '')
                    return ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Human_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Human_Abstract_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Human_Physical_Attribute ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Human_Affiliation ', '') ;
                checked = checked.replace('http://www.jinyuezhang.com/work/ontology/Actor.owl#Personal_Contact_Number ', '') ;
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

                attributeController.insertAttributeControlList(checkedArr);

                //ui_manager.generateTable(checkedArr) ;
                hideHumanAttrTree() ;
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
                            <h4><s:text name="userprofile.pagename" /></h4>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="box" id="actor_div">
                <s:form action="DefineActor" method="POST">
                    <table>
                        <tr>
                            <td colspan="3" align="right">
                                <s:text name="userprofile.actortype" />
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
                                <s:text name="userprofile.givenname" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="givenname" />
                            </td>
                            <td class="fieldName">
                                <s:text name="userprofile.familyname" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="familyname" />
                            </td>
                        </tr>
                        <%--<tr>
                            <td class="fieldName">
                                <s:text name="userprofile.middlename" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="middlename" />
                            </td>
                            <td class="fieldName">
                                <s:text name="userprofile.age" />
                            </td>
                            <td class="fieldValue">
                                <s:textfield name="age" />
                            </td>
                        </tr>--%>
                        <tr>
                            <td class="fieldName">
                                <s:text name="userprofile.gender" />
                            </td>
                            <td class="fieldName">
                                <s:select name="gender" headerKey="-1" headerValue="-- Select Gender --" list="{'Male', 'Female'}" />
                            </td>
                            <td class="fieldName">
                                <s:text name="userprofile.age" />
                            </td>
                            <td class="fieldName">
                                <s:textfield name="age" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="userprofile.comunicationlanguage" />
                            </td>
                            <td class="fieldName">
                                <s:textfield name="comunication_language" />
                                <%--<s:select name="comunication_language" headerKey="-1" headerValue="-- Select --" list="#session['comm_lang']" />--%>
                            </td>
                            <td class="fieldName">
                                <s:text name="userprofile.geographicaffiliation" />
                            </td>
                            <td class="fieldName">
                                <%--<s:textfield name="geographic_affiliation" />--%>
                                <s:select name="geographic_affiliation" headerKey="-1" headerValue="-- Select --" list="#session['geo_aff']" />
                            </td>
                        </tr>
                        <tr>
                            <td class="fieldName">
                                <s:text name="userprofile.name" />
                            </td>
                            <td class="fieldName">
                                <s:textfield name="name" />
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
                                <input type="button" value="<s:text name="userprofile.addattr" />" onclick="showHumanAttrTree();" class="button" />
                            </td>
                        </tr>

                    </table>
                </div>
                <s:iterator value="#session['actor'].roles">
                    <div class="box" id="role_div">
                        <table id="roletable">
                            <tr>
                                <td width="15%">
                                    <s:text name="userprofile.role" />
                                </td>
                                <td width="35%">
                                    <s:textfield name="roles" />
                                </td>
                                <td colspan="2">
                                    &nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <br />
                                </td>
                            </tr>
                            <tr>
                                <td width="15%">
                                    <s:text name="userprofile.ability" />
                                </td>
                                <td width="35%">
                                    <s:select name="ability.iterator" key="ability" headerKey="-1" headerValue="-- Select ability --" list="{'Ability1', 'Ability2'}" />
                                </td>
                                <td width="15%">
                                    <s:text name="userprofile.knowledge" />
                                </td>
                                <td width="35%">
                                    <s:select name="knowledge" headerKey="-1" headerValue="-- Select knowledge --" list="#session['knowledges']" />
                                </td>
                            </tr>
                            <tr>
                                <td width="15%">
                                    <s:text name="userprofile.skill" />
                                </td>
                                <td width="35%">
                                    <s:select name="skill" key="skill" headerKey="-1" headerValue="-- Select skill --" list="{'Professional_Skill', 'Amateur_Skill'}" />
                                </td>
                                <td colspan="2">

                                </td>
                            </tr>
                            <td colspan="4">
                                <br />
                            </td>
                            <tr>
                                <td colspan="4" align="right">
                                    <input type="button" value="<s:text name="userprofile.addattr" />" onclick="alert('Available Soon...') ;" class="button" />
                                </td>
                            </tr>
                        </table>
                    </div>
                </s:iterator>
                <div class="box" id="controls_div">
                    <table align="center">
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" value="<s:text name="userprofile.addrole" />" onclick="addRolePrototype() ;" class="button" />
                                <s:submit key="userprofile.submit" cssClass="button" />
                                <input type="button" value="<s:text name="userprofile.cancel" />" onclick="window.location.href='<s:url action="user_interface" />'" class="button" />
                            </td>
                        </tr>
                    </table>
                </div>
            </s:form>
        </div>
        <div id="left">
            <div id="top"></div>
            <div id="left_back">
                <h3><s:text name="userprofile.onttree" /></h3>
                <div id="tree_div" class="title_back">
                </div>
                <div id="attributes_tree_div_container" class="hidden_tree">
                    <h3><s:text name="userprofile.attributestree" /></h3>
                    <div id="atributes_tree_div" class="title_back">
                    </div>
                    <div id="attr_control_div">
                        <input type="button" value="<s:text name="userprofile.additem" />" class="button" onclick="addAttributesBtnClick();" />
                    </div>
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
