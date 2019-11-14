<#include "navbar.ftlh">

<div class="container-fluid" style="background-color: #D6D7D7; min-height: 700px">
  <div class="row">
    <h1 style="text-align: center;margin-top: 30px; margin-left: auto; margin-right: auto;">
      Lista pracowników:
    </h1>
    <div class="table-responsive" >
      <table class="table table-dark table-striped table-bordered table-hover table-fixed " style="text-align: center; margin-top: 30px">
        <thead>
        <tr style="background-color: #052F09">
          <th scope="col">ID</th>
          <th scope="col">Imię i Nazwisko</th>
          <th scope="col">Adres email</th>
          <th scope="col">Numer telefonu</th>
          <th scope="col">Pesel</th>
          <th scope="col">Stanowisko</th>
          <th scope="col">Oddział</th>
          <th scope="col">Zmiana uprawnień</th>
        </tr>
        </thead>
        <tbody>
        <#list workers as worker>
           <tr>
              <th scope="row">${worker.id}</th>
              <td>${worker.nameAndSurname}</td>
              <td>${worker.email}</td>
              <td>${worker.phoneNumber}</td>
              <td>${worker.pesel}</td>
              <td>${worker.positionDto.name}</td>
              <td>${worker.departmentDto.city}</td>
             <#if worker.positionDto.name != "Admin">
               <td class=" dropdown">
                 <a class="dropdown-toggler" data-toggle="dropdown" role="button" href="#"
                    aria-expanded="false" id="submenu" aria-haspopup="true" style="color: white">Zmień uprawnienia</a>
                 <div class="dropdown-menu" aria-labelledby="submenu">
                   <button class="dropdown-item btn btn-primary" id="">Menadżer</button>
                   <button class="dropdown-item btn btn-primary" id="">Koordynator</button>
                   <button class="dropdown-item btn btn-primary" id="">Pracownik</button>
                   <button class="dropdown-item btn btn-primary" id="">Usuń pracownika</button>
                 </div>
               </td>
             <#else>
               <td>Administrator</td>
             </#if>
          </#list>
      </table>


    </div>
  </div>
</div>

<#include "footer.ftlh">