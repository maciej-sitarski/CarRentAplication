package service;

import dao.CarDaoBean;
import entity.Car;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarService {

  @EJB
  CarDaoBean carDaoBean;

  public List<Car> carList(){
    return carDaoBean.findCarsList();
  }

  public List<Object> uniqueCarList(){
    return carDaoBean.findUniqueCarsList();
  }

}
