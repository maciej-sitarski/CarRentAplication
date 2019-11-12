<#include "navbar.ftlh">

<form action="/profile" method="post" id="form-profile" class="col-md-4 rounded profile-form"style="margin-left: auto; margin-right: auto; margin-top: 20px; background-color: #8EDAE6" role="form">
  <header class="card-header">
    <h1 style="text-align: center; background-color: #4B98A4"> Twój profil</h1>
  </header><br/>

  <div class="row">
    <div class="col-md-12">
      <label>Imię i nazwisko: ${client.fullname} </label>
      <input id="fullname" name="fullname" type="text" class="form-control" placeholder="Imię i Nazwisko" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Adres email: ${client.email}</label>
      <input id="email" name="email" type="email" class="form-control" placeholder="Adres email" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Pesel: ${client.pesel}</label>
      <input id="pesel" name="pesel" type="text" class="form-control" placeholder="Pesel" maxlength="11" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Numer telefonu: ${client.phoneNumber}</label>
      <input id="number" name="number" type="text" class="form-control" placeholder="Numer telefonu" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Hasło: </label>
      <input id="password" name="password" type="password" class="form-control" placeholder="Hasło" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <button type="submit" id="register" class="btn btn-primary" style="margin-bottom: 20px;">Zapisz zmiany </button>
      <a href="/main" class="btn btn-danger" style="margin-bottom: 20px;">Powrót do strony głównej </a>
    </div>
  </div>
</form>

<#include "footer.ftlh">