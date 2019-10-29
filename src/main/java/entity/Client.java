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
@Table(name = "client")
public class Client {

  @Id
  @Column(name = "client_id")
  Long id;

  @Column(name = "name_surname")
  String nameAndSurname;

  @Column(name = "email")
  String email;

  @Column(name = "pesel")
  String pesel;

  @Column(name = "phone_number")
  String phoneNumber;

  @OneToMany(mappedBy = "client")
  List<Reservation> reservations = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "client_type")
  ClientType clientType;

  public Client() {
  }

  public Client(String nameAndSurname, String email, String pesel, String phoneNumber) {
    this.nameAndSurname = nameAndSurname;
    this.email = email;
    this.pesel = pesel;
    this.phoneNumber = phoneNumber;
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public ClientType getClientType() {
    return clientType;
  }

  public void setClientType(ClientType clientType) {
    this.clientType = clientType;
  }
}
