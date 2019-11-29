package rest;

import dao.ReservationDaoBean;
import dao.ReservationEquipmentDao;
import dto.CarDto;
import entity.Client;
import entity.Equipment;
import entity.Reservation;
import entity.ReservationEquipment;
import entity.Worker;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import mapper.reverseMapper.CarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.CarService;
import service.ClientService;
import service.EquipmentService;
import service.ReservationEquipmentService;
import service.ReservationService;
import service.WorkerService;

@Path("/reservations")
public class ReservationController {

  @EJB
  ClientService clientService;

  @EJB
  CarService carService;

  @EJB
  CarMapper carMapper;

  @EJB
  EquipmentService equipmentService;

  @EJB
  ReservationEquipmentDao reservationEquipmentDao;

  @EJB
  ReservationDaoBean reservationDaoBean;

  @EJB
  WorkerService workerService;

  @EJB
  ReservationService reservationService;

  @EJB
  ReservationEquipmentService reservationEquipmentService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PATCH
  @Path("/save/{startDate}/{startHour}/{backDate}/{backHour}/{modelName}/{idClient}/{insuranceFull}/{insuranceBasic}/{navigation}/{babyCarrier}/{babyCarriesNumbers}/{smallSeat}/{smallSeatNumbers}/{seat}/{seatNumbers}/{departmentStart}/{reservationPrice}")
  public Response saveReservation(
      @PathParam("startDate") String startDate, @PathParam("startHour") String startHour,
      @PathParam("backDate") String backDate, @PathParam("backHour") String backHour,
      @PathParam("modelName") String modelName, @PathParam("idClient") Long idClient,
      @PathParam("insuranceFull") String insuranceFull, @PathParam("insuranceBasic") String insuranceBasic,
      @PathParam("navigation") String navigation, @PathParam("babyCarrier") String babyCarrier,
      @PathParam("babyCarriesNumbers") String babyCarriesNumbers, @PathParam("smallSeat") String smallSeat,
      @PathParam("smallSeatNumbers") String smallSeatNumbers, @PathParam("seat") String seat,
      @PathParam("seatNumbers") String seatNumbers, @PathParam("departmentStart") String departmentStart, @PathParam("reservationPrice") Long reservationPrice)
      throws ParseException {

    Reservation reservation =  new Reservation();
    reservation.setStartDate(startDate);
    reservation.setStartHour(startHour);
    reservation.setEndDate(backDate);
    reservation.setEndHour(backHour);
    reservation.setPrice(reservationPrice);
    reservation.setClient(clientService.findClientById(idClient));
    reservation.setWorker(workerService.findWorkerByEmail("randomWorker").get());
    CarDto carDto = carService.findSpecifyAbilityCarsList(departmentStart,startDate,backDate,startHour,backHour).stream().findFirst().get();
    reservation.setCar(carMapper.mapCar(carDto));
    reservation.setReservationEquipments(null);
    reservationDaoBean.saveReservation(reservation);

    List<Equipment> equipments = equipmentService.findAllEquipments();

    if(!insuranceBasic.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(1L);
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Ubezpieczenie podstawowe")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    if(!insuranceFull.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(1L);
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Ubezpieczenie pelne")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    if(!navigation.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(1L);
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Nawigacja GPS")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    if(!babyCarrier.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(Long.valueOf(babyCarriesNumbers));
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Fotelik dla dziecka (nosidelko 0-9kg)")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    if(!smallSeat.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(Long.valueOf(smallSeatNumbers));
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Fotelik dla dziecka (9-36kg)")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    if(!seat.equals("empty")){
      ReservationEquipment reservationEquipment =  new ReservationEquipment();
      reservationEquipment.setNumber(Long.valueOf(seatNumbers));
      Equipment equipment = equipments.stream().filter(equipment1 -> equipment1.getEquipmentType().equals("Podkladka(siedzisko) dla dziecka")).findFirst().get();
      reservationEquipment.setEquipment(equipment);
      reservationEquipment.setReservation(reservation);
      reservationEquipmentDao.saveReservationEquipment(reservationEquipment);
    }

    return Response.ok().build();
  }

  @PATCH
  @Path("/delete/{reservationId}")
  public Response deleteReservation(
      @PathParam("reservationId") Long reservationId){

    List<ReservationEquipment> reservationEquipments = reservationEquipmentService.findReservationEquipmentListByReservationId(reservationId);
    reservationEquipments.forEach(reservationEquipment -> reservationEquipmentDao.deleteReservationEquipment(reservationEquipment.getId()));
    reservationDaoBean.deleteReservation(reservationId);

    return Response.ok().build();
  }
}
