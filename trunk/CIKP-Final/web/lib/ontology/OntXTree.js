/**
 * @author Bruno
 */
var OntXTree = Class.create({
    initialize: function(url){
        this.url = url;
        this.t = null;
    },
   addDropTarget: function(dropId){
        this.dropIds[dropIds.length] = dropId ;
        this.setDropTarget(dropId) ;
    },
    genTree: function(treeDiv, options) {
        var default_args = {
            'dropIds'	:	[],
            'imgPath'	:	'',
            'checkbox'	:	0
        }
        for(var index in default_args) {
            if(typeof options[index] == "undefined") options[index] = default_args[index];
        }

        /*tree=new dhtmlXTreeObject("treeboxbox_tree","100%","100%",0);
            tree.setImagePath("../imgs/");
            //enable checkboxes
            tree.enableCheckBoxes(1);
            tree.loadXML("tree.xml");

            ....
            tree.showItemCheckbox(id,false); //hide checkbox
            tree.showItemCheckbox(id,true);  //show checkbox*/

        this.t = new dhtmlXTreeObject($(treeDiv), "100%", "100%", 0);
        /* options[] has all the data - user provided and optional */
        //alert(options[1]) ;
        this.t.setImagePath(options['imgPath']) ;
        //this.t.enableSmartXMLParsing(true);
        this.t.loadXML(this.url) ;
        this.dropIds = options['dropIds'] ;
        this.t.enableCheckBoxes(options['checkbox']) ;
        this.t.enableThreeStateCheckboxes(true);
        this.t.enableDragAndDrop(true) ;
        this.t.enableTreeLines(false);
        // set plus images
        this.t.setImageArrays("plus","plus2.gif","plus3.gif","plus4.gif","plus.gif","plus5.gif");
        this.t.setImageArrays("minus","minus2.gif","minus3.gif","minus4.gif","minus.gif","minus5.gif");
        this.t.setStdImages("book.gif","books_open.gif","books_close.gif");
        var i ;
        for(i in this.dropIds) {
            this.setDropTarget(this.dropIds[i]) ;
        }

        this.t.setDragHandler(myDragHandler);

        function myDragHandler(idFrom,idTo){
            //if we return false then drag&drop be aborted
            var index ;
            for(index in this.dropIds) {
                if(idTo == this.dropIds[index])
                    return true;
            }
            return false ;
        }
    },
    setDropTarget: function(dropId){
        function s_control(dropId){ //action occures on drag 
            this._drag = function(sourceHtmlObject, dhtmlObject, targetHtmlObject){
                targetHtmlObject.style.backgroundColor = "";
                targetHtmlObject.value = sourceHtmlObject.parentObject.label;
            }
            
            //action occures on drag moved in landing zone 
            this._dragIn = function(htmlObject, shtmlObject){
                htmlObject.style.backgroundColor = "#fffacd";
                return htmlObject;
            }
            
            //action occures on drag moved out landing zone 
            this._dragOut = function(htmlObject){
                htmlObject.style.backgroundColor = "";
                return this;
            }
        }
        
        //set input control as “landing zone” 
        this.t.dragger.addDragLanding($(dropId), new s_control);
    },
    getAllChecked: function(){
        return this.t.getAllChecked() ;
    }
});
