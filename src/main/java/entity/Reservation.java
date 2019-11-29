package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Reservations.findAllReservationsFromDepartment",
        query = "SELECT r FROM Reservation r INNER JOIN r.car c INNER JOIN r.car.department d WHERE d.city = :city"
    ),
    @NamedQuery(
        name = "Reservations.findReservationsByCars",
        query = "SELECT r FROM Reservation r INNER JOIN r.car c WHERE c.id = :id"
    ),
    @NamedQuery(
        name = "Reservations.findAllClientReservations",
        query = "SELECT r FROM Reservation r  WHERE r.client.id = :id"
    )
})

@Entity
@Table(name = "reservation")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id")
  Long id;

  @Column(name = "start_date")
  String startDate;

  @Column(name = "end_date")
  String endDate;

  @Column(name = "start_hour")
  String startHour;

  @Column(name = "end_hour")
  String endHour;

  @Column(name = "price")
  Long price;

  @OneToMany(mappedBy = "equipment")
  List<ReservationEquipment> reservationEquipments = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "client_id")
  Client client;

  @ManyToOne
  @JoinColumn(name = "worker_id")
  Worker worker;

  @ManyToOne
  @JoinColumn(name = "car_id")
  Car car;

  public Reservation() {
  }

  public Reservation(String startDate, String endDate, String startHour, String endHour) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.startHour = startHour;
    this.endHour = endHour;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<ReservationEquipment> getReservationEquipments() {
    return reservationEquipments;
  }

  public void setReservationEquipments(List<ReservationEquipment> reservationEquipments) {
    this.reservationEquipments = reservationEquipments;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Worker getWorker() {
    return worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public String getStartHour() {
    return startHour;
  }

  public void setStartHour(String startHour) {
    this.startHour = startHour;
  }

  public String getEndHour() {
    return endHour;
  }

  public void setEndHour(String endHour) {
    this.endHour = endHour;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}
