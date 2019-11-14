package dao;

import entity.ClientType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClientTypeDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveClientType(ClientType clientType) {
    entityManager.persist(clientType);
  }

  public ClientType findClientTypeById(Long id) {
    return entityManager.find(ClientType.class, id);
  }
}
