// $(function() {
//
//     $('#showLogin').click(function(e) {
//         $("#sectionA").delay(100).fadeIn(100);
//         $("#sectionB").fadeOut(100);
//         $('#showRegister').removeClass('active');
//         $(this).addClass('active');
//         e.preventDefault();
//     });
//     $('#showRegister').click(function(e) {
//         $("#sectionB").delay(100).fadeIn(100);
//         $("#sectionA").fadeOut(100);
//         $('#showLogin').removeClass('active');
//         $(this).addClass('active');
//         e.preventDefault();
//     });
//
// });

function toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})