$(function () {
  $(document).ready(function () {
    $(".givePermission").click(function () {
      $.ajax({
        url: '/api/clients/'+$(this).attr('data-id-permission')+'/' + $(this).attr('data-id-client'),
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
    $(".giveDepartments").click(function () {
      $.ajax({
        url: '/api/workers/departments/'+$(this).attr('data-id-department')+'/' + $(this).attr('data-id-worker'),
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
    $(".givePermissionWorker").click(function () {
      $.ajax({
        url: '/api/workers/permission/'+$(this).attr('data-id-permission')+'/' + $(this).attr('data-id-worker'),
        type: 'PATCH',
        success: function (result) {
          location.reload();
        }
      });
    });
  });
});
