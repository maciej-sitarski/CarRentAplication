package mapper;

import dto.ClientTypeDto;
import entity.ClientType;
import javax.ejb.Stateless;

@Stateless
public class ClientTypeDtoMapper {

  public ClientTypeDto mapClientTypeToDto(ClientType clientType) {
    ClientTypeDto clientTypeDto = new ClientTypeDto();

    clientTypeDto.setId(clientType.getId());
    clientTypeDto.setType(clientType.getType());
    clientTypeDto.setDiscount(clientType.getDiscount());

    return clientTypeDto;
  }
}
