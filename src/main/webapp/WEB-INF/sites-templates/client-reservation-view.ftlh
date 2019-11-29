<#include "navbar.ftlh">


<div class="container-fluid" style=" margin-bottom: 20px">
  <header class="border-bottom border-success"
          style="text-align:center;  width: 90%; margin-left: auto; margin-right: auto;margin-top: 30px; padding-bottom: 20px">
    <h1>
      <strong>Szczegóły rezerwacji</strong>
    </h1>
  </header>
  <div class="row">
    <div class="col-md-6 border-right border-success">
      <div class="jpg text-center">
          <#if reservation.carDto.modelDto.name == "Corsa">
            <img class="img" id="img-car-summary" src="img/opel-corsa.jpg">
          <#elseif reservation.carDto.modelDto.name == "Clio">
            <img class="img" id="img-car-summary" src="img/renault-clio.jpg">
          <#elseif reservation.carDto.modelDto.name == "i20">
            <img class="img" id="img-car-summary" src="img/hyundai-i20.jpg">
          <#elseif reservation.carDto.modelDto.name == "Fiesta">
            <img class="img" id="img-car-summary" src="img/ford-fiesta.jpg">
          <#elseif reservation.carDto.modelDto.name == "Astra">
            <img class="img" id="img-car-summary" src="img/opel-astra.jpg">
          <#elseif reservation.carDto.modelDto.name == "Leon">
            <img class="img" id="img-car-summary" src="img/seat-leon.jpg">
          <#elseif reservation.carDto.modelDto.name == "i30">
            <img class="img" id="img-car-summary" src="img/hyundai-i30.jpg">
          <#elseif reservation.carDto.modelDto.name == "Megane">
            <img class="img" id="img-car-summary" src="img/renault-megane.jpg">
          <#elseif reservation.carDto.modelDto.name == "Corolla">
            <img class="img" id="img-car-summary" src="img/toyota-corolla.jpg">
          <#elseif reservation.carDto.modelDto.name == "Mondeo">
            <img class="img" id="img-car-summary" src="img/ford-mondeo.jpg">
          <#elseif reservation.carDto.modelDto.name == "i40">
            <img class="img" id="img-car-summary" src="img/hyundai-i40.jpg">
          <#elseif reservation.carDto.modelDto.name == "Insignia">
            <img class="img" id="img-car-summary" src="img/opel-insignia.jpg">
          <#elseif reservation.carDto.modelDto.name == "Talisman">
            <img class="img" id="img-car-summary" src="img/renault-talisman.png">
          <#elseif reservation.carDto.modelDto.name == "Tucson">
            <img class="img" id="img-car-summary" src="img/hyundai-tuscon.jpg">
          <#elseif reservation.carDto.modelDto.name == "Qashqai">
            <img class="img" id="img-car-summary" src="img/nissan-qashqai.jpg">
          <#elseif reservation.carDto.modelDto.name == "5">
            <img class="img" id="img-car-summary" src="img/bmw-5.jpg">
          <#elseif reservation.carDto.modelDto.name == "A6">
            <img class="img" id="img-car-summary" src="img/audi-a6.jpg">
          <#elseif reservation.carDto.modelDto.name == "ProAce">
            <img class="img" id="img-car-summary" src="img/toyota-proace.jpg">
          <#elseif reservation.carDto.modelDto.name == "Alhambra">
            <img class="img" id="img-car-summary" src="img/seat-alhambra.png">
          <#elseif reservation.carDto.modelDto.name == "Avensis">
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
          Samochód: <strong>${reservation.carDto.brandDto.name}  ${reservation.carDto.modelDto.name}</strong>
        </li>
        <li>
          Segment: <strong>${reservation.carDto.modelDto.sectionDto.name}</strong>
        </li>
        <li>
          Od <strong>${reservation.startDate} ${reservation.startHour}</strong> do
          <strong>${reservation.endDate} ${reservation.endHour}</strong>
        </li>
        <li>
          Liczba dni: <strong>${period}</strong>
        </li>
        <br/>
      </ul>
      <h4 style="color: #0088cc; margin-left: 20px">Wyposażenie dodatkowe:</h4>
      <ul style="margin-left: 20px ">
        <#list reservationEquipments as reservationEquipment>
            <#if reservationEquipment.equipmentDto.equipmentType == "Fotelik dla dziecka (nosidelko 0-9kg)" || reservationEquipment.equipmentDto.equipmentType == "Fotelik dla dziecka (9-36kg)" || reservationEquipment.equipmentDto.equipmentType == "Podkladka(siedzisko) dla dziecka" >
              <li>
                  ${reservationEquipment.equipmentDto.equipmentType} Ilość: ${reservationEquipment.number}
              </li>
            <#else>
              <li>
                  ${reservationEquipment.equipmentDto.equipmentType}
              </li>

            </#if>
            </#list>
      </ul>
      <br/>
      <h3 style="color: blue; margin-left: 20px">Cena całkowita: <strong
            style="color: red; font-size: 30px">${reservation.price}</strong> <small>pln</small></h3>
      <button class="btn btn-info"
              style="margin-bottom:20px;margin-top:20px; margin-left: 20px; width: 20%;"
              onclick="goBack();">Powrót
      </button>
      <button id="deleteReservation" data-id-reservation="${reservationId}"
              class="btn btn-danger"
              style=" margin-bottom:20px;margin-top:20px; margin-left: 20px; width: 30%">
        Usuń rezerwację
      </button>
    </div>
  </div>
</div>

<#include "footer.ftlh">