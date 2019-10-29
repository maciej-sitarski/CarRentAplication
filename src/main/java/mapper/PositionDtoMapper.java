package mapper;

import dto.PositionDto;
import entity.Position;
import javax.ejb.Stateless;

@Stateless
public class PositionDtoMapper {

  public PositionDto mapPositionToDto(Position position){
    PositionDto positionDto = new PositionDto();

    positionDto.setId(position.getId());
    positionDto.setName(position.getName());

    return positionDto;
  }
}
