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
    reservationDto.setClientNameAndSurname(clientDtoMapper.mapClientToDto(reservation.getClient()).getNameAndSurname());
    reservationDto.setClientPesel(clientDtoMapper.mapClientToDto(reservation.getClient()).getPesel());
    reservationDto.setClientPhoneNumber(clientDtoMapper.mapClientToDto(reservation.getClient()).getPhoneNumber());
    reservationDto.setClientType(clientDtoMapper.mapClientToDto(reservation.getClient()).getClientType());
    reservationDto.setClientTypeDiscount(clientDtoMapper.mapClientToDto(reservation.getClient()).getClientTypeDiscount());
    reservationDto.setWorkerNameAndSurname(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getNameAndSurname());
    reservationDto.setWorkerPesel(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getPesel());
    reservationDto.setWorkerEmail(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getEmail());
    reservationDto.setWorkerPositionName(workerDtoMapper.mapWorkerToDto(reservation.getWorker()).getPositionName());

    return reservationDto;
  }
}
