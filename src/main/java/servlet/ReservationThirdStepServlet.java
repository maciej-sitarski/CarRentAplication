package servlet;

import dto.CarDto;
import dto.EquipmentDto;
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
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.EquipmentService;

@WebServlet("/reservations-equipment")
public class ReservationThirdStepServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  EquipmentService equipmentService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "reservation-site3.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();

    String departmentStart = req.getParameter("departmentStart");
    String startDate = req.getParameter("startDate");
    String startHour = req.getParameter("startHour");
    String backDate = req.getParameter("backDate");
    String backHour = req.getParameter("backHour");
    String brandName = req.getParameter("brandName");
    String modelName = req.getParameter("modelName");
    String sectionName = req.getParameter("sectionName");
    String sectionPrice = req.getParameter("sectionPrice");

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    List<EquipmentDto> equipments = equipmentService.findAllEquipmentsDto();
    dataModel.put("equipments", equipments);

    req.getSession().setAttribute("departmentStart", departmentStart);
    req.getSession().setAttribute("startDate", startDate);
    req.getSession().setAttribute("startHour", startHour);
    req.getSession().setAttribute("backDate", backDate);
    req.getSession().setAttribute("backHour", backHour);
    req.getSession().setAttribute("brandName", brandName);
    req.getSession().setAttribute("modelName", modelName);
    req.getSession().setAttribute("sectionName", sectionName);
    req.getSession().setAttribute("sectionPrice", sectionPrice);


    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String equipment1 = req.getParameter("Fotelik dla dziecka (nosidelko 0-9kg)");
    String equipment2 = req.getParameter("Fotelik dla dziecka (9-36kg)");
    String equipment3 = req.getParameter("Podkladka(siedzisko) dla dziecka");
    String equipment4 = req.getParameter("Nawigacja GPS");
    String equipment5 = req.getParameter("Ubezpieczenie podstawowe");
    String equipment6 = req.getParameter("Ubezpieczenie pelne");

    req.getSession().setAttribute("equipment1", equipment1);
    req.getSession().setAttribute("equipment2", equipment2);
    req.getSession().setAttribute("equipment3", equipment3);
    req.getSession().setAttribute("equipment4", equipment4);
    req.getSession().setAttribute("equipment5", equipment5);
    req.getSession().setAttribute("equipment6", equipment6);

    String babyCarriesNumbers = req.getParameter("babyCarriesNumbers");
    String smallSeatNumbers = req.getParameter("smallSeatNumbers");
    String seatNumbers = req.getParameter("seatNumbers");

    req.getSession().setAttribute("babyCarriesNumbers", babyCarriesNumbers);
    req.getSession().setAttribute("smallSeatNumbers", smallSeatNumbers);
    req.getSession().setAttribute("seatNumbers", seatNumbers);


    resp.sendRedirect(
        "/reservations-summary");
  }
}
