package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

  @Id
  @Column(name = "equipment_id")
  Long id;

  @Column(name = "nawigation")
  Boolean isNavigation;

  @Column(name = "insurance")
  Boolean isInsurance;

  @Column(name = "baby_carrier")
  Long numberOfBabyCarrier;

  @Column(name = "child_seat")
  Long numberOfChildSeat;

  @Column(name = "pad")
  Long numberOfPad;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "reservation_id")
  Reservation reservation;

  public Equipment() {
  }

  public Equipment(Boolean isNavigation, Boolean isInsurance, Long numberOfBabyCarrier,
      Long numberOfChildSeat, Long numberOfPad) {
    this.isNavigation = isNavigation;
    this.isInsurance = isInsurance;
    this.numberOfBabyCarrier = numberOfBabyCarrier;
    this.numberOfChildSeat = numberOfChildSeat;
    this.numberOfPad = numberOfPad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getNavigation() {
    return isNavigation;
  }

  public void setNavigation(Boolean navigation) {
    isNavigation = navigation;
  }

  public Boolean getInsurance() {
    return isInsurance;
  }

  public void setInsurance(Boolean insurance) {
    isInsurance = insurance;
  }

  public Long getNumberOfBabyCarrier() {
    return numberOfBabyCarrier;
  }

  public void setNumberOfBabyCarrier(Long numberOfBabyCarrier) {
    this.numberOfBabyCarrier = numberOfBabyCarrier;
  }

  public Long getNumberOfChildSeat() {
    return numberOfChildSeat;
  }

  public void setNumberOfChildSeat(Long numberOfChildSeat) {
    this.numberOfChildSeat = numberOfChildSeat;
  }

  public Long getNumberOfPad() {
    return numberOfPad;
  }

  public void setNumberOfPad(Long numberOfPad) {
    this.numberOfPad = numberOfPad;
  }

  public Reservation getReservation() {
    return reservation;
  }

  public void setReservation(Reservation reservation) {
    this.reservation = reservation;
  }
}
