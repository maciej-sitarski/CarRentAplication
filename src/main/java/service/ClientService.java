package service;

import dao.ClientDaoBean;
import dto.ClientDto;
import entity.Client;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.ClientDtoMapper;

@Stateless
public class ClientService {

  @EJB
  ClientDaoBean clientDaoBean;

  @EJB
  ClientDtoMapper clientDtoMapper;

  public List findClientEmailInDB(String email) {
    return clientDaoBean.findClientEmailInDB(email);
  }

  public List findClientPeselInDB(String pesel) {
    return clientDaoBean.findClientPeselInDB(pesel);
  }

  public List findClientNumberInDB(String number) {
    return clientDaoBean.findClientNumberInDB(number);
  }

  public ClientDto findClientDtoById(Long id) {
    return clientDtoMapper.mapClientToDto(clientDaoBean.findClientById(id));
  }

  public Client findClientById(Long id) {
    return clientDaoBean.findClientById(id);
  }

  public void deleteClientById(Long id) {
    clientDaoBean.deleteClient(id);
  }

  public ClientDto findClientDtoByEmail(String email) {
    return clientDtoMapper.mapClientToDto(clientDaoBean.findClientByEmail(email).get());
  }

  public Optional<Client> findClientByEmail(String email) {
    return clientDaoBean.findClientByEmail(email);
  }

  public List<ClientDto> findAllClientsDto() {
    return clientDaoBean.findAllClients().stream()
        .map(client -> clientDtoMapper.mapClientToDto(client)).collect(
            Collectors.toList());
  }
}
