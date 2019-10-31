package dao;

import entity.Car;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Car car) {
    entityManager.persist(car);
  }

  public Car findBrandById(Long id) {
    return entityManager.find(Car.class, id);
  }
}
