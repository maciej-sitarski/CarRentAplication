<#include "navbar.ftlh">

<div class="container-fluid">
  <div class="row">
    <div class="departments-left col-md-6" style="margin-bottom: 170px">
      <div class="map position-relative">
        <img class="img" src="img/mapa.jpg" style="width: 80%">
        <a class="departments" href="/reservations?city=Gdańsk">
          <i class="icon-location-1 position-absolute" style="left:43%; top: 8%">Gdańsk</i>
        </a>

        <a class="departments" href="/reservations?city=Szczecin">
          <i class="icon-location-1 position-absolute" style="left:14%; top: 18%">Szczecin</i>
        </a>

        <a class="departments" href="/reservations?city=Kraków">
          <i class="icon-location-1 position-absolute" style="left:51%; top: 73%">Kraków</i>
        </a>

        <a class="departments" href="/reservations?city=Warszawa">
          <i class="icon-location-1 position-absolute" style="left:58%; top:43%">Warszawa</i>
        </a>

        <a class="departments" href="/reservations?city=Lublin">
          <i class="icon-location-1 position-absolute" style="left:69%; top: 52%">Lublin</i>
        </a>

        <a class="departments" href="/reservations?city=Poznan">
          <i class="icon-location-1 position-absolute" style="left:30%; top: 40%">Poznan</i>
        </a>

        <a class="departments" href="/reservations?city=Łódź">
          <i class="icon-location-1 position-absolute" style="left:49%; top: 48%">Łódź</i>
        </a>
        <a class="departments" href="/reservations?city=Wrocław">
          <i class="icon-location-1 position-absolute" style="left:29%; top: 57%">Wrocław</i>
        </a>
      </div>
    </div>
    <div class="departments-right col-md-6">
      <h1>
        Wybierz swój oddział:
      </h1><br/>
        <#list departments as department>
          <li>
            <a class="department" href="/reservations?city=${department.city}">${department.city}</a>
          </li>
        </#list>
    </div>

<#include "footer.ftlh">