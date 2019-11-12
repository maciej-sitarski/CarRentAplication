package filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.RegistrationService;

@WebFilter(
    filterName = "RegistrationFilter",
    urlPatterns = {"/registration"}
)
public class RegistrationFilter implements Filter {

  @EJB
  RegistrationService registrationService;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.POST)) {
      String fullname = httpServletRequest.getParameter("fullname");
      String email = httpServletRequest.getParameter("email");
      String pesel = httpServletRequest.getParameter("pesel");
      String password = httpServletRequest.getParameter("password");
      String number = httpServletRequest.getParameter("number");
      if (fullname.isEmpty()) {
        httpServletResponse.sendError(1, "Okno imię i nazwisko nie zostało uzupełnione. Spróbuj ponownie");
      }
      if (email.isEmpty()) {
        httpServletResponse.sendError(2, "Okno email nie zostało uzupełnione.  Spróbuj ponownie");
      }
      if (pesel.isEmpty()) {
        httpServletResponse.sendError(3, "Okno pesel nie zostało uzupełnione.  Spróbuj ponownie");
      }
      if (password.isEmpty()) {
        httpServletResponse.sendError(4, "Okno hasło nie zostało uzupełnione.  Spróbuj ponownie");
      }
      if (number.isEmpty()) {
        httpServletResponse.sendError(5, "Okno numer nie zostało uzupełnione.  Spróbuj ponownie");
      }
      if (registrationService.isClientEmailInDataBase(email)) {
        httpServletResponse.sendError(6, "Adres email jest już zajęty. Spróbuj ponownie");
      }
      if (registrationService.isClientPeselInDataBase(pesel)) {
        httpServletResponse.sendError(7, "Pesel jest już zajety. Sprobuj ponownie");
      }
      if (registrationService.isClientNumberInDataBase(number)) {
        httpServletResponse.sendError(8, "Numer telefonu jest już zajety. Sprobuj ponownie");
      }
      if (registrationService.isWorkerEmailInDataBase(email)) {
        httpServletResponse.sendError(6, "Adres email jest już zajęty. Spróbuj ponownie");
      }
      if (registrationService.isWorkerPeselInDataBase(pesel)) {
        httpServletResponse.sendError(7, "Pesel jest już zajety. Sprobuj ponownie");
      }
      if (registrationService.isWorkerNumberInDataBase(number)) {
        httpServletResponse.sendError(8, "Numer telefonu jest już zajety. Sprobuj ponownie");
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
