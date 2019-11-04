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
    reservationDto.setCarDto(carDtoMapper.mapCarToDto(reservation.getCar()));
    reservationDto.setClientDto(clientDtoMapper.mapClientToDto(reservation.getClient()));
    reservationDto.setWorkerDto(workerDtoMapper.mapWorkerToDto(reservation.getWorker()));

    return reservationDto;
  }
}
