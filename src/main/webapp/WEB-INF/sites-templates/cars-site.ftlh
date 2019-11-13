<#include "navbar.ftlh">
<div class="container-fluid">
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