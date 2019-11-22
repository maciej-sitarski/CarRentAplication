package servlet;

import dto.CarDto;
import dto.DepartmentDto;
import dto.SectionDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CarService;
import service.SectionService;

@WebServlet("/reservations-cars")
public class ReservationSecondStepServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  CarService carService;

  @Inject
  SectionService sectionService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "reservation-site2.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();

    String departmentStart = req.getParameter("departmentStart");
    String startDate = req.getParameter("startDate");
    String startHour = req.getParameter("startHour");
    String backDate = req.getParameter("backDate");
    String backHour = req.getParameter("backHour");

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    try {
      List<CarDto> uniqueSpecificCarList = carService.findSpecifyAbilityUniqueCarsList(departmentStart,startDate,backDate,startHour,backHour);
      dataModel.put("cars", uniqueSpecificCarList);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    List<SectionDto> sectionsList = sectionService.sectionList();

    dataModel.put("sections", sectionsList);
    dataModel.put("departmentStart", departmentStart);
    dataModel.put("startDate", startDate);
    dataModel.put("startHour", startHour);
    dataModel.put("backDate", backDate);
    dataModel.put("backHour", backHour);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

}
