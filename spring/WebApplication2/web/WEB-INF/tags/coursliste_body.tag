<%-- 
    Document   : coursliste_body
    Created on : 25-Oct-2017, 10:26:29 AM
    Author     : JINMIN
--%>

<%@tag description="La liste des cours" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:choose>
    
   <c:when test="${etudiant == null}">
       <t:login />
   </c:when> 
   
   <c:otherwise>
       <t:liste_body cours="${cours}" panier="${panier}"/>                  
   </c:otherwise>   
    
</c:choose>  
