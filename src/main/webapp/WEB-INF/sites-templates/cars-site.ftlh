<#include "navbar.ftlh">
<div class="container-fluid" style=" margin-bottom: 20px">
  <header class="border-bottom border-success"
          style="text-align:center;  width: 90%; margin-left: auto; margin-right: auto;margin-top: 30px; padding-bottom: 20px">
    <h1>
      <strong>WYPOŻYCZALNIA SAMOCHODÓW</strong>&nbsp;&nbsp;&nbsp;<small
          style="font-family: 'Lato', sans-serif"><i>FAST&CHEAP</i></small>
    </h1>
  </header>
    <#list sections as section>
      <div class="row border-bottom border-success"
           style=" width: 90%; margin-left: auto; margin-right: auto;">
        <div class="left col-md-3"
             style="text-align: center; margin-bottom: auto; margin-top: auto">
          <h2 style="font-family: 'Lato', sans-serif"><strong>SEGMENT
              &nbsp; ${section.name}</strong></h2>
        </div>
        <div class="right col-md-9">
          <div class="row ">
              <#list cars as car>
                <div class="col-xl-4 col-sm-6 " style="margin-top: 10px;">
                    <#if car.modelDto.sectionDto.name == section.name>
                      <div class="jpg">
                          <#if car.modelDto.name == "Corsa">
                            <img class="img" id="img-car" src="img/opel-corsa.jpg">
                          <#elseif car.modelDto.name == "Clio">
                            <img class="img" id="img-car" src="img/renault-clio.jpg">
                          <#elseif car.modelDto.name == "i20">
                            <img class="img" id="img-car" src="img/hyundai-i20.jpg">
                          <#elseif car.modelDto.name == "Fiesta">
                            <img class="img" id="img-car" src="img/ford-fiesta.jpg">
                          <#elseif car.modelDto.name == "Astra">
                            <img class="img" id="img-car" src="img/opel-astra.jpg">
                          <#elseif car.modelDto.name == "Leon">
                            <img class="img" id="img-car" src="img/seat-leon.jpg">
                          <#elseif car.modelDto.name == "i30">
                            <img class="img" id="img-car" src="img/hyundai-i30.jpg">
                          <#elseif car.modelDto.name == "Megane">
                            <img class="img" id="img-car" src="img/renault-megane.jpg">
                          <#elseif car.modelDto.name == "Corolla">
                            <img class="img" id="img-car" src="img/toyota-corolla.jpg">
                          <#elseif car.modelDto.name == "Mondeo">
                            <img class="img" id="img-car" src="img/ford-mondeo.jpg">
                          <#elseif car.modelDto.name == "i40">
                            <img class="img" id="img-car" src="img/hyundai-i40.jpg">
                          <#elseif car.modelDto.name == "Insignia">
                            <img class="img" id="img-car" src="img/opel-insignia.jpg">
                          <#elseif car.modelDto.name == "Talisman">
                            <img class="img" id="img-car" src="img/renault-talisman.png">
                          <#elseif car.modelDto.name == "Tucson">
                            <img class="img" id="img-car" src="img/hyundai-tuscon.jpg">
                          <#elseif car.modelDto.name == "Qashqai">
                            <img class="img" id="img-car" src="img/nissan-qashqai.jpg">
                          <#elseif car.modelDto.name == "5">
                            <img class="img" id="img-car" src="img/bmw-5.jpg">
                          <#elseif car.modelDto.name == "A6">
                            <img class="img" id="img-car" src="img/audi-a6.jpg">
                          <#elseif car.modelDto.name == "ProAce">
                            <img class="img" id="img-car" src="img/toyota-proace.jpg">
                          <#elseif car.modelDto.name == "Alhambra">
                            <img class="img" id="img-car" src="img/seat-alhambra.png">
                          <#elseif car.modelDto.name == "Avensis">
                            <img class="img" id="img-car" src="img/toyota-avensis.jpg">
                          <#else>
                            <img class="img" id="img-car" src="img/BrakZdj.png">
                          </#if>
                      </div>
                      <div style="margin-bottom: auto">
                        <p class="car-signature" style="margin-top: 0px">
                        <h2
                            style="text-align: center;">${car.brandDto.name}  ${car.modelDto.name}</h2>
                        </p>
                      </div>
                    </#if>
                </div>
              </#list>
          </div>
        </div>
      </div>
    </#list>
</div>
<#include "footer.ftlh">