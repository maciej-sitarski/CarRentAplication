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
  <link rel="stylesheet" href="css/modalLogin.css">
  <title>CarRent</title>
  <link href="https://fonts.googleapis.com/css?family=Lato&display=swap&subset=latin-ext" rel="stylesheet">
  <link rel="stylesheet" href="/fontello/css/map.css" type="text/css">
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
        <a class="nav-link " href="mock"> Mockowanie </a>
      </li>

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

      <li class="nav-item mr-4">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Zaloguj się</a>
      </li>
    </ul>
  </div>
</nav>

<div class="modal fade" id="loginModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Prosimy o zalogowanie się  </h4>
      </div>
      <div class="modal-body">
        <label><strong>Adres email: </strong></label><br/>
        <input type="text"><br/>
        <label><strong>Hasło: </strong></label><br/>
        <input type="password">
      </div>
      <div class="modal-footer">
        <a href="#" class="btn btn-success"style="position: absolute; left: 20px;">Zaloguj się </a>
        <p style="position: absolute; left: 130px;">lub
          <a class="registration" href="/registration">Utwórz konto </a>
        </p>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Zamknij</button>
      </div>
    </div>

  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
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