package dao;

import entity.Car;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CarDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveCar(Car car) {
    entityManager.persist(car);
  }

  public Car findCarById(Long id) {
    return entityManager.find(Car.class, id);
  }

  public List<Car> findCarsList(){
    Query query = entityManager.createNamedQuery("Cars.findAll", Car.class);
    return query.getResultList();
  }

  public List<Car> findUniqueCarsList(){
    Query query = entityManager.createNamedQuery("Cars.findUnique");
    return query.getResultList();
  }

}
