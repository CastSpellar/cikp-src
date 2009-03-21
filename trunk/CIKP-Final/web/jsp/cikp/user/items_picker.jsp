<%-- 
    Document   : items_picker
    Created on : 20/Mar/2009, 1:55:14
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="itemspicker.title" /></title>
        <script type="text/javascript" language="javascript">

            function init() {
                /*var tree = new OntXTree('/CIKP-Final/ontxml/Human_Physical_Attribute.xml') ;
                tree.genTree('tree_div', {'dropIds' : $w('DefineActor_actortype DefineActor_roles'), 'imgPath' : '/CIKP-Final/images/custom/', 'checkbox' : 1}) ;*/
                var tree = new dhtmlXTreeObject("tree_div","100%","100%",0) ;
                tree.setImagePath("/CIKP-Final/images/custom/");
                tree.enableCheckBoxes(1);
                tree.loadXML('/CIKP-Final/ontxml/Human_Physical_Attribute.xml');
            }

        </script>
        <script>

            if ( typeof window.addEventListener != "undefined" )
                window.addEventListener( "load", init, false );
            else if ( typeof window.attachEvent != "undefined" ) {
                window.attachEvent( "onload", init );
            }
            else {
                if ( window.onload != null ) {
                    var oldOnload = window.onload;
                    window.onload = function ( e ) {
                        oldOnload( e );
                        init();
                    };
                }
                else
                    window.onload = init;
            }

        </script>
    </head>
    <body>
        <div id="center">
            <div class="box" id="actor_div">
                <div id="tree_div">

                </div>
            </div>
        </div>
    </body>
</html>
