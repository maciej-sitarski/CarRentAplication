package mapper;

import dto.ClientDto;
import entity.Client;
import javax.ejb.Stateless;

@Stateless
public class ClientDtoMapper {

  public ClientDto mapClientToDto(Client client) {
    ClientDto clientDto = new ClientDto();

    clientDto.setId(client.getId());
    clientDto.setEmail(client.getEmail());
    clientDto.setName(client.getName());
    clientDto.setSurname(client.getSurname());
    clientDto.setPesel(client.getPesel());
    clientDto.setPhoneNumber(client.getPhoneNumber());
    clientDto.setReservationNumber(client.getReservationNumber());

    return clientDto;
  }
}
