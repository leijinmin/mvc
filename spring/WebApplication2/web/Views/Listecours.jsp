<%-- 
    Document   : Listecours
    Created on : 3-Oct-2017, 10:47:17 AM
    Author     : JINMIN
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    
    <jsp:attribute name="pagefooter">
        <t:footer_cours_menu />
    </jsp:attribute>   
    
    <jsp:body>     
        <t:coursliste_body />
    </jsp:body>  
    
</t:layout>