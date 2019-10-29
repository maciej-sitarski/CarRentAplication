package mapper;

import dto.EquipmentDto;
import entity.Equipment;
import javax.ejb.Stateless;

@Stateless
public class EquipmentDtoMapper {

  public EquipmentDto mapEquipmentToDto(Equipment equipment){
    EquipmentDto equipmentDto = new EquipmentDto();

    equipmentDto.setId(equipment.getId());
    equipmentDto.setInsurance(equipment.getInsurance());
    equipmentDto.setNavigation(equipment.getNavigation());
    equipmentDto.setNumberOfBabyCarrier(equipment.getNumberOfBabyCarrier());
    equipmentDto.setNumberOfChildSeat(equipment.getNumberOfChildSeat());
    equipmentDto.setNumberOfPad(equipment.getNumberOfPad());

    return equipmentDto;
  }
}
