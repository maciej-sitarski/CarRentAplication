$(function () {
  $("#departmentsMenu li a").click(function () {
    var target = $(this).closest('.btn-group').find('.btn:first-child')
    target.text($(this).text());
    target.val($(this).text());
  });
});

function redirectToEquipmentSite(departmentStart, startDate, startHour,
    backDate, backHour, brandName, modelName, sectionName, sectionPrice) {
  window.location = "reservations-equipment?startDate=" + startDate
      + "&startHour=" + startHour + "&backDate=" + backDate + "&backHour="
      + backHour + "&departmentStart=" + departmentStart + "&brandName="
      + brandName + "&modelName=" + modelName + "&sectionName=" + sectionName
      + "&sectionPrice=" + sectionPrice
}

function dynInputBabyCarrier(cbox) {
  if (cbox.checked) {
    var input = document.createElement("input");
    input.type = "number";
    input.name = "babyCarriesNumbers";
    input.value = "1";
    input.min = "1";
    input.max = "3";
    input.style = "width: 40px";
    var div = document.createElement("div");
    div.id = cbox.name;
    div.innerHTML = "Ilość: ";
    div.appendChild(input);
    document.getElementById("babyCarrierCounter").appendChild(div);
  } else {
    document.getElementById(cbox.name).remove();
  }
}

function dynInputSmallSeat(cbox) {
  if (cbox.checked) {
    var input = document.createElement("input");
    input.type = "number";
    input.name = "smallSeatNumbers";
    input.value = "1";
    input.min = "1";
    input.max = "3";
    input.style = "width: 40px";
    var div = document.createElement("div");
    div.id = cbox.name;
    div.innerHTML = "Ilość: ";
    div.appendChild(input);
    document.getElementById("smallSeatCounter").appendChild(div);
  } else {
    document.getElementById(cbox.name).remove();
  }
}

function dynInputSeat(cbox) {
  if (cbox.checked) {
    var input = document.createElement("input");
    input.type = "number";
    input.name = "seatNumbers";
    input.value = "1";
    input.min = "1";
    input.max = "3";
    input.style = "width: 40px";
    var div = document.createElement("div");
    div.id = cbox.name;
    div.innerHTML = "Ilość: ";
    div.appendChild(input);
    document.getElementById("seatCounter").appendChild(div);
  } else {
    document.getElementById(cbox.name).remove();
  }
}

function goBack() {
  window.history.back();
}

$(function () {
  $(document).ready(function () {
    $("#saveReservation").click(function () {
      $.ajax({
        url: '/api/reservations/save/' + $(this).attr('data-id-startDate')
            + '/' + $(this).attr('data-id-startHour') + '/' + $(this).attr(
                'data-id-backDate') + '/' + $(this).attr('data-id-backHour')
            + '/'
            + $(this).attr('data-id-modelName') + '/' + $(this).attr(
                'data-id-idClient') + '/' + $(this).attr(
                'data-id-insuranceFull') + '/'
            + $(this).attr('data-id-insuranceBasic') + '/' + $(this).attr(
                'data-id-navigation') + '/' + $(this).attr(
                'data-id-babyCarrier') + '/'
            + $(this).attr('data-id-babyCarriesNumbers') + '/' + $(this).attr(
                'data-id-smallSeat') + '/' + $(this).attr(
                'data-id-smallSeatNumbers') + '/' + $(this).attr('data-id-seat')
            + '/' + $(this).attr('data-id-seatNumbers') + '/' + $(this).attr(
                'data-id-departmentStart'),
        type: 'PATCH',
        success: function () {
          location.replace("/main");
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