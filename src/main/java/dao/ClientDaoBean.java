package dao;

import entity.Client;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ClientDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveClient(Client client) {
    entityManager.persist(client);
  }

  public void updateClient(Client client) {
    entityManager.merge(client);
  }

  public void deleteClient(Client client) {
    entityManager.remove(client);
  }

  public Client findClientById(Long id) {
    return entityManager.find(Client.class, id);
  }

  public List findClientEmailInDB(String email) {
    Query query = entityManager.createNamedQuery("Client.findEmailInDB");
    query.setParameter("email", email);
    return query.getResultList();
  }

  public List findClientPeselInDB(String pesel) {
    Query query = entityManager.createNamedQuery("Client.findPeselInDB");
    query.setParameter("pesel", pesel);
    return query.getResultList();
  }

  public List findClientNumberInDB(String number) {
    Query query = entityManager.createNamedQuery("Client.findNumberInDB");
    query.setParameter("phoneNumber", number);
    return query.getResultList();
  }

  public Optional<Client> findClientByEmail(String email) {
    Query query = entityManager.createNamedQuery("Client.findClientByEmail");
    query.setParameter("email", email);
    List<Client> clients = query.getResultList();
    if (clients.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(clients.get(0));
  }

  public List<Client> findAllClients() {
    Query query = entityManager.createNamedQuery("Client.findAll", Client.class);
    return query.getResultList();
  }


}
