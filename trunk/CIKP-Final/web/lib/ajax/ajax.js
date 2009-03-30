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
            if(attributeList.size() != 0){
                attributeList.each(this.getControlContent.bind(this));
                this.table.innerHTML = '';
                attributeList.reverse().each(this.insertAttributeControl.bind(this));
            } else this.table.innerHTML = '';
        } catch (e) {
            console.log(e);
        }
        
    },   

    insertAttributeControl: function(attributeName) {
        var isUndefined = Object.isUndefined(this.controlMap.get(attributeName) );
        if( isUndefined == true )
            service.getAttributeControl(attributeName,this.setAttributeControl.bind(this));
        else {
            this.setAttributeControl(this.controlMap.get(attributeName));
            
        }
        //else console.log(attributeName + ' is already set!');
    },

    setAttributeControl: function(attributeControl) {
        try{
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
            if( Object.isUndefined(attributeControl.html) == false ){
                control = attributeControl.html;
            } else {
                if( attributeControl.controlType == 'select'){
                    control = new Element(attributeControl.controlType,{'id' : attributeControl.controlName,
                                                                        'name': attributeControl.controlBind.underscore() });
                    attributeControl.values.each(function(value){
                        var option = new Element('option', { 'value':value } ).update(value);
                        control.insert(option);
                    });
                    if( Object.isUndefined(attributeControl.value) == false )
                        control.selectedIndex = attributeControl.value;
                }else {
                    control = new Element(attributeControl.controlType,{'id' : attributeControl.controlName,
                                                                        'name': attributeControl.controlBind.underscore() });
                    if( Object.isUndefined(attributeControl.value) == false )
                        control.value = attributeControl.value;
                }
            }
            tr.insert( new Element('td', { 'class': 'fieldValue' } ).update(control) );
            if (newLine) this.table.down('tbody').insert(tr);

            //Event.observe(attributeControl.name,'change', this.elementChanged);
        } catch(e) { console.log(e); }
    } ,

    getControlContent: function(attribute){
        if( Object.isUndefined(this.controlMap.get(attribute)) == false ){
            var attributeMap = this.controlMap.get(attribute);
            if($(attributeMap.controlName) != null ){
                attributeMap.value = this.getControlValue(attributeMap.controlName);
                console.log(attributeMap);
                this.controlMap.set(attribute ,attributeMap);
            }
        }
    },

    getControlValue: function(controlID){
        return $(controlID).selectedIndex || $(controlID).value ;
    }
});

