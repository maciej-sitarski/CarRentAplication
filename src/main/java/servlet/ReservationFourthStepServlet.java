package servlet;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ReservationService;

@WebServlet("/reservations-summary")
public class ReservationFourthStepServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ReservationService reservationService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "reservation-site4.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    Long id = (Long) req.getSession().getAttribute("id");
    dataModel.put("id", id);

    String departmentStart = (String) req.getSession().getAttribute("departmentStart");
    String startDate = (String) req.getSession().getAttribute("startDate");
    String startHour = (String) req.getSession().getAttribute("startHour");
    String backDate = (String) req.getSession().getAttribute("backDate");
    String backHour = (String) req.getSession().getAttribute("backHour");
    String brandName = (String) req.getSession().getAttribute("brandName");
    String modelName = (String) req.getSession().getAttribute("modelName");
    String babyCarrier = (String) req.getSession().getAttribute("equipment1");
    String smallSeat = (String) req.getSession().getAttribute("equipment2");
    String seat = (String) req.getSession().getAttribute("equipment3");
    String navigation = (String) req.getSession().getAttribute("equipment4");
    String insuranceBasic = (String) req.getSession().getAttribute("equipment5");
    String insuranceFull = (String) req.getSession().getAttribute("equipment6");
    String sectionName = (String) req.getSession().getAttribute("sectionName");
    String sectionPrice = (String) req.getSession().getAttribute("sectionPrice");

    String babyCarriesNumbers = (String) req.getSession().getAttribute("babyCarriesNumbers");
    String smallSeatNumbers = (String) req.getSession().getAttribute("smallSeatNumbers");
    String seatNumbers = (String) req.getSession().getAttribute("seatNumbers");

    try {
      Long period = reservationService.countingNumberOfDayOfReservation(startDate, backDate);
      dataModel.put("period", period);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      Long finalPrice = reservationService
          .countingPriceOfReservation(startDate, backDate, sectionPrice, babyCarrier, smallSeat,
              seat,
              navigation, insuranceBasic, insuranceFull, babyCarriesNumbers, smallSeatNumbers,
              seatNumbers);
      dataModel.put("finalPrice", finalPrice);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    dataModel.put("modelName", modelName);
    dataModel.put("departmentStart", departmentStart);
    dataModel.put("startDate", startDate);
    dataModel.put("startHour", startHour);
    dataModel.put("backDate", backDate);
    dataModel.put("backHour", backHour);
    dataModel.put("brandName", brandName);
    dataModel.put("babyCarrier", babyCarrier);
    dataModel.put("smallSeat", smallSeat);
    dataModel.put("seat", seat);
    dataModel.put("navigation", navigation);
    dataModel.put("insuranceBasic", insuranceBasic);
    dataModel.put("insuranceFull", insuranceFull);
    dataModel.put("babyCarriesNumbers", babyCarriesNumbers);
    dataModel.put("smallSeatNumbers", smallSeatNumbers);
    dataModel.put("seatNumbers", seatNumbers);
    dataModel.put("sectionName", sectionName);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
