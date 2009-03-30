
            var tree ;
            var human_attributes_tree ;
            var ui_manager ;
            var attributeController ;

            function init() {
                tree = new OntXTree('<s:url value="/ontxml/teste2.xml" />') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />'}) ;
                human_attributes_tree = new OntXTree('<s:url value="/ontxml/human_attribute.xml" />') ;
                human_attributes_tree.genTree('atributes_tree_div', {'dropIds' : $w('DefineActor_actortype'), 'imgPath' : '<s:url value="/images/custom/" />', 'checkbox' : 1}) ;
                ui_manager = new UiAttrManager('<s:url value="/ontxml/human_attribute_conf.xml" />', 'actor_div', 'human_attr_tab') ;
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

            function hideHumanAttrTree() {
                $('attributes_tree_div_container').removeClassName('show_tree') ;
                $('attributes_tree_div_container').addClassName('hidden_tree');
            }

            function getAllChecked() {
                alert(human_attributes_tree.getAllChecked());
            }

            function addAttributesBtnClick(){
                var checked = human_attributes_tree.getAllChecked() ;
                if(checked == ''){
                    attributeController.insertAttributeControlList([]);
                    hideHumanAttrTree() ;
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
                //var tab = ui_manager.generateTable(checkedArr) ;

                attributeController.insertAttributeControlList(checkedArr);
                hideHumanAttrTree() ;
                //ui_manager.generateTable(checkedArr) ;
                hideHumanAttrTree() ;
                //$('right').appendChild(tab) ;
                //var table = manager.generateTable() ;
            }

document.observe("dom:loaded",init);