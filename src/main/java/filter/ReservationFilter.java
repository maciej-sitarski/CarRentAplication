package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;

@WebFilter(
    filterName = "ReservationFilter",
    urlPatterns = {"/reservations"}
)
public class ReservationFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.POST)) {
      String departmentStart = httpServletRequest.getParameter("departmentStart");
      String startDate = httpServletRequest.getParameter("startDate");
      String startHour = httpServletRequest.getParameter("startHour");
      String backDate = httpServletRequest.getParameter("backDate");
      String backHour = httpServletRequest.getParameter("backHour");

      if (departmentStart.isEmpty()) {
        httpServletResponse.sendError(1, "Wypełnij lokalizację odbioru i spróbuj ponownie");
      } else if (startDate.isEmpty()) {
        httpServletResponse.sendError(1, "Wypełnij datę odbioru i spróbuj ponownie");
      } else if (startHour.isEmpty()) {
        httpServletResponse.sendError(1, "Wypełnij godzinę odbioru i spróbuj ponownie");
      }  else if (backDate.isEmpty()) {
        httpServletResponse.sendError(1, "Wypełnij datę zwrotu i spróbuj ponownie");
      } else if (backHour.isEmpty()) {
        httpServletResponse.sendError(1, "Wypełnij godzinę zwrotu i spróbuj ponownie");
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

  @Override
  public void destroy() {

  }
}
