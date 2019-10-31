package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @Column(name = "car_id")
  Long id;

  @Column(name = "registration_number")
  String registrationNumber;

  @OneToMany(mappedBy = "car")
  List<Reservation> reservations = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "department_id")
  Department department;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  Brand brand;

  @ManyToOne
  @JoinColumn(name = "model_id")
  Model model;

  public Car() {
  }

  public Car(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Model getModel() {
    return model;
  }

  public void setModel(Model model) {
    this.model = model;
  }
}
