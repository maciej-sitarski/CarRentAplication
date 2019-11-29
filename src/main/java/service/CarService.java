package service;

import dao.CarDaoBean;
import dao.ReservationDaoBean;
import dto.CarDto;
import dto.ReservationDto;
import entity.Car;
import filterDate.FilterDistinctByKey;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CarService {

  @EJB
  ReservationDaoBean reservationDaoBean;

  @EJB
  ReservationDtoMapper reservationDtoMapper;

  @EJB
  CarDaoBean carDaoBean;

  @EJB
  CarDtoMapper carDtoMapper;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<CarDto> carList() {
    List<Car> carsDao = carDaoBean.findCarsList();
    List<CarDto> carsDto = new ArrayList<>();
    CarDto car;
    for (Car value : carsDao) {
      car = carDtoMapper.mapCarToDto(value);
      carsDto.add(car);
    }
    return carsDto;
  }

  public List<CarDto> uniqueCarsList() {
    return carList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }

  public List<CarDto> findSpecifyAbilityCarsList(String city, String startDate,
      String finishDate, String startHour, String endHour)
      throws ParseException {
    List<ReservationDto> specifyReservationList = reservationDaoBean
        .findAllReservationsFromDepartmentList(city).stream()
        .map(reservation -> reservationDtoMapper.mapReservationToDto(reservation)).collect(
            Collectors.toList());
    for (int i = 0; i < specifyReservationList.size(); i++) {
      logger.info(specifyReservationList.get(i).getCarDto().getModelDto().getName());

    }
    List<CarDto> availableCarsInDepartmentList = carDaoBean.findCarsListByDepartment(city)
        .stream().map(car -> carDtoMapper.mapCarToDto(car)).collect(
            Collectors.toList());

    for (int i = 0; i < availableCarsInDepartmentList.size(); i++) {
      logger.info(availableCarsInDepartmentList.get(i).getModelDto().getName()+"dupadupadupa");

    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startFormatDate = dateFormat.parse(startDate);
    Date finishFormatDate = dateFormat.parse(finishDate);

    DateFormat hourFormat = new SimpleDateFormat("hh:mm");
    Date startFormatHour = hourFormat.parse(startHour);
    Date finishFormatHour = hourFormat.parse(endHour);


    for (int i = 0; i < specifyReservationList.size(); i++) {
      if (dateFormat.parse(specifyReservationList.get(i).getStartDate()).compareTo(startFormatDate)
          > 0 &&
          dateFormat.parse(specifyReservationList.get(i).getStartDate()).compareTo(finishFormatDate)
              < 0) {
        if (availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())) {
          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());

        }
      } else if (
          dateFormat.parse(specifyReservationList.get(i).getEndDate()).compareTo(startFormatDate)
              > 0 && dateFormat.parse(specifyReservationList.get(i).getEndDate())
              .compareTo(finishFormatDate) < 0) {
        if (availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())) {
          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());

        }
      } else if (dateFormat.parse(specifyReservationList.get(i).getStartDate())
          .compareTo(finishFormatDate) == 0 &&
          hourFormat.parse(specifyReservationList.get(i).getStartHour())
              .compareTo(finishFormatHour) < 0) {
        if (availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())) {
          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());

        }
      } else if (dateFormat.parse(specifyReservationList.get(i).getEndDate())
          .compareTo(startFormatDate) == 0 &&
          hourFormat.parse(specifyReservationList.get(i).getEndHour())
              .compareTo(startFormatHour) > 0) {
        if (availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())) {
          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());

        }
      }

    }
    return availableCarsInDepartmentList;
  }

  public List<CarDto> findSpecifyAbilityUniqueCarsList(String city, String startDate,
      String finishDate, String startHour, String endHour) throws ParseException {
    return findSpecifyAbilityCarsList(city,startDate,finishDate,startHour,endHour).stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }

}

