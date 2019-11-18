<#include "navbar.ftlh">
<form action="/registration" method="post" id="form-registration" class="col-md-4 rounded registration-form"style="margin-left: auto; margin-right: auto; margin-top: 20px; background-color: #D6D7D7" role="form">
  <header class="card-header">
    <h1 style="text-align: center;"> Rejestracja</h1>
  </header><br/>

  <div class="row">
    <div class="col-md-12">
      <label>Imię i nazwisko: </label>
      <input id="fullname" name="fullname" type="text" class="form-control" placeholder="Imię i Nazwisko" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Adres email: </label>
      <input id="email" name="email" type="email" class="form-control" placeholder="Adres email" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Pesel: </label>
      <input id="pesel" name="pesel" type="text" class="form-control" placeholder="Pesel" maxlength="11"  minlength="11" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Numer telefonu: </label>
      <input id="number" name="number" type="text" class="form-control" placeholder="Numer telefonu" minlength="9" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Hasło: </label>
      <input id="password" name="password" type="password" class="form-control" placeholder="Hasło (Minimum 6 znaków)"  minlength="6" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Potwierdzenie hasła: </label>
      <input id="confirm-password" name="confirm-password" type="password" class="form-control" placeholder="Potwierdź hasło (Minimum 6 znaków)"  minlength="6" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <button type="submit" id="register" class="btn btn-primary" style="margin-bottom: 20px;">Zarejestruj się </button>
      <a href="/main" class="btn btn-danger" style="margin-bottom: 20px;">Powrót do strony głównej </a>
    </div>
  </div>
</form>

<#include "footer.ftlh">