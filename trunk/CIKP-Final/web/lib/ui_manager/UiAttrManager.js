/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var UiAttrManager = Class.create({
    initialize: function(xmlFile, divId, tableId) {
        this.xmlFile = xmlFile ;
        this.divId = divId ;
        this.tableId = tableId ;
        this.selectedIds = [] ;
        this.xmlDoc = new XmlLoader(this.xmlFile) ;
    },
    generateTable: function(ids) {
        var nTds = 4 ;
        var tdCounter = 0 ;
        //var table = new Element("table", {id : this.tableId}) ;
        var table = $(this.tableId).update("") ;
        var index = 0 ;
        while(index < ids.length) {
            if((tdCounter % nTds) == 0){
                tableRow = new Element("tr") ;
                table.insert(tableRow) ;
                tdCounter = 0 ;
            }
            var id = ids[index] ;
            var control = this.getControl(id) ;
            var td1 = new Element("td", {
                'width' : '20%'
            }).update(id.replace('_', ' ') + ':') ;
            tableRow.insert(td1) ;
            var td2 = new Element("td", {
                'width' : '30%'
            }).update(control) ;
            tableRow.insert(td2) ;
            index++ ;
            tdCounter += 2 ;
        }
    //$(this.tableId).update(table) ;
    },
    getControl: function(controlId){
        var xmlDoc = this.xmlDoc.getDocument() ;
        var elem = xmlDoc.getElementsByTagName(controlId)[0] ;
        var control = elem.getElementsByTagName('Control')[0];
        return control.childNodes[1].data ;
    }
}) ;