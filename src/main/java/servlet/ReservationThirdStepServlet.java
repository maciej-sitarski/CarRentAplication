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

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    List<EquipmentDto> equipments = equipmentService.findAllEquipmentsDto();
    dataModel.put("equipments", equipments);

//    try {
//      List<CarDto> uniqueSpecificCarList = carService.findSpecifyAbilityUniqueCarsList(departmentStart,startDate,backDate,startHour,backHour);
//      dataModel.put("cars", uniqueSpecificCarList);
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    List<SectionDto> sectionsList = sectionService.sectionList();
//
    dataModel.put("departmentStart", departmentStart);
    dataModel.put("startDate", startDate);
    dataModel.put("startHour", startHour);
    dataModel.put("backDate", backDate);
    dataModel.put("backHour", backHour);
    dataModel.put("brandName", brandName);
    dataModel.put("modelName", modelName);


    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

}
