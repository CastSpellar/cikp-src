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

            var AttributeManager = Class.create({
                initialize: function(){
                    this.divContainer = 'ki_tree_div_container';
                    this.attributes_tree = new OntXTree('<s:url value="/ontxml/knowledge_item_attribute.xml" />') ;
                    this.attributes_tree.genTree('ki_tree_div',
                                    {'imgPath' : '<s:url value="/images/custom/" />',
                                     'checkbox' : 1}) ;
                    this.attributeController = new AttributeControl('added_ki_attributes');
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

                showAttrTree : function(){
                    $(this.divContainer).removeClassName('hidden_tree') ;
                    $(this.divContainer).addClassName('show_tree');
                },

                hideAttrTree: function () {
                    $(this.divContainer).removeClassName('show_tree') ;
                    $(this.divContainer).addClassName('hidden_tree');
                }
            });

            var attributeManager;

            function init() {
                attributeManager = new AttributeManager();

                var tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('ki_type'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
            }

            document.observe('dom:loaded',init);
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
                                <s:textfield name="knowledge_item_type" id="ki_type" />
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
                            <td>
                                <s:text name="File Type:" />
                            </td>
                            <td>
                                <s:textfield name="knowledge_item_file_type" />
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
                    </table>
                    <table id="added_ki_attributes"></table>
                    <table id="ki_attr_control_tab">
                        <tr>
                            <td colspan="4" align="right">
                                <input type="button" id="addKeyword_btn" value="Add Keyword" class="button" />
                                <input type="button" value="<s:text name="knowledgeitem.addattr" />" onclick="attributeManager.showAttrTree(); " class="button" />
                            </td>
                        </tr>
                    </table>

                    <br />
                    <table id="controls_tab">
                        <tr>
                            <td colspan="4" align="right">
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
                <div id="ki_tree_div_container" class="hidden_tree">
                    <h3>Knowledge Item Attributes (hard)</h3>
                    <div id="ki_tree_div" class="title_back">
                    </div>
                    <div id="ki_control_div" class="attr_control_div">
                        <input type="button" value="Add Attributes" class="button" onclick="attributeManager.addAttributesBtnClick();" />
                    </div>
                </div>
            </div>
            <div id="bottom"></div>
        </div>
    </body>
</html>