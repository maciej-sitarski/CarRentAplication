<#include "navbar.ftlh">
<div class="container-fluid">
  <h1>
    Wybiez swój oddział:
  </h1><br/>
    <div class="row">
      <#list cars>
          <#items as car>
      <div class="col-md-4" id="car-card">
            <a href="#"> Marka: ${car.brandDto.name} Model: ${car.modelDto.name}</a>
      </div>
       </#items>
        </#list>
    </div>
  <div class="row">

  </div>
</div>

<#include "footer.ftlh">