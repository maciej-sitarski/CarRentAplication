package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ClientService;
import service.WorkerService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @EJB
  ClientService clientService;

  @EJB
  WorkerService workerService;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String email = req.getParameter("email");

    if(clientService.findClientByEmail(email).isPresent()){
      String position = "Client";
      Long id = clientService.findClientDtoByEmail(email).getId();
      req.getSession().setAttribute("type", position);
      req.getSession().setAttribute("id", id);
    }

    else if(workerService.findWorkerByEmail(email).isPresent()){
      String position = workerService.findWorkerByEmail(email).get().getPosition().getName();
      Long id = workerService.findWorkerByEmail(email).get().getId();
      req.getSession().setAttribute("type", position);
      req.getSession().setAttribute("id", id);
    }
  }
}
