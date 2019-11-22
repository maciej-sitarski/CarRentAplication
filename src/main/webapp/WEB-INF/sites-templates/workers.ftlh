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
          <th scope="col">Oddział</th>
          <th scope="col">Oddział</th>
          <th scope="col">Zmień Oddział</th>
          <th scope="col">Zmień Stanowisko</th>
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
             <td>${worker.departmentDto.city}</td>
              <td>${worker.positionDto.name}</td>
               <#if worker.positionDto.name != "Admin">
                 <td class=" dropdown">
                   <a class="dropdown-toggle" data-toggle="dropdown" role="button" href="#"
                      aria-expanded="false" id="submenuDepartments" aria-haspopup="true" style="color: white">Zmień oddział</a>
                   <div class="dropdown-menu" aria-labelledby="submenuDepartments">
                     <#list departments as department>
                       <button class="dropdown-item btn btn-primary giveDepartments" data-id-worker="${worker.id}" data-id-department="${department.city}">${department.city}</button>
                     </#list>
                   </div>
                 </td>
               <#else>
                 <td>Warszawa</td>
               </#if>
             <#if worker.positionDto.name != "Admin">
               <td class=" dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" role="button" href="#"
                    aria-expanded="false" id="submenuPermission" aria-haspopup="true" style="color: white">Zmień stanowisko</a>
                 <div class="dropdown-menu" aria-labelledby="submenuPermission">
                   <button class="dropdown-item btn btn-primary givePermissionWorker" data-id-worker="${worker.id}" data-id-permission="Menadżer" >Menadżer</button>
                   <button class="dropdown-item btn btn-primary givePermissionWorker" data-id-worker="${worker.id}" data-id-permission="Koordynator" >Koordynator</button>
                   <button class="dropdown-item btn btn-primary givePermissionWorker"  data-id-worker="${worker.id}" data-id-permission="Pracownik">Pracownik</button>
                   <button class="dropdown-item btn btn-primary givePermissionWorker" data-id-worker="${worker.id}" data-id-permission="delete">Usuń pracownika</button>
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