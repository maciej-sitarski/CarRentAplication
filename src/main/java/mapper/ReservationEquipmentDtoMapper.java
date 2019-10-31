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
    reservationEquipmentDto.setEquipmentPrice(equipmentDtoMapper.mapEquipmentToDto(reservationEquipment.getEquipment()).getPrice());
    reservationEquipmentDto.setEquipmentType(equipmentDtoMapper.mapEquipmentToDto(reservationEquipment.getEquipment()).getEquipmentType());
    reservationEquipmentDto.setBrandCarName(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getBrandCarName());
    reservationEquipmentDto.setClientEmail(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientEmail());
    reservationEquipmentDto.setClientNameAndSurname(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientNameAndSurname());
    reservationEquipmentDto.setClientPesel(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientPesel());
    reservationEquipmentDto.setClientPhoneNumber(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientPhoneNumber());
    reservationEquipmentDto.setClientType(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientType());
    reservationEquipmentDto.setClientTypeDiscount(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getClientTypeDiscount());
    reservationEquipmentDto.setDepartmentCity(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getDepartmentCity());
    reservationEquipmentDto.setModelCarName(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getModelCarName());
    reservationEquipmentDto.setRegistrationCarNumber(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getRegistrationCarNumber());
    reservationEquipmentDto.setReservationEndDate(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getEndDate());
    reservationEquipmentDto.setReservationStartDate(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getStartDate());
    reservationEquipmentDto.setSectionCarName(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getSectionCarName());
    reservationEquipmentDto.setSectionCarPrice(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getSectionCarPrice());
    reservationEquipmentDto.setWorkerEmail(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getWorkerEmail());
    reservationEquipmentDto.setWorkerNameAndSurname(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getWorkerNameAndSurname());
    reservationEquipmentDto.setWorkerPesel(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getWorkerPesel());
    reservationEquipmentDto.setWorkerPositionName(reservationDtoMapper.mapReservationToDto(reservationEquipment.getReservation()).getWorkerPositionName());

    return reservationEquipmentDto;
  }
}
