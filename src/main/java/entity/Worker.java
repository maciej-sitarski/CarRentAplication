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
@Table(name = "worker")
public class Worker {

  @Id
  @Column(name = "worker_id")
  Long id;

  @Column(name = "name")
  String nameAndSurname;

  @Column(name = "email")
  String email;

  @Column(name = "pesel")
  String pesel;

  @OneToMany(mappedBy = "worker")
  List<Reservation> reservations = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "position_id")
  Position position;

  @ManyToOne
  @JoinColumn(name = "department_id")
  Department department;

  public Worker() {
  }

  public Worker(String nameAndSurname, String email, String pesel) {
    this.nameAndSurname = nameAndSurname;
    this.email = email;
    this.pesel = pesel;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameAndSurname() {
    return nameAndSurname;
  }

  public void setNameAndSurname(String nameAndSurname) {
    this.nameAndSurname = nameAndSurname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
