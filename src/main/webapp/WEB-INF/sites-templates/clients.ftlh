<#include "navbar.ftlh">

<div class="container-fluid" style="background-color: #D6D7D7; min-height: 700px">
  <div class="row">
    <h1 style="text-align: center;margin-top: 30px; margin-left: auto; margin-right: auto;">
      Lista użytkowników:
    </h1>
    <div class="table-responsive">
      <table class="table table-dark table-striped table-bordered table-hover table-fixed "
             style="text-align: center; margin-top: 30px">
        <thead>
        <tr style="background-color: #052F09">
          <th scope="col">ID</th>
          <th scope="col">Imię i Nazwisko</th>
          <th scope="col">Adres email</th>
          <th scope="col">Numer telefonu</th>
          <th scope="col">Pesel</th>
          <th scope="col">Typ klienta</th>
          <th scope="col">Wielkość zniżki</th>
          <th scope="col">Zmiana uprawnień</th>
        </tr>
        </thead>
        <tbody>
        <#list clients as client>
        <tr>
          <th scope="row">${client.id}</th>
          <td>${client.fullName}</td>
          <td>${client.email}</td>
          <td>${client.phoneNumber}</td>
          <td>${client.pesel}</td>
          <td>${client.clientTypeDto.type}</td>
          <td>${client.clientTypeDto.discount}</td>
          <td class=" dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" role="button" href="#"
               aria-expanded="false" id="submenu" aria-haspopup="true" style="color: white">Nadaj
              uprawnienia</a>
            <div class="dropdown-menu" aria-labelledby="submenu">
              <button class="dropdown-item btn btn-primary givePermission"
                      data-id-client="${client.id}" data-id-permission="giveManager">Menadżer
              </button>
              <button class="dropdown-item btn btn-primary givePermission"
                      data-id-client="${client.id}" data-id-permission="giveCoordinator">Koordynator
              </button>
              <button class="dropdown-item btn btn-primary givePermission"
                      data-id-client="${client.id}" data-id-permission="giveWorker">Pracownik
              </button>
            </div>
          </td>
            </#list>
      </table>
    </div>
  </div>
</div>
<#include "footer.ftlh">