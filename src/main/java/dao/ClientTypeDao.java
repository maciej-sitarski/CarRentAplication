package dao;

import entity.ClientType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClientTypeDao {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(ClientType clientType) {
    entityManager.persist(clientType);
  }

  public ClientType findBrandById(Long id) {
    return entityManager.find(ClientType.class, id);
  }
}
