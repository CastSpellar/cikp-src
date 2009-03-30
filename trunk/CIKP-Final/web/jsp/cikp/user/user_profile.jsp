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
            /*
                <s:url value="/ontxml/human_attribute.xml" />
            */

            var RoleController = Class.create({
                initialize: function(roleName,attributeXMLURL, options ) {
                    this.roleName = roleName;
                    this.attributeXMLURL = attributeXMLURL;

                    if (Object.isUndefined(options) == true){
                        // Role Div IDs
                        this.roleDiv = this.roleName+'_div';
                        this.inputBox = 'DefineActor_' + this.roleName;
                        this.added_controls_table = 'added_controls_' + this.roleName;
                        this.attr_control_table = 'attr_control_table_' + this.roleName;

                        // Role Hidden Tree Id's'
                        this.roleAttributeTreeDivContainer = 'attributes_tree_div_container_'+this.roleName;
                        this.atributes_tree_div = 'atributes_tree_div_' + this.roleName;
                        this.attribute_control_div = 'attr_control_div_'+this.roleName;

                        this.createRoleDiv();
                        this.createRoleAttributeDiv();
                    } else {
                        this.roleDiv = options.roleDiv;
                        this.inputBox = options.inputBox;
                        this.added_controls_table = options.added_controls_table;
                        this.attr_control_table = options.attr_control_table;

                        // Role Hidden Tree Id's'
                        this.roleAttributeTreeDivContainer = options.roleAttributeTreeDivContainer;
                        this.atributes_tree_div = options.atributes_tree_div;
                        this.attribute_control_div = options.attribute_control_div;

                        if(options.createDivs == true){
                            this.createRoleDiv();
                            this.createRoleAttributeDiv();
                        }
                    }

                    this.attributes_tree = new OntXTree(this.attributeXMLURL) ;
                    this.attributes_tree.genTree(this.atributes_tree_div,
                                    {'dropIds' : $w(this.inputBox),
                                     'imgPath' : '<s:url value="/images/custom/" />',
                                     'checkbox' : 1}) ;
                    this.attributeController = new AttributeControl(this.added_controls_table);
                },
                
                addAttributesBtnClick: function (){

                    var checked = this.attributes_tree.getAllChecked() ;
                    if(checked == ''){
                        this.attributeController.insertAttributeControlList([]);
                        this.hideAttrTree() ;
                        return ;
                    }

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
                    this.attributeController.insertAttributeControlList(checkedArr);
                    this.hideAttrTree() ;
                },
                
                createRoleDiv: function(){
                    var tabRow = new Element('tr') ;
                    tabRow.update(new Element('td', {'width':'15%'}).update('<s:text name="userprofile.role" />')) ;
                    //tabRow.insert(new Element('td', {'width':'35%'}).update('<s:textfield name="roles" />')) ;
                    tabRow.insert(new Element('td', {'width':'35%'}).update(new Element('input',{'type':'text',
                                                                                                 'id':this.inputBox }))) ;

                    tabRow.insert(new Element('td', {'collspan': '2'})) ;
                    var table = new Element('table').update(tabRow);

                    var attr_added_controls = new Element('table', { 'id' : this.added_controls_table});
                    var attr_control_table = new Element('table', { 'id' : this.attr_control_table}).
                        insert(new Element('td', {'colspan':'4', 'align':'right'}).
                        update(new Element('input' , {'class':'button',
                                                      'value':'<s:text name="userprofile.additem" />',
                                                      'onclick':'roleManager.getRole("'+this.roleName+'").showAttrTree();',
                                                      'type':'button'}))) ;

                    var newRole_div = new Element('div', {'class':'box' , 'id': this.roleDiv }).
                        update(table).insert(attr_added_controls).insert(attr_control_table) ;

                    $('right').insertBefore(newRole_div, $('right').lastChild.previousSibling) ;
                },

                createRoleAttributeDiv: function(){
                    var h3 = new Element('h3').update('<s:text name="userprofile.attributestree" />');
                    var roleAttributeTreeDivContainer = new Element('div',{'class':'hidden_tree' ,
                                                                           'id' : this.roleAttributeTreeDivContainer});
                    var roleAttributeTreeDiv = new Element('div',{'class':'title_back',
                                                                  'id' : this.atributes_tree_div });
                    var roleAttributeControlDiv = new Element('div',{'id':this.attribute_control_div,
                                                                     'class':'attr_control_div'})
                                            .update(new Element('input',{'type':'button',
                                                                         'class':'button',
                                                                         'value':'<s:text name="userprofile.addattr" />',
                                                                         'onclick':'roleManager.getRole("'+this.roleName+'").addAttributesBtnClick();' }));

                    roleAttributeTreeDivContainer.update(h3).insert(roleAttributeTreeDiv).insert(roleAttributeControlDiv);
                    $('left_back').insert(roleAttributeTreeDivContainer);
                },

                showAttrTree : function(){
                    $(this.roleAttributeTreeDivContainer).removeClassName('hidden_tree') ;
                    $(this.roleAttributeTreeDivContainer).addClassName('show_tree');
                },

                hideAttrTree: function () {
                    $(this.roleAttributeTreeDivContainer).removeClassName('show_tree') ;
                    $(this.roleAttributeTreeDivContainer).addClassName('hidden_tree');
                }
                
            });

            var RoleManager = Class.create({
                initialize: function() {
                    this.roles = new $H() ;
                },
                
                addRole: function (attributeXMLURL,options) {
                    var roleName;
                    if (Object.isUndefined(options) == false) roleName = options.name;
                    else                                      roleName = 'Role' + this.roles.size();
                    this.roles.set(roleName, new RoleController(roleName,attributeXMLURL,options) );
                    return roleName;
                },

                getRole: function (roleName){
                    return this.roles.get(roleName);
                }
            });

            function showHumanAttrTree(){
                $('attributes_tree_div_container').removeClassName('hidden_tree') ;
                $('attributes_tree_div_container').addClassName('show_tree');
            }

            function hideHumanAttrTree() {
                $('attributes_tree_div_container').removeClassName('show_tree') ;
                $('attributes_tree_div_container').addClassName('hidden_tree');
            }

            var humanRole;
            var tree;

            var roleManager = new RoleManager();

            var humanOptions = {
                name : 'HumanRole',
                // Role Div IDs
                roleDiv : 'actor_div',
                inputBox : 'DefineActor',
                added_controls_table : 'added_controls',
                attr_control_table : 'attr_control_tab',

                roleAttributeTreeDivContainer : 'attributes_tree_div_container',
                atributes_tree_div : 'atributes_tree_div',
                attribute_control_div : 'attr_control_div',
                createDivs : false
            };

            function load(){
                tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;

                humanRole = roleManager.addRole('<s:url value="/ontxml/human_attribute.xml" />',humanOptions);
            }

            document.observe('dom:loaded',load);
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
                                <input type="button" value="<s:text name="userprofile.addrole" />" onclick="roleManager.addRole('<s:url value="/ontxml/human_attribute.xml" />');" class="button" />
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
                    <div id="attr_control_div" class="attr_control_div">
                        <input type="button" value="<s:text name="userprofile.addattr" />" class="button" onclick="roleManager.getRole(humanRole).addAttributesBtnClick();" />
                    </div>
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>
