<#include "navbar.ftlh">


Lista samochodów - cars
Lista segmentów - brands
<div class="container-fluid">
    <#list brands as brand>
        <div class="row">
            <h1>Nazwa segmentu: ${brand.name}</h1>
            <#list cars as car>
            <div>
              <#if car.brand.name == brand>
                ${car.department.city}
                ${car.model.name}
                ${car.model.section.name}
                ${car.brand.name}
              </#if>
            </div>
            </#list>
        </div>
     </#list>




































      <li>
        <a class="car" href="#">${(car.model.name)}</a>
      </li>
    </#list>
  <h1>
    Wybiez swój oddział:
  </h1><br/>
    <div class="row">
      <div class="col-md-4" id="car-card">
        <a href="#">Opel</a>
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