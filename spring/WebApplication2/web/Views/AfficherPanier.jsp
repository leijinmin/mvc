<%-- 
    Document   : AfficherPanier
    Created on : 3-Oct-2017, 9:44:23 PM
    Author     : JINMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>

    <jsp:attribute name="pagefooter">
        <t:footer_panier_menu />
    </jsp:attribute>       
    
    <jsp:body> 
        <h4>Nom: ${etudiant.getPrenom()} ${etudiant.getNom()}</h4>
        <t:liste_body panier="${panier}"/>
    </jsp:body>  

</t:layout>
