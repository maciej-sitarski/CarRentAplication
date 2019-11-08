package dao;

import entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveCar(Car car) {
    entityManager.persist(car);
  }

  public Car findBrandById(Long id) {
    return entityManager.find(Car.class, id);
  }

  public List<Car> findCarsList(String section){
    List<Car> carList = new ArrayList<>();
    return carList;
  }

}
