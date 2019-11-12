package dao;

import entity.Car;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveCar (Car car) {
    entityManager.persist(car);
  }

  public Car findCarById(Long id) {
    return entityManager.find(Car.class, id);
  }
}
