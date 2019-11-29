package mapper;

import dto.EquipmentDto;
import entity.Equipment;
import javax.ejb.Stateless;

@Stateless
public class EquipmentDtoMapper {

  public EquipmentDto mapEquipmentToDto(Equipment equipment) {
    EquipmentDto equipmentDto = new EquipmentDto();
    equipmentDto.setId(equipment.getId());
    equipmentDto.setEquipmentType(equipment.getEquipmentType());
    equipmentDto.setPrice(equipment.getPrice());
    return equipmentDto;
  }
}
