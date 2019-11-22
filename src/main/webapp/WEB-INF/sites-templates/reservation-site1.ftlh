<#include "navbar.ftlh">

<form action="/reservations"  method="post" id="form-reservation" class="col-md-4 rounded "style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7" >
  <header class="card-header">
    <h1 style="text-align: center;"> Rezerwacje online</h1>
  </header><br/>

  <div class="row">
    <div class="col-md-6 text-center">
      <h5>Miejsce odbioru: </h5>
      <div class=" btn-group">
        <a class="dropdown-toggle btn btn-primary center-block" data-toggle="dropdown" role="button"
           aria-expanded="false" aria-haspopup="true" id="departmentStart" style="color: white">
          <#if city??>
            ${city}
          <#else>
            -miejsce odbioru-
          </#if>
          <span class="caret"></span></a>
        <ul class="dropdown-menu" id="departmentsMenu" role="menu">
            <#list departments as department>
                <li>
                  <a style="color: white" href="#">${department.city}</a>
                </li>
            </#list>
        </ul>
      </div>
    </div>
    <div class="col-md-6 text-center">
      <h5 >Miejsce zwrotu: </h5>
      <div class=" btn-group">
        <a class="dropdown-toggle btn btn-primary center-block" data-toggle="dropdown" role="button" href="#"
           aria-expanded="false" id="departmentFinish" aria-haspopup="true" style="color: white;">-miejsce zwrotu- <span class="caret"></span></a>
        <ul class="dropdown-menu" id="departmentsMenu">
            <#list departments as department>
              <li>
                <a style="color: white" href="#">${department.city}</a>
              </li>
            </#list>
        </ul>
      </div>
    </div>
  </div><br/><br/>
  <div class="row text-center">
    <div class="col-md-6">
      <label>Data odbioru auta: </label>
      <input id="startDate" name="startDate" type="date" class="form-control"  required>
    </div>
    <div class="col-md-6">
      <label>Godzina odbioru auta: </label>
      <input id="startHour" name="startHour" type="time" step="900" class="form-control" required>
    </div>
  </div><br/><br/>
  <div class="row text-center">
    <div class="col-md-6">
      <label>Data zwrotu auta: </label>
      <input id="backDate" name="backDate" type="date" class="form-control"  required>
    </div>
    <div class="col-md-6">
      <label>Godzina zwrotu auta: </label>
      <input id="backHour" name="backHour" type="time" step="900" class="form-control" required>
    </div>
  </div><br/><br/>



  <div class="col-md-6">
    <label>Lokalizacja: </label>
    <input id="departmentStart" name="departmentStart" type="text" class="form-control" required>
  </div>





  <div class="row text-center">
    <div class="col-md-12">
      <#if type != "Guest">
<#--        <button class="btn btn-success" id="firstStepOfReservation" data-id-startDate="startDate" data-id-startHour="startHour" data-id-backDate="backDate" data-id-backHour="backHour" style="margin-bottom: 20px; width:70%;">Dalej </button>-->
        <button class="btn btn-success" type="submit" style="margin-bottom: 20px; width:70%;">Dalej </button>
      <#else>
        <a class="btn btn-primary" href="#" style="margin-bottom: 20px; width:70%;" data-toggle="modal" data-target="#loginModal">Zaloguj się, aby zarezerwować</a>
      </#if>
    </div>
  </div>
</form>
<#include "footer.ftlh">