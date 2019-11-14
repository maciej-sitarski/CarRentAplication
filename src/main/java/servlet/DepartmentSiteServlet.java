package servlet;

import dto.DepartmentDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.DepartmentsService;

@WebServlet("/departments")
public class DepartmentSiteServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  DepartmentsService departmentsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<DepartmentDto> departments = departmentsService.findListOfDepartmentsDto();

    Template template = templateProvider.getTemplate(getServletContext(), "departments-site.ftlh");

    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("departments", departments);

    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
