$(function () {
  $('#login').click(function () {
    $.ajax({
      url: "/login",
      method: "POST",
      data: $('form#form-login').serialize(),
      success: function () {
        location.reload();
      },
      error: function (error) {
        alert('Wpisano nieprawidłowe dane. Wpisz ponownie swoje dane lub załóż konto');
      }
    });
  });
});

$(function () {
  $('#log-out').click(function () {
    $.ajax({
      url: "/log-out",
      method: "POST",
      success: function () {
        location.reload();
      }
    });
  });
});



