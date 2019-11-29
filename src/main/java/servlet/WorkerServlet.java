package servlet;

import dto.DepartmentDto;
import dto.WorkerDto;
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
import service.WorkerService;

@WebServlet("/workers")
public class WorkerServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  WorkerService workerService;

  @EJB
  DepartmentsService departmentsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "workers.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    List<WorkerDto> workers = workerService.findAllWorkersDto();
    dataModel.put("workers", workers);

    List<DepartmentDto> departments = departmentsService.findListOfDepartmentsDto();
    dataModel.put("departments", departments);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
