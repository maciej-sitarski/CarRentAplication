package service;

import dao.ClientDaoBean;
import entity.Client;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClientService {

  @EJB
  ClientDaoBean clientDaoBean;

  public List findClientEmailInDB(String email){
    return clientDaoBean.findClientEmailInDB(email);
  }

  public List findClientPeselInDB(String pesel){
    return clientDaoBean.findClientPeselInDB(pesel);
  }

  public List findClientNumberInDB(String number){
    return clientDaoBean.findClientNumberInDB(number);
  }

  public Client findClientById(Long id){
    return clientDaoBean.findClientById(id);
  }
  public Optional<Client> findClientByEmail(String email){
    return clientDaoBean.findClientByEmail(email);
  }

}
