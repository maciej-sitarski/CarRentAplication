package mapper;

import dto.ReservationEquipmentDto;
import entity.ReservationEquipment;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReservationEquipmentDtoMapper {

  @EJB
  EquipmentDtoMapper equipmentDtoMapper;

  @EJB
  ReservationDtoMapper reservationDtoMapper;

  public ReservationEquipmentDto mapReservationEquipmentToDto(ReservationEquipment reservationEquipment) {
    ReservationEquipmentDto reservationEquipmentDto = new ReservationEquipmentDto();

    reservationEquipmentDto.setId(reservationEquipment.getId());
    reservationEquipmentDto.setNumber(reservationEquipment.getNumber());
    reservationEquipmentDto.setEquipmentDto(equipmentDtoMapper.mapEquipmentToDto(reservationEquipment.getEquipment()));
    reservationEquipmentDto.setReservationDto(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()));

    return reservationEquipmentDto;
  }
}
