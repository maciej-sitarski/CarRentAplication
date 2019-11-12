// function validate()
// {
//   var fullname = document.getElementById("fullname").value;
//   var email = document.getElementById("email").value;
//   var pesel = document.getElementById("pesel").value;
//   var password = document.getElementById("password").value;
//
//   if (fullname==null || fullname=="")
//   {
//     alert("Pole imię i nazwisko musi zostać wypełnione");
//     return false;
//
//   }
//   else if (email==null || email=="")
//   {
//     alert("Pole email musi zostać wypełnione");
//     return false;
//   }
//   else if (pesel==null || pesel=="")
//   {
//     alert("Pole pesel musi zostać wypełnione");
//     return false;
//   }
//
//   else if(password.size<6)
//   {
//     alert("Hasło musi zawierać więcej niż 6 znaków");
//     return false;
//   }
//   else{
//     $(function () {
//         $.ajax({
//           url: "/registration",
//           method: "POST",
//           data: $('form#form-registration').serialize(),
//           success: function () {
//             alert('Rejestracja przebiegła prawdiłowo. Teraz możesz się zalogować')
//             location.replace("/main")
//           },
//           error: function (error) {
//             alert('Rejestracja nieudana');
//           }
//         });
//       });
//     return true;
//   }
// }
//
// function popupWindow() {
//   window.open( "someLinkToBePoppedUp" )
// }



// }
//
// //
// // function refreshPage(){
// //   window.location.reload();
// // }
//
// // $(function () {
// //   $('#register').click(function () {
// //     $.ajax({
// //       url: "/registration",
// //       method: "POST",
// //       success: function () {
// //         location.replace("/main");
// //       },
// //       error: function (error) {
// //         alert('Nie można dodać wydarzenia do ulubionych. Maksymalna liczba wydarzeń ulubionych wynosi 3');
// //       }
// //     });
// //   });
// // });
//
// // $(function () {
// //   $('#register').click(function () {
// //     $.ajax({
// //       url: "/registration",
// //       method: "POST",
// //       data: $('form#form-registration').serialize(),
// //       success: function () {
// //         alert('Rejestracja przebiegła prawdiłowo. Teraz możesz się zalogować')
// //         location.replace("/main")
// //       },
// //       error: function (error) {
// //         alert('Rejestracja nieudana. Sprawdź czy uzupełniłeś wszystkie pola');
// //       }
// //     });
// //   });
// // });