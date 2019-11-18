<#include "navbar.ftlh">

<form action="/profile" method="post" id="form-profile" class="col-md-4 rounded profile-form"style="margin-left: auto; margin-right: auto; margin-top: 20px; background-color: #8FFE8F" role="form">
  <header class="card-header">
    <h1 style="text-align: center;"> Twój profil</h1>
  </header><br/>

  <div class="row">
    <div class="col-md-12">
      <label>Imię i nazwisko: <strong>${client.fullName}</strong> </label>
      <input id="fullname" name="fullname" type="text" class="form-control" placeholder="Wpisz nowe imię i nazwisko" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Adres email: <strong>${client.email}</strong></label>
      <input id="email" name="email" type="email" class="form-control" placeholder="Wpisz nowy adres email" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Pesel: <strong>${client.pesel}</strong></label>
      <input id="pesel" name="pesel" type="text" class="form-control" placeholder="Wpisz nowy pesel" maxlength="11"  minlength="11" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Numer telefonu: <strong>${client.phoneNumber}</strong></label>
      <input id="number" name="number" type="text" class="form-control" placeholder="Wpisz nowy numer telefonu" minlength="9" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Hasło: </label>
      <input id="password" name="password" type="password" class="form-control" placeholder="Wpisz nowe hasło (Minimum 6 znaków)"  minlength="6" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <button type="submit" id="change" class="btn btn-success" style="margin-bottom: 20px;">Zapisz zmiany </button>
      <a href="/main" class="btn btn-primary" style="margin-bottom: 20px;">Powrót do strony głównej </a>
      <button id="deleteProfile" class="btn btn-danger" data-id-client="${client.id}" style="margin-bottom: 20px;">Usuń konto </button>
    </div>
  </div>
</form>

<#include "footer.ftlh">