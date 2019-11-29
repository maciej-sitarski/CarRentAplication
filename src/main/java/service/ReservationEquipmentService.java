package service;

import dao.ReservationEquipmentDao;
import dto.ReservationEquipmentDto;
import entity.ReservationEquipment;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.ReservationEquipmentDtoMapper;

@Stateless
public class ReservationEquipmentService {

  @EJB
  ReservationEquipmentDao reservationEquipmentDao;

  @EJB
  ReservationEquipmentDtoMapper reservationEquipmentDtoMapper;

  public List<ReservationEquipmentDto> findReservationEquipmentDtoListByReservationId(Long id) {
    List<ReservationEquipmentDto> reservationEquipmentDtos = reservationEquipmentDao.findAllReservationEquipmentsListByReservationId(id).stream().map(reservationEquipment -> reservationEquipmentDtoMapper.mapReservationEquipmentToDto(reservationEquipment)).collect(
        Collectors.toList());
    return reservationEquipmentDtos;
  }

  public List<ReservationEquipment> findReservationEquipmentListByReservationId(Long id) {
    List<ReservationEquipment> reservationEquipments = reservationEquipmentDao.findAllReservationEquipmentsListByReservationId(id);
    return reservationEquipments;
  }

}
