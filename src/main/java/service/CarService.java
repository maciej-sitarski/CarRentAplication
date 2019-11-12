package service;

import dao.CarDaoBean;
import entity.Car;
import java.util.ArrayList;
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

  public List<Car> uniqueCarList(){
    List<Car> carList = carList();
    return carList;
  }

  public List<Car> aCarList(){
    List<Car> carList = carList();
    List<Car> aCarList = new ArrayList<>();
    for (int i=0; i<carList.size(); i++){
      if (carList.get(i).getModel().getSection().getName().equals("a")){
        aCarList.add(carList.get(i));
      }
    }
    return aCarList;
  }

}
