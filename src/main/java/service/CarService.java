package service;

import entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class CarService {

  public List<Car> aCar(){
    List<Car> aCarsList = new ArrayList<>();
    return aCarsList;
  }

}
