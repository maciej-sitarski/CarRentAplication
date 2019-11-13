package servlet;

import dao.ClientDaoBean;
import dto.ClientDto;
import dto.WorkerDto;
import entity.Client;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import service.ClientService;
import service.RegistrationService;
import service.WorkerService;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ClientService clientService;

  @EJB
  WorkerService workerService;

  @EJB
  RegistrationService registrationService;

  @EJB
  ClientDaoBean clientDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "profile-site.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    Long id = (Long)req.getSession().getAttribute("id");
    dataModel.put("type", position);

    ClientDto client = clientService.findClientDtoById(id);
    dataModel.put("client", client);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String fullname = req.getParameter("fullname");
    String email = req.getParameter("email");
    String pesel = req.getParameter("pesel");
    String password = req.getParameter("password");
    String number = req.getParameter("number");
    String hashPassword = DigestUtils.md5Hex(password);
    if (!registrationService.isClientNumberInDataBase(number) && !registrationService
        .isClientEmailInDataBase(email) && !registrationService.isClientPeselInDataBase(pesel)
        && !registrationService.isWorkerNumberInDataBase(number) && !registrationService
        .isWorkerPeselInDataBase(pesel) && !registrationService.isWorkerEmailInDataBase(email)) {
      Long id = (Long)req.getSession().getAttribute("id");
      Client client = clientService.findClientById(id);
      client.setNameAndSurname(fullname);
      client.setEmail(email);
      client.setPesel(pesel);
      client.setPhoneNumber(number);
      client.setPassword(hashPassword);
      clientDaoBean.updateClient(client);
    }

    PrintWriter printWriter = resp.getWriter();
    printWriter.println("<script type=\"text/javascript\">");
    printWriter.println(
        "alert('Poprawnie zmieniono dane.');");
    printWriter.println("window.location.replace(\"/main\")");
    printWriter.println("</script>");

  }

}
