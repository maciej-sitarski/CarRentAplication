package dao;

import entity.Client;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClientDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Client client) {
    entityManager.persist(client);
  }

  public Client findBrandById(Long id) {
    return entityManager.find(Client.class, id);
  }
}
