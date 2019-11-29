package filter;

import java.io.IOException;
import javax.ejb.EJB;
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
import org.apache.commons.codec.digest.DigestUtils;
import service.LoginService;

@WebFilter(
    filterName = "LoginFilter",
    urlPatterns = {"/login"}
)
public class LoginFilter implements Filter {

  @EJB
  LoginService loginService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    if (httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.POST)) {
      String email = httpServletRequest.getParameter("email");
      String password = httpServletRequest.getParameter("password");
      String hashPassword = DigestUtils.md5Hex(password);
      if (!loginService.isClientInDataBase(email, hashPassword) && !loginService
          .isWorkerInDataBase(email, hashPassword)) {
        httpServletResponse
            .sendError(1, "Aby się zalogować, najpierw załóż konto.");
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }

  @Override
  public void destroy() {
  }
}
