//package service;
//
//import dao.CarDaoBean;
//import dao.ReservationDaoBean;
//import dto.CarDto;
//import dto.ReservationDto;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import mapper.CarDtoMapper;
//import mapper.ReservationDtoMapper;
//
//@Stateless
//public class ReservationService {
//
//  @EJB
//  ReservationDaoBean reservationDaoBean;
//
//  @EJB
//  CarDaoBean carDaoBean;
//
//  @EJB
//  ReservationDtoMapper reservationDtoMapper;
//
//  @EJB
//  CarDtoMapper carDtoMapper;
//
//  public List<ReservationDto> findSpecifyReservationsList(String city, String startDate, String finishDate, String startHour,String endHour)
//      throws ParseException {
//    List<ReservationDto> specifyReservationList = reservationDaoBean.findAllReservationsFromDepartmentList(city).stream().map(reservation -> reservationDtoMapper.mapReservationToDto(reservation)).collect(
//        Collectors.toList());
//    List<CarDto> availableCarsInDepartmentList = carDaoBean.findCarsListFromDepartment(city).stream().map(car -> carDtoMapper.mapCarToDto(car)).collect(
//        Collectors.toList());
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date startFormatDate = dateFormat.parse(startDate);
//    Date finishFormatDate = dateFormat.parse(finishDate);
//
//    DateFormat hourFormat = new SimpleDateFormat("hh:mm");
//    Date startFormatHour = hourFormat.parse(startHour);
//    Date finishFormatHour = hourFormat.parse(endHour);
//
//    List<ReservationDto> finalListOfSpecifyReservations = new ArrayList<>();
//    for (int i = 0; i < specifyReservationList.size(); i++) {
//      if(specifyReservationList.get(i).getStartDate().compareTo(startFormatDate)>0 && specifyReservationList.get(i).getStartDate().compareTo(finishFormatDate)<0){
//        if(availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())){
//          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());
//          break;
//        }
//      } else if (specifyReservationList.get(i).getEndDate().compareTo(startFormatDate)>0 && specifyReservationList.get(i).getEndDate().compareTo(finishFormatDate)<0){
//        if(availableCarsInDepartmentList.contains(specifyReservationList.get(i).getCarDto())){
//          availableCarsInDepartmentList.remove(specifyReservationList.get(i).getCarDto());
//          break;
//        }
//      }
//
//    }
//
//
//  }
//
//}
