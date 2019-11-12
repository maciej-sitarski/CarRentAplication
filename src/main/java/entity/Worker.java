package entity;

import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Worker.findEmailInDB",
        query = "SELECT w.email FROM Worker w WHERE w.email = :email"
    ),
    @NamedQuery(
        name = "Worker.findPeselInDB",
        query = "SELECT w.pesel FROM Worker w WHERE w.pesel = :pesel"
    ),
    @NamedQuery(
        name = "Worker.findNumberInDB",
        query = "SELECT w.phoneNumber FROM Worker w WHERE w.phoneNumber = :phoneNumber"
    ),
    @NamedQuery(
        name = "Worker.findWorkerByEmail",
        query = "SELECT w FROM Worker w WHERE w.email = :email"
    )
})

@Entity
@Table(name = "worker")
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "worker_id")
  Long id;

  @Column(name = "name")
  String fullName;

  @Column(name = "email")
  String email;

  @Column(name = "pesel")
  String pesel;

  @Column(name = "phone_number")
  String phoneNumber;

  @Column(name = "password")
  String password;

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

  public Worker(String fullName, String email, String pesel, String phoneNumber,
      String password) {
    this.fullName = fullName;
    this.email = email;
    this.pesel = pesel;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
