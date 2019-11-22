$(function(){
  $("#departmentsMenu li a").click(function(){
    var target = $(this).closest('.btn-group').find('.btn:first-child')
    target.text($(this).text());
    target.val($(this).text());
  });
});

$(function () {
  $(document).ready(function () {
    $("#checkOpportunityToReservation").click(function () {
      $.ajax({
        url: '/api/reservations/check/'+$(this).attr('data-id-departmentStart')+'/' + $(this).attr('data-id-departmentFinish')+'/' + $(this).attr('data-id-startDate')+'/' + $(this).attr('data-id-startHour')+'/' + $(this).attr('data-id-backDate')+'/' + $(this).attr('data-id-backHour')+'/' + $(this).attr('data-id-brandName')+'/' + $(this).attr('data-id-modelName'),
        type: 'PATCH',
        success: function (result) {
          location.replace("/reservation-equipment");
        },
        error: function (error) {
          alert(
              'Error! Holiday has not been added/updated. Check data in your form');
        }
      });
    });
  });
});


















// $(function () {
//   var departmentStart = document.getElementById("departmentStart");
//   var departmentFinish = document.getElementById("departmentFinish");
//   var departmentStartValue = departmentStart.options[departmentStart.selectedIndex].text;
//   var departmentFinishValue = departmentFinish.options[departmentFinish.selectedIndex].text;
//   $("#firstStepOfReservation").click(function () {
//     $.ajax({
//       url: "/reservations",
//       method: "POST",
//       data: $('form#form-reservation').serialize(),
//       success: function () {
//         window.location("/reservations-cars?startDate="+$(this).attr('data-id-startDate')+"&startHour="+$(this).attr('data-id-startHour')+"&backDate="+$(this).attr('data-id-backDate')+"&backHour="+$(this).attr('data-id-backHour')+"&departmentStart="+departmentStartValue+"&departmentFinish="+departmentFinishValue);
//       }
//     });
//   });
// });
// $(function () {
//   var departmentStart = document.getElementById("departmentStart");
//   var departmentFinish = document.getElementById("departmentFinish");
//   var departmentStartValue = departmentStart.options[departmentStart.selectedIndex].text;
//   var departmentFinishValue = departmentFinish.options[departmentFinish.selectedIndex].text;
//   $("#firstStepOfReservation").click(function () {
//     $.ajax({
//       url: "/reservations",
//       method: "POST",
//       data: $('form#form-reservation').serialize(),
//       success: function () {
//         window.location("/reservations-cars?startDate="+$(this).attr('data-id-startDate')+"&startHour="+$(this).attr('data-id-startHour')+"&backDate="+$(this).attr('data-id-backDate')+"&backHour="+$(this).attr('data-id-backHour')+"&departmentStart="+departmentStartValue+"&departmentFinish="+departmentFinishValue);
//       }
//     });
//   });
// });