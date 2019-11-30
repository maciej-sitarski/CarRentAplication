package servlet;

import dto.DepartmentDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

@WebServlet("/reservations")
public class ReservationFirstStepServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  DepartmentsService departmentsService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "reservation-site1.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();
    String city = req.getParameter("city");
    if (city != null) {
      dataModel.put("city", city);
    }

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    List<DepartmentDto> departments = departmentsService.findListOfDepartmentsDto();
    dataModel.put("departments", departments);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String departmentStart = req.getParameter("departmentStart");
    String startDate = req.getParameter("startDate");
    String startHour = req.getParameter("startHour");
    String backDate = req.getParameter("backDate");
    String backHour = req.getParameter("backHour");

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat hourFormat = new SimpleDateFormat("hh:mm");
    LocalDate todayLocalDate = LocalDate.now();
    Date today = java.sql.Date.valueOf(todayLocalDate);

    try {
      Date startFormatDate = dateFormat.parse(startDate);
      Date finishFormatDate = dateFormat.parse(backDate);
      Date startFormatHour = hourFormat.parse(startHour);
      Date finishFormatHour = hourFormat.parse(backHour);
      if (startFormatDate.compareTo(finishFormatDate) > 0) {
        resp.sendError(1, "Podano niepoprawny termin wynajmu. Spróbuj ponownie.");
      } else if (startFormatDate.compareTo(finishFormatDate) == 0
          && startFormatHour.compareTo(finishFormatHour) > 0) {
        resp.sendError(1, "Podano niepoprawny termin wynajmu. Spróbuj ponownie.");
      } else if (startFormatDate.compareTo(today) < 0 || startFormatDate.compareTo(today) == 0) {
        resp.sendError(1, "Podano niepoprawny termin wynajmu. Spróbuj ponownie.");
      } else {
        resp.sendRedirect(
            "/reservations-cars?startDate=" + startDate + "&startHour=" + startHour + "&backDate="
                + backDate + "&backHour=" + backHour + "&departmentStart=" + departmentStart);
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
