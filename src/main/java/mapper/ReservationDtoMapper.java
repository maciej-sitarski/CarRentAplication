package mapper;

import dto.ReservationDto;
import entity.Reservation;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReservationDtoMapper {

  @EJB
  WorkerDtoMapper workerDtoMapper;

  @EJB
  ClientDtoMapper clientDtoMapper;

  @EJB
  EquipmentDtoMapper equipmentDtoMapper;

  @EJB
  CarDtoMapper carDtoMapper;

  public ReservationDto mapReservationToDto(Reservation reservation){
    ReservationDto reservationDto = new ReservationDto();

    reservationDto.setId(reservation.getId());
    reservationDto.setStartDate(reservation.getStartDate());
    reservationDto.setEndDate(reservation.getEndDate());
    reservationDto.setBrandCarName(carDtoMapper.mapCarToDto(reservation.getCar()).getBrandName());
    reservationDto.setSectionCarName(carDtoMapper.mapCarToDto(reservation.getCar()).getSectionName());
    reservationDto.setSectionCarPrice(carDtoMapper.mapCarToDto(reservation.getCar()).getSectionPrice());
    reservationDto.setModelCarName(carDtoMapper.mapCarToDto(reservation.getCar()).getModelName());
    reservationDto.setRegistrationCarNumber(carDtoMapper.mapCarToDto(reservation.getCar()).getRegistrationNumber());
    reservationDto.setDepartmentCity(carDtoMapper.mapCarToDto(reservation.getCar()).getDepartmentCity());
    reservationDto.setClientEmail(clientDtoMapper.mapClientToDto(reservation.getClient()).getEmail());
    reservationDto.setClientName(clientDtoMapper.mapClientToDto(reservation.getClient()).getName());
    reservationDto.setClientPesel(clientDtoMapper.mapClientToDto(reservation.getClient()).getPesel());
    reservationDto.setClientPhoneNumber(clientDtoMapper.mapClientToDto(reservation.getClient()).getPhoneNumber());
    reservationDto.setClientReservationNumber(clientDtoMapper.mapClientToDto(reservation.getClient()).getReservationNumber());
    reservationDto.setClientSurname(clientDtoMapper.mapClientToDto(reservation.getClient()).getSurname());
    reservationDto.setInsurance(equipmentDtoMapper.mapEquipmentToDto(reservation.getEquipment()).getInsurance());
    reservationDto.setNavigation(equipmentDtoMapper.mapEquipmentToDto(reservation.getEquipment()).getNavigation());
    reservationDto.setNumberOfBabyCarrier(equipmentDtoMapper.mapEquipmentToDto(reservation.getEquipment()).getNumberOfBabyCarrier());
    reservationDto.setNumberOfChildSeat(equipmentDtoMapper.mapEquipmentToDto(reservation.getEquipment()).getNumberOfChildSeat());
    reservationDto.setNumberOfPad(equipmentDtoMapper.mapEquipmentToDto(reservation.getEquipment()).getNumberOfPad());
    reservationDto.setWorkerName(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getName());
    reservationDto.setWorkerSurname(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getSurname());
    reservationDto.setWorkerPesel(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getPesel());
    reservationDto.setWorkerEmail(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getEmail());
    reservationDto.setWorkerPositionName(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getPositionName());

    return reservationDto;
  }
}
