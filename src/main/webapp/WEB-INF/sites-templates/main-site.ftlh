<#include "navbar.ftlh">
<#include "jumbotron.ftlh">
<div class="container-fluid">
  <div class="row" style="height: 100%">
    <div class="col-md-4" id="main-cards">
      <a href="/cars" class="cards-link" style="color: #052F09;">
        <h2 class="card-header" style="font-weight: bold">Samochody</h2>
      </a>
        <div class="card-body">
          <h5>Przeglądaj zbiór dostępnych aut. Wybierz segment samochodu i dokonuj najlepszego
            wyboru.
          </h5>
        </div>
    </div>
    <div class="col-md-4" id="main-card">
      <a href="/departments" class="cards-link" style="color: #052F09;">
        <h2 class="card-header" style="font-weight: bold">Oddziały</h2>
      </a>
        <div class="card-body">
          <h5>Sprawdź w jakich miastach możesz wynająć auto.</h5>
        </div>

    </div>
    <div class="col-md-4" id="main-cards">
      <a href="#" class="cards-link" style="color: #052F09;">
        <h2 class="card-header" style="font-weight: bold">Rezerwacje</h2>
      </a>
        <div class="card-body">
          <h5>Sprawdź dostępnośc wybranych aut i rezerwuj swoje auto przez internet!</h5>
        </div>

    </div>
  </div>
</div>
<#include "footer.ftlh">

