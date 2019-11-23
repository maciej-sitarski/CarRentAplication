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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Equipment.findAll",
        query = "SELECT e FROM Equipment e"
    ),
})

@Entity
@Table(name = "equipment")
public class Equipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "equipment_id")
  Long id;

  @Column(name = "equipment_type")
  String equipmentType;

  @Column(name = "price")
  Long price;

  @OneToMany(mappedBy = "equipment")
  List<ReservationEquipment> reservationEquipments = new ArrayList<>();

  public Equipment() {
  }

  public Equipment(String equipmentType, Long price) {
    this.equipmentType = equipmentType;
    this.price = price;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEquipmentType() {
    return equipmentType;
  }

  public void setEquipmentType(String equipmentType) {
    this.equipmentType = equipmentType;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public List<ReservationEquipment> getReservationEquipments() {
    return reservationEquipments;
  }

  public void setReservationEquipments(List<ReservationEquipment> reservationEquipments) {
    this.reservationEquipments = reservationEquipments;
  }
}
