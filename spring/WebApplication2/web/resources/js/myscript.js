(function() {
    /* For showing svg image
     * */
  
    // Elements to inject
    var mySVGsToInject = document.querySelectorAll('img');
    // Do the injection
    SVGInjector(mySVGsToInject);
   
    /* For JQuery events
     * */
    //Validation de supprimer du panier
    $(document).on('click','#supprimer',function(event) {
             event.preventDefault();
             if($('[type=checkbox]:checked').length === 0)
                 alert('Vous n\'avez pas choisi de cours à supprimer.');
             else
                 $('form').submit();
      });


    // Bouton d'Annuler de formulaire
    $(document).on('click','button[type=reset]',function() {
         var r = confirm("Annuler les entrées?");
         if (r === true) {
             $(this).parent()[0].reset();
         }           
     });  
    // Bouton d'Envoyer de formulaire
    $(document).on('click','button[type=submit]',function(){
    event.preventDefault();
    
    var videChamps = $('input[type=text],input[type=email]').filter(function() {
        return this.value.trim() === "";
    });

     if(videChamps.length >0){
        alert("Assurer-vous qu'il n'y pas de champ vide.");                    
     }  
     else
         $(this).parent()[0].submit();               
    });
        
    $(document).on('click','#all',function() {
     $('input:checkbox').not(this).prop('checked', this.checked);
    });

})();
