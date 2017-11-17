<%-- 
    Document   : menu
    Created on : 25-Oct-2017, 10:04:16 AM
    Author     : JINMIN
--%>

<%@tag description="Header menu" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<img src="${root}/resources/images/oc-logo.svg" class="inject-me" />
<nav>
    <ul>
        <li><a href='${root}/Index' class='${css.get("Accueil")}'>Accueil</a></li>
        <li><a href='${root}/Cours' class='${css.get("Listecours")}'>Choix de cours</a></li>
        <li><a href='${root}/Mail/' class='${css.get("SendEmail")}'>Nous contacter</a></li>
        <c:if test="${etudiant!= null}">
        <li><a href='${root}/Index/Logout'>Déconnexion</a> </li> 
        </c:if>
        
    </ul>
</nav>