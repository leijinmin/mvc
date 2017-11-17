<%-- 
    Document   : SendEmail
    Created on : 2017-10-05, 10:45:24
    Author     : 1697899
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:body>
        <div class="container">
        <form:form class="form-horizontal"  action="${root}/Mail" method="post" modelAttribute="email">
          <div class="form-group">
            <label class="control-label col-sm-2" >Votre E-mail</label>
            <div class="col-sm-10">
                
              <!--<input type="email" class="form-control" name="from" placeholder="De l'adresse">-->
              <form:input path="from" cssClass="form-control"/>&nbsp;<form:errors path="from" />
            </div>
          </div>
          
          <div class="form-group"> 
            <label class="control-label col-sm-2">Subjet</label>
            <div class="col-sm-10"> 
              <!--<input type="text" class="form-control" name="subject" placeholder="Subjet">-->
              <form:input path="subject" cssClass="form-control"/>&nbsp;<form:errors path="subject" />
            </div>
          </div>
          
          <div class="form-group"> 
            <label class="control-label col-sm-2">Message</label>
            <div class="col-sm-10"> 
                <!--<textarea class="form-control" name="contenu" placeholder="Entrer le message"></textarea>-->
                <form:textarea path="message" cssClass="form-control"/>
            </div>
          </div>
          
          <div class="form-group"> 
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">Envoyer</button>&nbsp;&nbsp;
              <button type='reset' class="btn btn-default">Annuler</button>           
            </div>
          </div>
        </form:form>
          <h3>${message}</h3>
        </div>      
    </jsp:body>
</t:layout>