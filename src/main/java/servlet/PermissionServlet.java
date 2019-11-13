package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/permission")
public class PermissionServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String permission = req.getParameter("email");

//    if(clientService.findClientByEmail(email).isPresent()){
//      String position = "Client";
//      Long id = clientService.findClientDtoByEmail(email).getId();
//      req.getSession().setAttribute("type", position);
//      req.getSession().setAttribute("id", id);
//    }

  }
}
