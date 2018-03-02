$(function() {
    //form je podle id, ktere mám v jsp; name, surname... jsou podle atributu name
    $("#form").validate({
        rules : {
            name : {
                required : true,
                minlength : 2,
                maxlength : 60
            }
            ,
            surname : {
                required : true,
                minlength : 2,
                maxlength : 60
            }
            ,
            birthDay : {
                // todo přidat validaci prázdného pole

            }

        },
        messages : {
            name : {
                required : "Zadejte jméno",
                minlength : $.format("Minimalní délka jsou {0} znaky!"),
                maxlength : $.format("Maximalní délka je {0} znaků!")
            }
            ,
            surname : {
                required : "Zadejte příjmení",
                minlength : $.format("Minimalní délka jsou {0} znaky!"),
                maxlength : $.format("Maximalní délka je {0} znaků!")
            }
            ,
            birthDay : {
            //    todo
            }
        }
    });


});