<%-- 
    Document   : Error
    Created on : 2017-10-03, 17:00:22
    Author     : 1697899
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<t:layout>
    <jsp:body>       
        <h1>         
            <c:catch>
                Erreur: <br> 
                ${pageContext.exception} <br> 
                ${pageContext.exception.message}
            </c:catch>            
        </h1>       
    </jsp:body>
</t:layout>
