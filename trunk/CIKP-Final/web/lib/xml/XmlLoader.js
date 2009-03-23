/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var XmlLoader = Class.create({
    initialize: function(url) {
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
    },
    getDocument: function(){
        return this.xmlDoc ;
    }
}) ;
