<#include "navbar.ftlh">

<div class="container-fluid" style=" margin-bottom: 20px">
  <header class="border-bottom border-success"
          style="text-align:center;  width: 90%; margin-left: auto; margin-right: auto;margin-top: 30px; padding-bottom: 20px">
    <h1>
      <strong>Podsumowanie rezerwacji</strong>
    </h1>
  </header>
  <div class="row">
    <div class="col-md-6 border-right border-success">
      <div class="jpg text-center">
          <#if modelName == "Corsa">
            <img class="img" id="img-car-summary" src="img/opel-corsa.jpg">
          <#elseif modelName == "Clio">
            <img class="img" id="img-car-summary" src="img/renault-clio.jpg">
          <#elseif modelName == "i20">
            <img class="img" id="img-car-summary" src="img/hyundai-i20.jpg">
          <#elseif modelName == "Fiesta">
            <img class="img" id="img-car-summary" src="img/ford-fiesta.jpg">
          <#elseif modelName == "Astra">
            <img class="img" id="img-car-summary" src="img/opel-astra.jpg">
          <#elseif modelName == "Leon">
            <img class="img" id="img-car-summary" src="img/seat-leon.jpg">
          <#elseif modelName == "i30">
            <img class="img" id="img-car-summary" src="img/hyundai-i30.jpg">
          <#elseif modelName == "Megane">
            <img class="img" id="img-car-summary" src="img/renault-megane.jpg">
          <#elseif modelName == "Corolla">
            <img class="img" id="img-car-summary" src="img/toyota-corolla.jpg">
          <#elseif modelName == "Mondeo">
            <img class="img" id="img-car-summary" src="img/ford-mondeo.jpg">
          <#elseif modelName == "i40">
            <img class="img" id="img-car-summary" src="img/hyundai-i40.jpg">
          <#elseif modelName == "Insignia">
            <img class="img" id="img-car-summary" src="img/opel-insignia.jpg">
          <#elseif modelName == "Talisman">
            <img class="img" id="img-car-summary" src="img/renault-talisman.png">
          <#elseif modelName == "Tucson">
            <img class="img" id="img-car-summary" src="img/hyundai-tuscon.jpg">
          <#elseif modelName == "Qashqai">
            <img class="img" id="img-car-summary" src="img/nissan-qashqai.jpg">
          <#elseif modelName == "5">
            <img class="img" id="img-car-summary" src="img/bmw-5.jpg">
          <#elseif modelName == "A6">
            <img class="img" id="img-car-summary" src="img/audi-a6.jpg">
          <#elseif modelName == "ProAce">
            <img class="img" id="img-car-summary" src="img/toyota-proace.jpg">
          <#elseif cmodelName == "Alhambra">
            <img class="img" id="img-car-summary" src="img/seat-alhambra.png">
          <#elseif modelName == "Avensis">
            <img class="img" id="img-car-summary" src="img/toyota-avensis.jpg">
          <#else>
            <img class="img" id="img-car-summary" src="img/BrakZdj.png">
          </#if>

      </div>
    </div>
    <div class="col-md-6">
      <h2 style="color: #0088cc; margin-left: 20px; margin-top: 40px">
        Informacje o rezerwacji:
      </h2>
      <ul style="margin-left: 20px ">
        <li>
          Samochód: ${brandName}  ${modelName}
        </li>
        <li>
          Segment: ${sectionName}
        </li>
        <li>
          Od <strong>${startDate} ${startHour}</strong> do
          <strong>${backDate} ${backHour}</strong>
        </li>
        <li>
          Liczba dni: ${period}
        </li>
        <br/>
      </ul>
      <h4 style="color: #0088cc; margin-left: 20px">Wyposażenie dodatkowe:</h4>
      <ul style="margin-left: 20px ">
          <#if babyCarrier??>
            <li>
                ${babyCarrier} Ilość: ${babyCarriesNumbers}
            </li>
          </#if>
          <#if smallSeat??>
            <li>
                ${smallSeat} Ilość: ${smallSeatNumbers}
            </li>
          </#if>
          <#if seat ??>
            <li>
                ${seat} Ilość: ${seatNumbers}
            </li>
          </#if>
          <#if navigation??>
            <li>
                ${navigation}
            </li>
          </#if>
          <#if insuranceBasic??>
            <li>
                ${insuranceBasic}
            </li>
          </#if>
          <#if insuranceFull??>
            <li>
                ${insuranceFull}
            </li>
          </#if>
      </ul>
      <br/>
      <h3 style="color: blue; margin-left: 20px">Cena całkowita: <strong
            style="color: red; font-size: 30px">${finalPrice}</strong> <small>pln</small></h3>
      <button class="btn btn-info"
              style="margin-bottom:20px;margin-top:20px; margin-left: 20px; width: 20%;"
              onclick="goBack();">Powrót
      </button>
      <button id="saveReservation" data-id-startDate="${startDate}" data-id-startHour="${startHour}"
              data-id-backDate="${backDate}" data-id-backHour="${backHour}"
              data-id-modelName="${modelName}" data-id-idClient="${id}"
              data-id-departmentStart="${departmentStart}"
              <#if insuranceFull??>
                data-id-insuranceFull="${insuranceFull}"
                  <#else>
                    data-id-insuranceFull="empty"
              </#if>
              <#if insuranceBasic??>
                data-id-insuranceBasic="${insuranceBasic}"
              <#else>
                data-id-insuranceBasic="empty"
              </#if>
              <#if navigation??>
                data-id-navigation="${navigation}"
              <#else>
                data-id-navigation="empty"
              </#if>
              <#if babyCarrier??>
                data-id-babyCarrier="${babyCarrier}"
              <#else>
                data-id-babyCarrier="empty"
              </#if>
              <#if babyCarriesNumbers??>
                data-id-babyCarriesNumbers="${babyCarriesNumbers}"
              <#else>
                data-id-babyCarriesNumbers="empty"
              </#if>
              <#if smallSeat??>
                data-id-smallSeat="${smallSeat}"
              <#else>
                data-id-smallSeat="empty"
              </#if>
              <#if smallSeatNumbers??>
                data-id-smallSeatNumbers="${smallSeatNumbers}"
              <#else>
                data-id-smallSeatNumbers="empty"
              </#if>
              <#if seat??>
                data-id-seat="${seat}"
              <#else>
                data-id-seat="empty"
              </#if>
              <#if seatNumbers??>
                data-id-seatNumbers="${seatNumbers}"
              <#else>
                data-id-seatNumbers="empty"
              </#if>
              class="btn btn-success"
              style=" margin-bottom:20px;margin-top:20px; margin-left: 20px; width: 20%">
        Zarezerwuj
      </button>
    </div>
  </div>
</div>

<#include "footer.ftlh">