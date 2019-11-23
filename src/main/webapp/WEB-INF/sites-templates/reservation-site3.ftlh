<#include "navbar.ftlh">

<form class="col-md-5 rounded "
      style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7">
  <header class="card-header">
    <h1 style="text-align: center;"> Wybierz dodatkowe opcje </h1>
  </header>
  <br/>
  <div class="row">
    <div class="col-md-12 ">
        <#list equipments as equipment>
          <div class="row" style="margin-left: 30px;">
            <div class="form-check " style="display: inline-block">
                <#if equipment.equipmentType == "Fotelik dla dziecka (nosidełko 0-9kg)">
                  <input class="form-check-input" type="checkbox" value="" onclick="dynInputBabyCarrier(this);"
                         name="babyCarrier" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="babyCarries">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="babyCarrierCounter"></p>

                <#elseif equipment.equipmentType == "Fotelik dla dziecka (9-36kg)">
                  <input class="form-check-input" type="checkbox" value="" onclick="dynInputSmallSeat(this);"
                         name="smallSeat" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="smallSeat">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="smallSeatCounter"></p>

                <#elseif equipment.equipmentType == "Podkładka(siedzisko) dla dziecka">
                  <input class="form-check-input" type="checkbox" value="" onclick="dynInputSeat(this);"
                         name="seat" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="seat">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="seatCounter"></p>

                <#else>
                  <input class="form-check-input" type="checkbox" value=""
                         id="${equipment.equipmentType}" style="transform: scale(1.5);">
                  <label class="form-check-label" for="${equipment.equipmentType}">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                </#if>
            </div>
          </div>
          <br/>
        </#list>
    </div>
  </div>
</form>


<#include "footer.ftlh">