// Résultat de Get 
function getCallBack(data, status, message, func) {
    if (status == "success") $('#content').html(data);
    else $('#content').html(message);
}
// Résultat de Post 
function reloadCallBack(data, status, message) {
    if (status == "success") {
        $('#content').html(data);
        // S'il y a pas d'erreur, renouveller la page pour faire changer le statut de connexion dans la page
        if ($('.field-validation-error').length === 1 && $('.field-validation-error').text().trim() === "")
            location.reload();
    }
    else $('#content').html(data.responseText);
}

$(document).ready(function () {
    // Get
    $(document).on('click', 'a', function (e) {
        e.preventDefault();
        var route = $(this).attr('href');
        if (route.search(/\/[a-z]+\/[a-z]+/i) >= 0) // si c'est une route respectant le format '/Controlleur/Action/'
            $.get(route, function (data, status) {
                getCallBack(data, status, 'Échouer à obtenir les donnée!');
            });
        else
            $('#logoutForm').submit();

    });
    // Post
    $(document).on('click', 'button', function (e) {
        e.preventDefault();
        var buttonId = this.id
          , formId = '#' + buttonId + 'Form';
        $.post($(formId).attr('action'), $(formId).serialize(), function (data, status) {
            if (buttonId === "Register" || buttonId === "Login")
                reloadCallBack(data, status, 'Échouer à sauvegarder les donnée!');
            else
                getCallBack(data, status, 'Échouer à sauvegarder les donnée!');
        });
    });

});