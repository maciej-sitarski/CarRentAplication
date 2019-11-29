package servlet;

import dto.CarDto;
import dto.ReservationDto;
import dto.SectionDto;
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
import service.ReservationService;

@WebServlet("/client-reservations")
public class ClientReservationsServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  ReservationService reservationService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(), "client-reservations.ftlh");
    PrintWriter printWriter = resp.getWriter();
    Map<String, Object> dataModel = new HashMap<>();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    Long id = (Long)req.getSession().getAttribute("id");

    List<ReservationDto> reservationsDto = reservationService.findAllClientReservationDto(id);
    dataModel.put("reservations", reservationsDto);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

}
