package servlet;

import dto.ReservationDto;
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
import service.ReservationService;
import service.WorkerService;

@WebServlet("/reservations-workers")
public class ReservationsListWorkerViewServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @EJB
  WorkerService workerService;

  @EJB
  ReservationService reservationService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider
        .getTemplate(getServletContext(), "worker-reservations-view.ftlh");
    Map<String, Object> dataModel = new HashMap<>();
    PrintWriter printWriter = resp.getWriter();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);

    Long workerId = (Long) req.getSession().getAttribute("id");
    WorkerDto workerDto = workerService.findWorkerDtoById(workerId);
    List<ReservationDto> reservationDtoList = reservationService
        .findListOfWorkerReservationsDto(workerId);
    dataModel.put("reservations", reservationDtoList);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
