/*
var service = new CIKPWebService(serviceURL);
var table = new AttributeControl('added_controls');
table.insertAttributeControl('Knowledge_Item_File_Type_Value');
table.insertAttributeControlList(['Value1','Value2','Value3']);
*/

var AttributeControl = Class.create({
    initialize: function(tableName) {
        this.table = $(tableName);
        this.controlMap = $H();
    },

    insertAttributeControlList: function(attributeList){
        try{
            attributeList.reverse().each(this.insertAttributeControl.bind(this));
        } catch (e) {
            console.log(e);
        }
        
    },   

    insertAttributeControl: function(attributeName) {
        console.log(this.controlMap);
        var isUndefined = Object.isUndefined(this.controlMap.get(attributeName) );
        if( isUndefined == true )
            service.getAttributeControl(attributeName,this.setAttributeControl.bind(this));
        else console.log(attributeName + ' is already set!');
    },

    setAttributeControl: function(attributeControl) {
        try{
            //this.registerOnMap.bind(attributeControl,this);
            this.controlMap.set(attributeControl.controlName,attributeControl);
            var newLine = false;
            var tableRows = this.table.select('tr');
            var tr;
            if (tableRows.size() != 0){
                tr = tableRows[tableRows.size()-1];
                var numberOfTDs = tr.select('td').size();
                if (numberOfTDs == 4) {
                    tr = new Element('tr');
                    newLine = true;
                }
            } else {
                this.table.insert(new Element('tbody'));
                tr = new Element('tr');
                newLine = true;
            }

            var controlName = attributeControl.controlName.gsub('_',' ');
            tr.insert( new Element('td', { 'class': 'fieldName' }).update(controlName + ':') );

            var control;
            if( attributeControl.controlType == 'select'){
                control = new Element(attributeControl.controlType);
                attributeControl.values.each(function(value){
                    control.insert(new Element('option', { 'value':value } ).update(value) );
                });
            }else control = new Element(attributeControl.controlType);
            tr.insert( new Element('td', { 'class': 'fieldValue' } ).update(control) );

            if (newLine) this.table.down('tbody').insert(tr);
        } catch(e) { console.log(e); }
    }
});

