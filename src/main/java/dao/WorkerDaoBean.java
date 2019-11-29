package dao;

import entity.Worker;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.jdbc.Work;

@Stateless
public class WorkerDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveWorker(Worker worker) {
    entityManager.persist(worker);
  }

  public void updateWorker(Worker worker) {
    entityManager.merge(worker);
  }

  public Worker findWorkerById(Long id) {
    return entityManager.find(Worker.class, id);
  }

  public void deleteWorker(Long id) {
    entityManager.remove(entityManager.find(Worker.class, id));
  }

  public List findWorkerEmailInDB(String email) {
    Query query = entityManager.createNamedQuery("Worker.findEmailInDB");
    query.setParameter("email", email);
    return query.getResultList();
  }

  public List findWorkerPeselInDB(String pesel) {
    Query query = entityManager.createNamedQuery("Worker.findPeselInDB");
    query.setParameter("pesel", pesel);
    return query.getResultList();
  }

  public List findWorkerNumberInDB(String number) {
    Query query = entityManager.createNamedQuery("Worker.findNumberInDB");
    query.setParameter("phoneNumber", number);
    return query.getResultList();
  }

  public Optional<Worker> findWorkerByEmail(String email) {
    Query query = entityManager.createNamedQuery("Worker.findWorkerByEmail");
    query.setParameter("email", email);
    List<Worker> workers = query.getResultList();
    if (workers.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(workers.get(0));
  }

  public List<Worker> findAllWorkers() {
    Query query = entityManager.createNamedQuery("Worker.findAll", Worker.class);
    return query.getResultList();
  }

  public List<Worker> findWorkersByDepartment(String city){
    Query query = entityManager.createNamedQuery("Worker.findWorkersByDepartment");
    query.setParameter("city", city);
    return query.getResultList();
  }

}
