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

            function init() {
                tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
                human_attributes_tree = new OntXTree('<s:url value="/ontxml/human_attribute.xml" />') ;
                human_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
            }

            function addRolePrototype() {
                var tabRow = new Element('tr') ;
                tabRow.update(new Element('td', {'width':'15%'}).update('<s:text name="userprofile.role" />')) ;
                tabRow.insert(new Element('td', {'width':'35%'}).update('<s:textfield name="roles" />')) ;
                tabRow.insert(new Element('td', {'collspan': '2'})) ;
                var nextRow = new Element('tr') ;
                nextRow.
                    insert(new Element('td', {'colspan':'4', 'align':'right'}).
                    update(new Element('input' , {'class':'button', 'value':'<s:text name="userprofile.additem" />', 'onclick':'alert(\'Available Soon\')', 'type':'button'}))) ;
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

            function getAllChecked() {
                alert(human_attributes_tree.getAllChecked());
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
            <div class="box" id="actor_div">
                <s:form action="DefineActor" method="POST">
                    <table>
                        <tr>
                            <td colspan="4">
                                <h4><s:text name="userprofile.pagename" /></h4>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
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
                        <tr>
                            <td width="20%">
                                <s:text name="userprofile.givenname" />
                            </td>
                            <td width="30%">
                                <s:textfield name="givenname" />
                            </td>
                            <td width="20%">
                                <s:text name="userprofile.familyname" />
                            </td>
                            <td width="30%">
                                <s:textfield name="familyname" />
                            </td>
                        </tr>
                        <tr>
                            <td width="20%">
                                <s:text name="userprofile.middlename" />
                            </td>
                            <td width="30%">
                                <s:textfield name="middlename" />
                            </td>
                            <td width="20%">
                                <s:text name="userprofile.age" />
                            </td>
                            <td width="30%">
                                <s:textfield name="age" />
                            </td>
                        </tr
                        <tr>
                            <td>
                                <s:text name="userprofile.gender" />
                            </td>
                            <td>
                                <s:select name="gender" headerKey="-1" headerValue="-- Select Gender --" list="{'Male', 'Female'}" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <br />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" align="right">
                               <input type="button" value="<s:text name="userprofile.additem" />" onclick="showHumanAttrTree();" class="button" />
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
                                <input type="button" value="<s:text name="userprofile.additem" />" onclick="alert('Available Soon...') ;" class="button" />
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
                                <input type="button" value="<s:text name="userprofile.cancel" />" onclick="window.location.href='<s:url action="UserInterface" />'" class="button" />
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
                        <input type="button" value="<s:text name="userprofile.addattr" />" class="button" onclick="getAllChecked();" />
                    </div>
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
