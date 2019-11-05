package servlet;

import dao.CarDaoBean;
import dao.DepartmentDaoBean;
import entity.Brand;
import entity.Car;
import entity.Department;
import entity.Model;
import entity.Section;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
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
  TemplateProvider templateProvider;

  @Inject
  DepartmentDaoBean departmentDaoBean;

  @Inject
  CarDaoBean carDaoBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Template template = templateProvider.getTemplate(getServletContext(), "mock.ftlh" );

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

    Section sectionA = new Section();
    sectionA.setName("a");
    sectionA.setPrice(70l);

    Section sectionB = new Section();
    sectionB.setName("b");
    sectionB.setPrice(80l);

    Section sectionC = new Section();
    sectionC.setName("c");
    sectionC.setPrice(100l);

    Section sectionD = new Section();
    sectionD.setName("b");
    sectionD.setPrice(150l);

    Section sectionSuv = new Section();
    sectionSuv.setName("suv");
    sectionSuv.setPrice(199l);

    Section section7os = new Section();
    section7os.setName("7os");
    section7os.setPrice(199l);

    Section sectionBus = new Section();
    sectionBus.setName("bus");
    sectionBus.setPrice(250l);

    Section sectionPremium = new Section();
    sectionPremium.setName("premium");
    sectionPremium.setPrice(300l);



    Brand brand1 = new Brand();
    brand1.setName("Opel");

    Brand brand2 = new Brand();
    brand2.setName("Seat");

    Brand brand3 = new Brand();
    brand3.setName("Toyota");

    Brand brand4 = new Brand();
    brand4.setName("Renault");

    Brand brand5 = new Brand();
    brand5.setName("Hyundai");

    Brand brand6 = new Brand();
    brand6.setName("BMW");

    Brand brand7 = new Brand();
    brand7.setName("Ford");

    Model model1 = new Model();
    model1.setName("Corsa");
    model1.setSection(sectionB);

    Model model2 = new Model();
    model2.setName("Clio");
    model2.setSection(sectionB);

    Model model3 = new Model();
    model3.setName("i20");
    model3.setSection(sectionB);

    Model model4 = new Model();
    model1.setName("fiesta");
    model1.setSection(sectionB);

    Model model = new Model();
    model.setName("Astra");
    model.setSection(sectionC);






    Car car1 = new Car();



    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }
}
