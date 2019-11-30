<#include "navbar.ftlh">
<div class="container-fluid" style="background-color: #D6D7D7; min-height: 700px">
  <div class="row">
    <h1 style="text-align: center;margin-top: 30px; margin-left: auto; margin-right: auto;">
      Twoje rezerwacje:
    </h1>
    <div class="table-responsive">
      <table class="table table-dark table-striped table-bordered table-hover table-fixed "
             style="text-align: center; margin-top: 30px">
        <thead>
        <tr style="background-color: #052F09">
          <th scope="col">Id rezerwacji</th>
          <th scope="col">Samochód</th>
          <th scope="col">Segment</th>
          <th scope="col">Data odbioru</th>
          <th scope="col">Godzina odbioru</th>
          <th scope="col">Data zwrotu</th>
          <th scope="col">Godzina zwrotu</th>
          <th scope="col">Miejsce odbioru i zwrotu</th>
          <th scope="col">Szczegóły</th>
        </tr>
        </thead>
        <tbody>
        <#list reservations as reservation>
        <tr>
          <td>${reservation.id} </td>
          <td>${reservation.carDto.brandDto.name} ${reservation.carDto.modelDto.name}</td>
          <td>${reservation.carDto.modelDto.sectionDto.name}</td>
          <td>${reservation.startDate} </td>
          <td>${reservation.startHour}</td>
          <td>${reservation.endDate}</td>
          <td>${reservation.endHour}</td>
          <td>${reservation.carDto.departmentDto.city} </td>
          <td><a id="details-button" type="button"
                 href="/client-reservation-view?reservationId=${reservation.id}">Pokaż szczegóły</a>
          </td>
            </#list>
      </table>
    </div>
  </div>
</div>
<#include "footer.ftlh">