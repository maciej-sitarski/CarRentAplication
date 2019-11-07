<#include "navbar.ftlh">
<form id="registration-form" class="col-md-4 rounded"style="margin-left: auto; margin-right: auto; margin-top: 20px; background-color: #D6D7D7" role="form">
  <header class="card-header">
    <h1 style="text-align: center;"> Rejestracja</h1>
  </header><br/>

  <div class="row">
    <div class="col-md-12">
      <label>Imię i nazwisko: </label>
      <input type="text" class="form-control" placeholder="Imię i Nazwisko" required>
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Adres email: </label>
      <input type="email" class="form-control" placeholder="Adres email">
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Pesel: </label>
      <input type="text" class="form-control" placeholder="Pesel" maxlength="11">
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Numer telefonu: </label>
      <input type="text" class="form-control" placeholder="Numer telefonu" maxlength="9">
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <label>Hasło: </label>
      <input type="password" class="form-control" placeholder="Hasło">
    </div>
  </div><br/>
  <div class="row">
    <div class="col-md-12">
      <a href="/main" class="btn btn-primary" style="margin-bottom: 20px">Zarejestruj się </a>
      <a href="/main" class="btn btn-danger" style="margin-bottom: 20px; position: absolute; right: 15px;">Powrót do strony głównej </a>
    </div>
  </div>
</form>
<#include "footer.ftlh">