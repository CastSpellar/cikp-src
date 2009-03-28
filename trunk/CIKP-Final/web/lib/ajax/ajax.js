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

    registerOnMap: function(attributeControl){
        try{
           var isUndefined = Object.isUndefined(this.controlMap.get(attributeControl.controlName) );
           if( isUndefined == true )
                this.controlMap.set(attributeControl.controlName,attributeControl);

           return !isUndefined;
        } catch(e){
            console.log(e);
        }
    },

    insertAttributeControlList: function(attributeList){
        try{
            attributeList.reverse().each(this.insertAttributeControl.bind(this));
        } catch (e) {
            console.log(e);
        }
        
    },   

    insertAttributeControl: function(attributeName) {
        service.getAttributeControl(attributeName,this.setAttributeControl.bind(this));
    },

    setAttributeControl: function(attributeControl) {
        try{
            var isSet = this.registerOnMap.bind(this,attributeControl);           
            if( isSet == false){
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
            } else {
                console.log(attributeControl.controlName.gsub('_',' ') + ' is already set!')
            }
        } catch(e) { console.log(e); }
    }
});

