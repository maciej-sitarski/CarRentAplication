<#include "navbar.ftlh">
<div class="container-fluid">
  <h1>
    Wybiez swój oddział:
  </h1><br/>
    <div class="row">
      <div class="col-md-4" id="car-card">
        <#list cars>
          <#items as car>
            <a href="#"> Marka: ${car.brand} Model: ${car.model}</a>
          </#items>
        </#list>
      </div>
      <div class="col-md-4" id="car-card">
        <a href="#">Sienka</a>
      </div>
      <div class="col-md-4" id="car-card">
        <a href="#">Sienka kurwa</a>
      </div>
        <div class="col-md-4" id="car-card">
          <a href="#">Opel</a>
        </div>
    </div>
  <div class="row">

  </div>
</div>

<#include "footer.ftlh">