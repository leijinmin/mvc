<%-- 
    Document   : footer_menu
    Created on : 25-Oct-2017, 10:22:59 AM
    Author     : JINMIN
--%>

<%@tag description="Footer menu" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:if test="${etudiant != null}">
<div id="pagefooter">
    <ul>
        <li><a href="${root}/Panier">Voir mon panier</a></li>
        <li><a href="${root}/Index">Retourner à l'accueil</a></li>
    </ul>
</div> 
</c:if>
