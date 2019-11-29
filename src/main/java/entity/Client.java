package entity;

import java.util.ArrayList;
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
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Client.findEmailInDB",
        query = "SELECT c.email FROM Client c WHERE c.email = :email"
    ),
    @NamedQuery(
        name = "Client.findPeselInDB",
        query = "SELECT c.pesel FROM Client c WHERE c.pesel = :pesel"
    ),
    @NamedQuery(
        name = "Client.findNumberInDB",
        query = "SELECT c.phoneNumber FROM Client c WHERE c.phoneNumber = :phoneNumber"
    ),
    @NamedQuery(
        name = "Client.findClientByEmail",
        query = "SELECT c FROM Client c WHERE c.email = :email"
    ),
    @NamedQuery(
        name = "Client.findAll",
        query = "SELECT c FROM Client c"
    ),

})

@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @Column(name = "password")
  String password;

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  List<Reservation> reservations = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "client_type")
  ClientType clientType;

  public Client() {
  }

  public Client(String nameAndSurname, String email, String pesel, String phoneNumber,
      String password) {
    this.nameAndSurname = nameAndSurname;
    this.email = email;
    this.pesel = pesel;
    this.phoneNumber = phoneNumber;
    this.password = password;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
