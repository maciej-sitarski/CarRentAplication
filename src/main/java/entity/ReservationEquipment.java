package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "ReservationsEquipments.findAllReservationsEquipmentsByReservationId",
        query = "SELECT r FROM ReservationEquipment r  WHERE r.reservation.id = :id"
    )
})
@Entity
@Table(name = "reservation_equipment")
public class ReservationEquipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_equipment_id")
  Long id;

  @Column(name = "number")
  Long number;

  @ManyToOne
  @JoinColumn(name = "equipment_id")
  Equipment equipment;

  @ManyToOne
  @JoinColumn(name = "reservation_id")
  Reservation reservation;

  public ReservationEquipment() {
  }

  public ReservationEquipment(Long number) {
    this.number = number;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }
}
