<#include "navbar.ftlh">

<div class="container-fluid">
  <div class="row">
    <div class="departments-left col-md-6" style="margin-bottom: 170px">
      <div class="map position-relative">
        <img class="img" src="img/mapa.jpg" style="width: 80%">
        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:43%; top: 8%">Gdańsk</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:14%; top: 18%">Szczecin</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:51%; top: 73%">Kraków</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:58%; top:43%">Warszawa</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:69%; top: 52%">Lublin</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:30%; top: 40%">Poznan</i>
        </a>

        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:49%; top: 48%">Łódź</i>
        </a>
        <a class="departments" href="#">
          <i class="icon-location-1 position-absolute" style="left:29%; top: 57%">Wrocław</i>
        </a>
      </div>
    </div>
    <div class="departments-right col-md-6">
      <h1>
        Wybiez swój oddział:
      </h1><br/>
        <#list departments as department>
          <li>
            <a class="department" href="#">${department.city}</a>
          </li>
        </#list>
    </div>

<#include "footer.ftlh">