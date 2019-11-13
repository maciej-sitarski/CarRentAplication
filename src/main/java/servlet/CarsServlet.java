package servlet;

import dto.CarDto;
import dto.SectionDto;
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
import service.SectionService;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  CarService carService;

  @Inject
  SectionService sectionService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Template template = templateProvider.getTemplate(getServletContext(), "cars-site.ftlh");
    PrintWriter printWriter = resp.getWriter();
    List<CarDto> uniqueCarList = carService.uniqueCarsList();
    List<SectionDto> sectionsList = sectionService.sectionList();
    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("cars", uniqueCarList);
    dataModel.put("sections", sectionsList);
    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
