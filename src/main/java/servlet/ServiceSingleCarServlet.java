package servlet;

import freemarker.TemplateProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServicesService;

@WebServlet("/service-view")
public class ServiceSingleCarServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  ServicesService servicesService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();

  }
}
