package service;

import dao.EquipmentDaoBean;
import dto.EquipmentDto;
import entity.Equipment;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.EquipmentDtoMapper;

@Stateless
public class EquipmentService {

  @EJB
  EquipmentDaoBean equipmentDaoBean;

  @EJB
  EquipmentDtoMapper equipmentDtoMapper;

  public List<EquipmentDto> findAllEquipmentsDto() {
    return equipmentDaoBean.findAllEquipments().stream()
        .map(equipment -> equipmentDtoMapper.mapEquipmentToDto(equipment)).collect(
            Collectors.toList());
  }

  public List<Equipment> findAllEquipments() {
    return equipmentDaoBean.findAllEquipments();
  }
}
