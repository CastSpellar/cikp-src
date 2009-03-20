/**
 * @author Bruno
 */
var fileUrl = 'http://pessoa.fct.unl.pt/beo14115/CIKP/teste.xml';
//var fileUrl = 'C:/Documents and Settings/Bruno/My Documents/Work/FCT/CIKP/Project-Src/GenerateXML/teste.xml'
var a = new Array();
var xmlhttp;
var rootNodeName = 'Ontology-Hierarchy';

var XmlParser = Class.create({
    initialize: function(url){
        try //Internet Explorer
        {
            this.xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
        } 
        catch (e) {
            try //Firefox, Mozilla, Opera, etc.
            {
                this.xmlDoc = document.implementation.createDocument("", "", null);
            } 
            catch (e) {
                alert(e.message) ;
            }
        }
        try {
            this.xmlDoc.async = false;
            this.xmlDoc.load(url);
        } 
        catch (e) {
            alert(e.message) ;
        }
        
    }
});

function load_xml(){
	var parser = new XmlParser(fileUrl) ;
	//alert(parser.xmlDoc.getElementsByTagName(rootNodeName)[0].childNodes[1].nodeName);
	var rootNode = parser.xmlDoc.getElementsByTagName(this.rootNodeName)[0] ;
    loadLevel(rootNode.childNodes, rootNode.firstChild, 0, a) ;
}

function loadLevel(childArray, fstchild, pos, arr){
	var currNode = fstchild ;
	for(var i = 0; i < childArray.length; i++) {
		if(currNode.nodeType == 1) {
			arr[pos] = new Array() ;
			//document.write(currNode.nodeName + '<br />') ;
			arr[pos]['caption'] = currNode.nodeName ;
			arr[pos]['children'] = new Array() ;
			loadLevel(currNode.childNodes, currNode.firstChild, 0, arr[pos]['children']) ;
			pos++ ;
		}
		currNode = currNode.nextSibling ;
	}
}
