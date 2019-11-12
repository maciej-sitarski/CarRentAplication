<!DOCTYPE html>
<html lang="pl">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <!-- Our CSS -->
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" href="css/departments.css">
  <link rel="stylesheet" href="css/navbar.css">
  <title>CarRent</title>
  <link href="https://fonts.googleapis.com/css?family=Lato&display=swap&subset=latin-ext"
        rel="stylesheet">
  <link rel="stylesheet" href="/fontello/css/map.css" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="/js/registration-form.js"></script>
  <script src="/js/login.js"></script>

</head>

<body>

<nav class="navbar navbar-expand-md">

  <a class="navbar-brand mr-5" href="/main"><img src="img/logo.png" width="80" height="50"
                                                 class="d-inline-block mr-2 ">Fast&Cheap</a>

  <button class="navbar-toggler navbar-dark" type="button" data-toggle="collapse"
          data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false"
          aria-label="Przełącznik nawigacji">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="mainmenu">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item mr-4">
        <a class="nav-link" href="/main"> Strona główna </a>
      </li>

      <li class="nav-item mr-4">
        <a class="nav-link" href="#"> Rezerwacje </a>
      </li>

      <li class="nav-item mr-4">
        <a class="nav-link " href="#"> Samochody </a>
      </li>

      <li class="nav-item mr-4">
        <a class="nav-link mr-auto" href="/departments"> Oddziały </a>
      </li>

        <#if type=="Admin"||>
          <li class="nav-item mr-4 dropdown">
            <a class="nav-link dropdown-toggler" data-toggle="dropdown" role="button" href="#"
               aria-expanded="false" id="submenu" aria-haspopup="true">Panel użytkownika</a>
            <div class="dropdown-menu" aria-labelledby="submenu">
              <a class="dropdown-item" href="#">Profil użytkownika</a>
              <a class="dropdown-item" href="#">Twoje rezerwacje</a>
              <button class="dropdown-item btn btn-danger" id="log-out">Wyloguj się</button>
            </div>
          </li>

        <#else>
          <li class="nav-item mr-4">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Zaloguj
              się</a>
          </li>
        </#if>

    </ul>
  </div>
</nav>

<form id="form-login" role="form">
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Prosimy o zalogowanie się </h4>
        </div>
        <div class="modal-body">
          <label><strong>Adres email: </strong></label><br/>
          <input name="email" id="email" type="text"><br/>
          <label><strong>Hasło: </strong></label><br/>
          <input name="password" id="password" type="password">
        </div>
        <div class="modal-footer">
          <button type="button" id="login" class="btn btn-success"
                  style="position: absolute; left: 20px;">Zaloguj się
          </button>
          <p style="position: absolute; left: 130px;">lub
            <a class="registration" href="/registration">Utwórz konto </a>
          </p>
          <button type="button" class="btn btn-danger" data-dismiss="modal">Zamknij</button>
        </div>
      </div>

    </div>
  </div>

</form>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>