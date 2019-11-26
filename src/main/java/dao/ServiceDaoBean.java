package dao;

import entity.Service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServiceDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public  void saveService (Service service){
    entityManager.persist(service);
  }

  public Service findServiceById(Long id){return entityManager.find(Service.class, id);
  }


}
