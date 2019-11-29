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
                'data-id-departmentStart')+ '/' + $(this).attr(
                'data-id-reservationPrice'),
        type: 'PATCH',
        success: function () {
          location.replace("/reservations-success");
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $("#deleteReservation").click(function () {
      $.ajax({
        url: '/api/reservations/delete/' + $(this).attr('data-id-reservation'),
        type: 'PATCH',
        success: function () {
          location.replace("/reservations-delete-success");
        }
      });
    });
  });
});

