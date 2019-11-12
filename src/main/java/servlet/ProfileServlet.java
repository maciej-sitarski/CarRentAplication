package servlet;

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
import service.ClientService;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ClientService clientService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "profile-site.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    Long id = (Long)req.getSession().getAttribute("id");
    dataModel.put("type", position);

    Client client = clientService.findClientById(id);
    dataModel.put("client", client);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

}
