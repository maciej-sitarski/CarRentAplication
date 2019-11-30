<#include "navbar.ftlh">
<div class="container-fluid" style="background-color: #D6D7D7; min-height: 700px">
  <div class="row">
    <button onclick="carList()"> Powrót do listy </button>
    <h1 style="text-align: center;margin-top: 30px; margin-left: auto; margin-right: auto;">
         <#if car.registrationNumber??> ${car.registrationNumber} </#if> ${car.brandDto.name} ${car.modelDto.name}
    </h1>
    <div class="table-responsive" >
      <table class="table table-dark table-striped table-bordered table-hover table-fixed " style="text-align: center; margin-top: 30px">
        <thead>
        <tr style="background-color: #052F09">
          <th scope="col">Przebieg</th>
          <th scope="col">Naprawy</th>
        </tr>
        </thead>
        <tbody>
        <#if services??>
            <#list services as service>
           <tr>
              <th scope="row">${service.mileage}</th>
              <td>${service.fixes}</td>
           </tr>
            </#list>
        </#if>
        </tbody>
      </table>
    </div>
  </div>
</div>
<#include "footer.ftlh">