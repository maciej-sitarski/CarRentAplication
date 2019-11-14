$(function () {
  $(document).ready(function () {
    $("#giveMenager").click(function () {
      $.ajax({
        url: '/api/clients/giveMenager/' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $("#giveCoordinator").click(function () {
      $.ajax({
        url: '/api/clients/giveCoordinator/' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});

$(function () {
  $(document).ready(function () {
    $("#giveWorker").click(function () {
      $.ajax({
        url: '/api/clients/giveWorker/' + $(this).attr('data-id'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});