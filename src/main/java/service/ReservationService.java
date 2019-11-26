package service;

import dao.CarDaoBean;
import dao.EquipmentDaoBean;
import dao.ReservationDaoBean;
import dto.CarDto;
import dto.ReservationDto;
import entity.Equipment;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.CarDtoMapper;
import mapper.ReservationDtoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ReservationService {

  @EJB
  ReservationDaoBean reservationDaoBean;

  @EJB
  CarDaoBean carDaoBean;

  @EJB
  ReservationDtoMapper reservationDtoMapper;

  @EJB
  CarDtoMapper carDtoMapper;

  @EJB
  EquipmentDaoBean equipmentDaoBean;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public Long countingPriceOfReservation(String startDate, String finishDate,
      String sectionPrice, String babyCarrier, String smallSeat, String seat, String navigation,
      String insuranceBasic, String insuranceFull, String babyCarriesNumbers,
      String smallSeatNumbers, String seatNumbers) throws ParseException {
    Long numberOfDays = countingNumberOfDayOfReservation(startDate, finishDate);
    Long finalPrice = 0L;
    List<Equipment> equipments = equipmentDaoBean.findAllEquipments();
    if(babyCarrier != null){
      finalPrice=finalPrice+Long.parseLong(babyCarriesNumbers)*equipments.get(0).getPrice();
    }
    if(smallSeat != null){
      finalPrice=finalPrice+Long.parseLong(smallSeatNumbers)*equipments.get(1).getPrice();
    }
    if(seat != null){
      finalPrice=finalPrice+Long.parseLong(seatNumbers)*equipments.get(2).getPrice();
    }
    if(navigation != null){
      finalPrice=finalPrice+equipments.get(3).getPrice();
    }
    if(insuranceBasic != null){
      finalPrice=finalPrice+equipments.get(4).getPrice();
    }
    if(insuranceFull != null){
      finalPrice=finalPrice+equipments.get(5).getPrice();
    }
    return (finalPrice+Long.parseLong(sectionPrice))*numberOfDays;
  }

  public Long countingNumberOfDayOfReservation(String startDate, String finishDate)
      throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startFormatDate = dateFormat.parse(startDate);
    Date finishFormatDate = dateFormat.parse(finishDate);


    long duration = finishFormatDate.getTime() - startFormatDate.getTime();

    return duration/(1000*60*60*24);
  }
}
