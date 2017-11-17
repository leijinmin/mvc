<%-- 
    Document   : layout
    Created on : 3-Oct-2017, 9:56:47 AM
    Author     : JINMIN
--%>

<%@attribute name="pagefooter" fragment="true" %>
<%@attribute name="title" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://leijinmin.github.io/mytaglib" prefix="my" %> 
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@tag import="Controllers.Vars" %>

<c:set var="root" value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="title" value="${my:title(pageContext.request)}" />
<c:set var="css" value="${my:css(pageContext.request)}" scope="request"/>
<c:set var="etudiant" value="${Vars.NAME_ID}" />
<c:set var="panier" value="${Vars.NAME_LIST}" />

<html>      
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/style.css">   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/svg-injector/1.1.3/svg-injector.min.js" integrity="sha256-CjBlJvxqLCU2HMzFunTelZLFHCJdqgDoHi/qGJWdRJk=" crossorigin="anonymous"></script>
    <title></title>
  
    <body>
      
      <div id="pageheader" class="container-fluid">       
        <t:header_menu />       
      </div>
        
      <div id="main"  class="container-fluid">         
        <h3>${title}</h3>         
        <jsp:doBody/>         
        <jsp:invoke fragment="pagefooter"/>  
      </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${root}/resources/js/myscript.js"></script>     

    </body>
</html>