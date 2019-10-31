package mapper;

import dto.ClientDto;
import entity.Client;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClientDtoMapper {

  @EJB
  ClientTypeDtoMapper clientTypeDtoMapper;

  public ClientDto mapClientToDto(Client client) {
    ClientDto clientDto = new ClientDto();

    clientDto.setId(client.getId());
    clientDto.setEmail(client.getEmail());
    clientDto.setNameAndSurname(client.getNameAndSurname());
    clientDto.setPesel(client.getPesel());
    clientDto.setPhoneNumber(client.getPhoneNumber());
    clientDto.setClientType(clientTypeDtoMapper.mapClientTypeToDto(client.getClientType()).getType());
    clientDto.setClientTypeDiscount(clientTypeDtoMapper.mapClientTypeToDto(client.getClientType()).getDiscount());

    return clientDto;
  }
}
