package rest;

import dao.ClientDaoBean;
import dao.WorkerDaoBean;
import entity.Client;
import entity.Worker;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import service.ClientService;
import service.PositionService;

@Path("/clients")
public class PrivilegeClientsController {

  @EJB
  ClientService clientService;

  @EJB
  PositionService positionService;

  @EJB
  WorkerDaoBean workerDaoBean;

  @EJB
  ClientDaoBean clientDaoBean;

  @PATCH
  @Path("/giveWorker/{id}")
  public Response giveWorkerPermissions(@PathParam("id") String idParam) {
    Long id = Long.valueOf(idParam);

    Client client = clientService.findClientById(id);
    Worker worker = new Worker();
    worker.setFullName(client.getNameAndSurname());
    worker.setPesel(client.getPesel());
    worker.setPhoneNumber(client.getPhoneNumber());
    worker.setPassword(client.getPassword());
    worker.setEmail(client.getEmail());
    worker.setPosition(positionService.findWorkerPosition());
    workerDaoBean.saveWorker(worker);
    clientDaoBean.deleteClient(client);

    return Response.ok().build();
  }

  @PATCH
  @Path("/giveMenager/{id}")
  public Response giveMenagerPermissions(@PathParam("id") String idParam) {
    Long id = Long.valueOf(idParam);

    Client client = clientService.findClientById(id);
    Worker worker = new Worker();
    worker.setFullName(client.getNameAndSurname());
    worker.setPesel(client.getPesel());
    worker.setPhoneNumber(client.getPhoneNumber());
    worker.setPassword(client.getPassword());
    worker.setEmail(client.getEmail());
    worker.setPosition(positionService.findMenagerPosition());
    workerDaoBean.saveWorker(worker);
    clientDaoBean.deleteClient(client);

    return Response.ok().build();
  }

  @PATCH
  @Path("/giveCoordinator/{id}")
  public Response giveCoordinatorPermissions(@PathParam("id") String idParam) {
    Long id = Long.valueOf(idParam);

    Client client = clientService.findClientById(id);
    Worker worker = new Worker();
    worker.setFullName(client.getNameAndSurname());
    worker.setPesel(client.getPesel());
    worker.setPhoneNumber(client.getPhoneNumber());
    worker.setPassword(client.getPassword());
    worker.setEmail(client.getEmail());
    worker.setPosition(positionService.findCoordinatorPosition());
    workerDaoBean.saveWorker(worker);
    clientDaoBean.deleteClient(client);

    return Response.ok().build();
  }
}
