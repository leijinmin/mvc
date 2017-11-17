<%-- 
    Document   : Accueil
    Created on : 3-Oct-2017, 10:09:47 AM
    Author     : JINMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="Models.*" %>
<%@page import="java.util.*" %>

<t:layout>
    <jsp:body>
        <h1>Qui sommes-nous ? </h1>
        <h3>OpenClassrooms veut rendre l'éducation accessible à tous et favorise un apprentissage communautaire et engageant. </h3>
        <p>Nous vous proposons des cours ouverts pour vous former autrement, pour devenir acteur de votre vie. Nous vous aidons à prendre votre envol, mais ça ne s'arrête pas là. Notre volonté est de vous accompagner tout au long de votre vie, dans votre parcours professionnel. </p>
        <p>Nous, Mathieu Nebra et Pierre Dubuc, fondateurs d'OpenClassrooms et toute notre équipe de 35 personnes, sommes à vos côtés tous les jours. Curieux et férus de pédagogie et de technologie, nous n'avions que 13 et 11 ans lorsque nous avons commencé à travailler sur ce projet : proposer un cours d'informatique en ligne pour ceux qui veulent apprendre à coder. Rapidement une communauté de passionnés nous rejoignent et participent au développement du site en proposant également des cours. </p>
        <p>Nous prenons en 2012, le virage des cours certifiants et nous sommes devenus en quelques années la plateforme de référence dans l'apprentissage du code, du numérique et de la culture digitale. Premier site d'e-Éducation en Europe avec près de 3 millions d'utilisateurs par mois et plus de 1000 cours en ligne, nous sommes dorénavant un champion français du secteur edTech et nous proposons désormais nos formations en entreprise. </p>
        <c:if test="${inscriptions != null && inscriptions.size() > 0}">
        <table class="table">
            <thead class="thead-inverse">
            <tr>         
                <th>NAS</th>
                <th>Numéro du cours</th>
                <th>Date d'inscription</th>              
            </tr>
            </thead>
            <tbody>
            <c:forEach var = "c" items="${inscriptions}">
            <tr>
                <td>${c.getNas()}</td>
                <td>${c.getNumeroCours()}</td>
                <td>${c.getCalendar().getTime()}</td>     
            </tr>
            </c:forEach>  
            </tbody>
        </table>        
        </c:if>
    </jsp:body>
</t:layout>
        
        