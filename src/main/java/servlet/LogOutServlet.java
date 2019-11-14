package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log-out")
public class LogOutServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getSession().setAttribute("type", "Guest");
    PrintWriter printWriter = resp.getWriter();
    printWriter.println("<script type=\"text/javascript\">");
    printWriter.println("window.location.replace(\"/main\")");
    printWriter.println("</script>");
  }
}
