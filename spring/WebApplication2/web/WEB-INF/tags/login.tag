<%-- 
    Document   : login
    Created on : 25-Oct-2017, 12:49:52 PM
    Author     : JINMIN
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

    <h4>Vérifier le NAS avant de choisir les cours</h4>
    <form class="form-horizontal"  action="${root}/Cours" method="post">
      <div class="form-group">
        <label class="control-label col-sm-2" >NAS:</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="nas" id='nas'>
        </div>
      </div>
      <div class="form-group"> 
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">Envoyer</button>&nbsp;&nbsp;
          <button type='reset' class="btn btn-default">Annuler</button>           
        </div>
      </div>   
    </form>    
    <h4>${message}</h4>