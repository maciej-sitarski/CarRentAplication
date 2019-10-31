package dao;

import entity.Worker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class WorkerDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Worker worker) {
    entityManager.persist(worker);
  }

  public Worker findBrandById(Long id) {
    return entityManager.find(Worker.class, id);
  }
}
