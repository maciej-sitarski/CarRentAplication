package service;

import dao.EquipmentDaoBean;
import dao.ReservationDaoBean;
import dto.ReservationDto;
import entity.Equipment;
import entity.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.ReservationDtoMapper;

@Stateless
public class ReservationService {

  @EJB
  ReservationDaoBean reservationDaoBean;

  @EJB
  ReservationDtoMapper reservationDtoMapper;

  @EJB
  EquipmentDaoBean equipmentDaoBean;

  public Long countingPriceOfReservation(String startDate, String finishDate,
      String sectionPrice, String babyCarrier, String smallSeat, String seat, String navigation,
      String insuranceBasic, String insuranceFull, String babyCarriesNumbers,
      String smallSeatNumbers, String seatNumbers) throws ParseException {
    Long numberOfDays = countingNumberOfDayOfReservation(startDate, finishDate);
    Long finalPrice = 0L;
    List<Equipment> equipments = equipmentDaoBean.findAllEquipments();
    if (babyCarrier != null) {
      finalPrice = finalPrice + Long.parseLong(babyCarriesNumbers) * equipments.get(0).getPrice();
    }
    if (smallSeat != null) {
      finalPrice = finalPrice + Long.parseLong(smallSeatNumbers) * equipments.get(1).getPrice();
    }
    if (seat != null) {
      finalPrice = finalPrice + Long.parseLong(seatNumbers) * equipments.get(2).getPrice();
    }
    if (navigation != null) {
      finalPrice = finalPrice + equipments.get(3).getPrice();
    }
    if (insuranceBasic != null) {
      finalPrice = finalPrice + equipments.get(4).getPrice();
    }
    if (insuranceFull != null) {
      finalPrice = finalPrice + equipments.get(5).getPrice();
    }
    return (finalPrice + Long.parseLong(sectionPrice)) * numberOfDays;
  }

  public Long countingNumberOfDayOfReservation(String startDate, String finishDate)
      throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startFormatDate = dateFormat.parse(startDate);
    Date finishFormatDate = dateFormat.parse(finishDate);

    long duration = finishFormatDate.getTime() - startFormatDate.getTime();

    return duration / (1000 * 60 * 60 * 24);
  }

  public List<ReservationDto> findAllClientReservationDto(Long id) {
    List<ReservationDto> reservationsDto = reservationDaoBean.findAllClientReservations(id).stream()
        .map(reservation -> reservationDtoMapper.mapReservationToDto(reservation)).collect(
            Collectors.toList());
    return reservationsDto;
  }

  public ReservationDto findReservationDtoById(Long id) {
    ReservationDto reservationDto = reservationDtoMapper
        .mapReservationToDto(reservationDaoBean.findReservationById(id));
    return reservationDto;
  }

  public Reservation findReservationById(Long id) {
    Reservation reservation = reservationDaoBean.findReservationById(id);
    return reservation;
  }

  public List<ReservationDto> findListOfReservationsDtoFromDepartment(String city) {
    List<ReservationDto> reservationsDtoList = reservationDaoBean
        .findAllReservationsFromDepartmentList(city).stream()
        .map(reservation -> reservationDtoMapper.mapReservationToDto(reservation)).collect(
            Collectors.toList());
    return reservationsDtoList;
  }

  public List<ReservationDto> findListOfWorkerReservationsDto(Long id) {
    List<ReservationDto> reservationsDtoList = reservationDaoBean
        .findAllWorkerReservations(id).stream()
        .map(reservation -> reservationDtoMapper.mapReservationToDto(reservation)).collect(
            Collectors.toList());
    return reservationsDtoList;
  }
}
