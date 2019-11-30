package servlet;

import dao.ClientDaoBean;
import dao.ClientTypeDaoBean;
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
import service.RegistrationService;


@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ClientDaoBean clientDaoBean;

  @EJB
  RegistrationService registrationService;

  @EJB
  ClientTypeDaoBean clientTypeDaoBean;


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "registration-site.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

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
      Client client = new Client(fullname, email, pesel, number, hashPassword);
      client.setClientType(clientTypeDaoBean.findClientTypeById(1L));
      clientDaoBean.saveClient(client);
    }

    PrintWriter printWriter = resp.getWriter();
    printWriter.println("<script type=\"text/javascript\">");
    printWriter.println(
        "alert('Poprawnie zarejestrowano konto.Zaloguj sie, aby korzystac w pelni z serwisu');");
    printWriter.println("window.location.replace(\"/main\")");
    printWriter.println("</script>");
  }
}
