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
    reservationDto.setStartHour(reservation.getStartHour());
    reservationDto.setEndHour(reservation.getEndHour());
    reservationDto.setPrice(reservation.getPrice());
    reservationDto.setCarDto(carDtoMapper.mapCarToDto(reservation.getCar()));
    reservationDto.setClientDto(clientDtoMapper.mapClientToDto(reservation.getClient()));
    if (workerDtoMapper.mapWorkerToDto(reservation.getWorker()) != null){
      reservationDto.setWorkerDto(workerDtoMapper.mapWorkerToDto(reservation.getWorker()));
    } else {
      reservationDto.setWorkerDto(null);
    }

    return reservationDto;
  }
}
