package servlet;

import dao.DepartmentDaoBean;
import entity.Department;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mock")
public class MockServlet  extends HttpServlet {


  @Inject
  DepartmentDaoBean departmentDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {


    Map<String, String> dataModel = new HashMap<>();

    PrintWriter printWriter = resp.getWriter();

    Department department1 = new Department();
    department1.setCity("Kraków");

    Department department2 = new Department();
    department2.setCity("Warszawa");

    Department department3 = new Department();
    department3.setCity("Gdańsk");

    Department department4 = new Department();
    department4.setCity("Poznań");

    Department department5 = new Department();
    department5.setCity("Wrocław");

    Department department6 = new Department();
    department6.setCity("Łódź");

    Department department7 = new Department();
    department7.setCity("Lublin");

    Department department8 = new Department();
    department8.setCity("Szczecin");

    departmentDaoBean.saveBrand(department1);
    departmentDaoBean.saveBrand(department2);
    departmentDaoBean.saveBrand(department3);
    departmentDaoBean.saveBrand(department4);
    departmentDaoBean.saveBrand(department5);
    departmentDaoBean.saveBrand(department6);
    departmentDaoBean.saveBrand(department7);
    departmentDaoBean.saveBrand(department8);
  }
}
