/*
var service = new CIKPWebService(serviceURL);
var table = new AttributeControl('added_controls');
table.insertAttributeControl('Knowledge_Item_File_Type_Value');
*/

var attributeControl = {
    controlName:'Knowledge_Item_File_Type_Value',
    controlType:'select',
    values:['Value1','Value2','Value3']
}

var AttributeControl = Class.create({
    initialize: function(tableName) {
        this.table = $(tableName);
    },

    insertAttributeControlList: function(attributeList){
        attributeList.each(function(attributeName){
            this.insertAttributeControl(attributeName);
        });
    },

    insertAttributeControl: function(attributeName) {
        service.getAttributeControl(attributeName,this.setAttributeControl.bind(this));
    },

    setAttributeControl: function(attributeControl) {
        try{
            var newLine = false;
            var tableRows = $('added_controls').select('tr');
            var tr;
            if (tableRows.size() != 0){
                tr = tableRows[tableRows.size()-1];
                var numberOfTDs = tr.select('td').size();
                if (numberOfTDs == 4) {
                    tr = new Element('tr');
                    newLine = true;
                }
            } else {
                $('added_controls').insert(new Element('tbody'));
                tr = new Element('tr');
                newLine = true;
            }

            var controlName = attributeControl.controlName.gsub('_',' ')
            tr.insert( new Element('td', { 'class': 'fieldName' }).update(controlName + ':') );

            var control;
            if( attributeControl.controlType == 'select'){
                control = new Element(attributeControl.controlType);
                attributeControl.values.each(function(value){
                    control.insert(new Element('option', { 'value':value } ).update(value) );
                });
            }else control = new Element(attributeControl.controlType);
            tr.insert( new Element('td', { 'class': 'fieldValue' } ).update(control) );

            if (newLine) $('added_controls').down('tbody').insert(tr);
        } catch(e) { console.log(e); }
    }
});

