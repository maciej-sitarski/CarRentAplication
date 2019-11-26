package servlet;

import dto.CarDto;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/services")
public class ServicesSelectCarServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  CarService carService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();

    Template template = templateProvider.getTemplate(getServletContext(),"services-select-car.ftlh");

    Map<String,Object> dataModel = new HashMap<>();

    List<CarDto> carsList = carService.carList();

    String position = (String) req.getSession().getAttribute("type");
    dataModel.put("type", position);
    dataModel.put("cars", carsList);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }

  }
}
