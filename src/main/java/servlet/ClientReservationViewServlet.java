package servlet;

import dto.ReservationDto;
import dto.ReservationEquipmentDto;
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
import service.ReservationEquipmentService;
import service.ReservationService;

@WebServlet("/client-reservation-view")
public class ClientReservationViewServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ReservationService reservationService;

  @EJB
  ReservationEquipmentService reservationEquipmentService;


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(), "client-reservation-view.ftlh");
    PrintWriter printWriter = resp.getWriter();
    Map<String, Object> dataModel = new HashMap<>();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    Long reservationId = Long.valueOf(req.getParameter("reservationId"));
    ReservationDto reservationDto = reservationService.findReservationDtoById(reservationId);
    dataModel.put("reservation", reservationDto);
    dataModel.put("reservationId", reservationId);

    List<ReservationEquipmentDto> reservationEquipmentDtoList = reservationEquipmentService.findReservationEquipmentDtoListByReservationId(reservationId);
    dataModel.put("reservationEquipments", reservationEquipmentDtoList);

    try {
      Long period = reservationService.countingNumberOfDayOfReservation(reservationDto.getStartDate(), reservationDto.getEndDate());
      dataModel.put("period", period);
    } catch (ParseException e) {
      e.printStackTrace();
    }


    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

}
