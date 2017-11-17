<%-- 
    Document   : liste_body
    Created on : 25-Oct-2017, 12:54:03 PM
    Author     : JINMIN
--%>

<%@tag description="Liste des cours" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@taglib uri="http://leijinmin.github.io/mytaglib" prefix="my" %> 
<%@tag import="Models.*" %>
<%@tag import="java.util.List" %>
<%@attribute name="cours" type="List<Cours>"%>
<%@attribute name="panier" type="List<Cours>"%>

<c:choose>
    <c:when test="${cours == null}">
        <c:set var="liste" value="${panier}" />
    </c:when>
    <c:otherwise>
        <c:set var="liste" value="${cours}" />
    </c:otherwise>
</c:choose>

        <table  class="table">
            <thead class="thead-inverse">
            <tr>
                <c:if test="${cours == null}">
                <th>
                    <input type='checkbox' name='numero' id="all"/>
                </th>
                </c:if>
                <th>Numero</th>
                <th>Intitulé</th>
                <th>Session</th>
                <th>Nombre de Crédits</th>
                <th>Plan de cours</th>
                <c:if test="${cours != null}">
                <th>
                    <img src="${root}/resources/images/cart.svg" class="inject-me-cart"/>&nbsp;[${panier.size()}]
                </th>
                </c:if>
            </tr>
            </thead>
            <form action="${root}/Panier/Supprimer" action="post">
            <tbody>
            <c:forEach var = "c" items="${liste}">
                <tr>
                <c:if test="${cours == null}">
                <td><input type='checkbox' name='numero' value='${c.getNumero()}' unchecked /></td>
                </c:if>
                <td>${c.getNumero()}</td>
                <td>${c.getIntitule()}</td>
                <td>${c.getSession()}</td>
                <td>${c.getNombreCredits()}</td>
                <td><a href="${root}/resources/detailsCours.html" target="_blank">${c.getNomFicher()}</a></td> 
                <c:if test="${cours != null}">
                    <td>
                        <c:if test="${not my:existe(c.getNumero(),panier)}">
                            <a href="${root}/Cours/${c.getNumero()}/Ajouter">Ajouter</a>
                        </c:if>
                    </td> 
                </c:if>
            </tr>
            </c:forEach>   
            </tbody>
            </form>
        </table>