package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

  @Id
  @Column(name = "reservation_id")
  Long id;

  @Column(name = "start_date")
  Date startDate;

  @Column(name = "end_date")
  Date endDate;

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

  public Reservation(Date startDate, Date endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
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
}
