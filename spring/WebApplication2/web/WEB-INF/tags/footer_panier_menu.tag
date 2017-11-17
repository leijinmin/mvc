<%-- 
    Document   : footer_panier_menu
    Created on : 25-Oct-2017, 12:06:38 PM
    Author     : JINMIN
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:if test="${etudiant != null}">
<ul>
    <li><a href="" id="supprimer">Supprimer du panier</a></li>
    <li><a href="${root}/Panier/Valider">Valider mes choix</a></li>
</ul>
</c:if>
