<#include "navbar.ftlh">

<form class="col-md-5 rounded " action="/reservations-equipment" method="post"
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
                <#if equipment.equipmentType == "Fotelik dla dziecka (nosidelko 0-9kg)">
                  <input class="form-check-input" type="checkbox" value="${equipment.equipmentType}" onclick="dynInputBabyCarrier(this);"
                         name="${equipment.equipmentType}" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="babyCarries">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="babyCarrierCounter"></p>

                <#elseif equipment.equipmentType == "Fotelik dla dziecka (9-36kg)">
                  <input class="form-check-input" type="checkbox" value="${equipment.equipmentType}" onclick="dynInputSmallSeat(this);"
                         name="${equipment.equipmentType}" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="smallSeat">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="smallSeatCounter"></p>

                <#elseif equipment.equipmentType == "Podkladka(siedzisko) dla dziecka">
                  <input class="form-check-input" type="checkbox" value="${equipment.equipmentType}" onclick="dynInputSeat(this);"
                         name="${equipment.equipmentType}" style="transform: scale(1.5); ">
                  <label style="display: inline-block" class="form-check-label" for="seat">
                      ${equipment.equipmentType}&nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                  <p  id="seatCounter"></p>

                <#else>
                  <input class="form-check-input" type="checkbox" value="${equipment.equipmentType}" name="${equipment.equipmentType}"
                         id="${equipment.equipmentType}" style="transform: scale(1.5);">
                  <label class="form-check-label" for="${equipment.equipmentType}">
                      ${equipment.equipmentType}
                    <#if equipment.equipmentType=="Ubezpieczenie podstawowe">
                        (Nie obejmuje szkody całkowitej i kradzieży)
                    </#if>
                    &nbsp; <small>Cena:${equipment.price} pln/doba</small>
                  </label>
                </#if>
            </div>
          </div>
          <br/>
        </#list>
    </div>
  </div>
  <div class="text-center">
    <button class="btn btn-primary" style=" margin-bottom:20px" onclick="window.history.go(-1); return false;">Powrót do listy samochodów</button>
    <button type="submit"
            class="btn btn-success" style=" margin-bottom:20px">
        Przejdź do podsumowania
    </button>
  </div>
</form>


<#include "footer.ftlh">