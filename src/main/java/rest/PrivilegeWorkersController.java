package rest;

import dao.DepartmentDaoBean;
import dao.PositionDaoBean;
import dao.ReservationDaoBean;
import dao.WorkerDaoBean;
import entity.Department;
import entity.Reservation;
import entity.Worker;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/workers")
public class PrivilegeWorkersController {

  @EJB
  WorkerDaoBean workerDaoBean;

  @EJB
  DepartmentDaoBean departmentDaoBean;

  @EJB
  PositionDaoBean positionDaoBean;

  @EJB
  ReservationDaoBean reservationDaoBean;

  @PATCH
  @Path("/departments/{department}/{id}")
  public Response giveWorkerDepartment(@PathParam("id") String idParam,
      @PathParam("department") String department) {
    Long id = Long.valueOf(idParam);
    Worker worker = workerDaoBean.findWorkerById(id);
    List<Department> departments = departmentDaoBean.findAllDepartments();
    worker.setDepartment(
        departments.stream().filter(department1 -> department1.getCity().equals(department))
            .findFirst().get());
    workerDaoBean.updateWorker(worker);
    return Response.ok().build();
  }

  @PATCH
  @Path("/permission/{permission}/{id}")
  public Response giveWorkerPermission(@PathParam("id") Long idParam,
      @PathParam("permission") String permission) {

    Worker worker = workerDaoBean.findWorkerById(idParam);
    switch (permission) {
      case "Menadżer":
        worker.setPosition(positionDaoBean.findMenagerPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "Koordynator":
        worker.setPosition(positionDaoBean.findCoordinatorPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "Pracownik":
        worker.setPosition(positionDaoBean.findWorkerPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "delete":
        workerDaoBean.deleteWorker(idParam);
        break;
    }
    return Response.ok().build();
  }

  @PATCH
  @Path("/assign/{workerId}/{reservationId}")
  public Response giveWorkerDepartment(@PathParam("workerId") Long workerId,
      @PathParam("reservationId") Long reservationId) {
    Worker worker = workerDaoBean.findWorkerById(workerId);
    Reservation reservation = reservationDaoBean.findReservationById(reservationId);
    reservation.setWorker(worker);
    reservationDaoBean.updateReservation(reservation);

    return Response.ok().build();
  }
}
