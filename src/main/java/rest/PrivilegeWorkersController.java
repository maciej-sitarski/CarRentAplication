package rest;

import dao.DepartmentDaoBean;
import dao.PositionDaoBean;
import dao.WorkerDaoBean;
import entity.Client;
import entity.Worker;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import service.WorkerService;

@Path("/workers")
public class PrivilegeWorkersController {

  @EJB
  WorkerService workerService;

  @EJB
  WorkerDaoBean workerDaoBean;

  @EJB
  DepartmentDaoBean departmentDaoBean;

  @EJB
  PositionDaoBean positionDaoBean;

  @PATCH
  @Path("/departments/{department}/{id}")
  public Response giveWorkerDepartment(@PathParam("id") String idParam, @PathParam("department") String department) {
    Long id = Long.valueOf(idParam);
    Worker worker = workerDaoBean.findWorkerById(id);

    switch (department) {
      case "Gdansk":
        worker.setDepartment(departmentDaoBean.findGdanskDepartment());
        break;
      case "Warszawa":
        worker.setDepartment(departmentDaoBean.findWarszawaDepartment());
        break;
      case "Lodz":
        worker.setDepartment(departmentDaoBean.findLodzDepartment());
        break;
      case "Krakow":
        worker.setDepartment(departmentDaoBean.findKrakowDepartment());
        break;
      case "Wroclaw":
        worker.setDepartment(departmentDaoBean.findWroclawDepartment());
        break;
      case "Szczecin":
        worker.setDepartment(departmentDaoBean.findSzczecinDepartment());
        break;
      case "Lublin":
        worker.setDepartment(departmentDaoBean.findLublinDepartment());
        break;
      case "Poznan":
        worker.setDepartment(departmentDaoBean.findPoznanDepartment());
        break;
    }
    workerDaoBean.updateWorker(worker);
    return Response.ok().build();
  }
  @PATCH
  @Path("/permission/{permission}/{id}")
  public Response giveWorkerPermission(@PathParam("id") String idParam, @PathParam("permission") String permission) {
    Long id = Long.valueOf(idParam);
    Worker worker = workerDaoBean.findWorkerById(id);

    switch (permission) {
      case "giveMenager":
        worker.setPosition(positionDaoBean.findMenagerPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "giveCoordinator":
        worker.setPosition(positionDaoBean.findCoordinatorPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "giveWorker":
        worker.setPosition(positionDaoBean.findWorkerPosition());
        workerDaoBean.updateWorker(worker);
        break;
      case "delete":
        workerDaoBean.deleteWorker(id);
        break;
    }
    return Response.ok().build();
  }
}
