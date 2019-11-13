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
    Samochody:
  </h1><br/>
  <div class="row">
      <#list sections>
          <#items as section>
            <div class="left-container">
              <h2>${section.name}</h2>
                <#list cars>
                    <#items as car>
                        <#if car.modelDto.sectionDto.name == section.name>
                          <div class="col-md-4" id="car-card">
                            <a href="#">${car.brandDto.name} ${car.modelDto.name}</a>
                          </div>
                        </#if>
                    </#items>
                </#list>
            </div>
          </#items>
      </#list>
  </div>
</div>

<#include "footer.ftlh">