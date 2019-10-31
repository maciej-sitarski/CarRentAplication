package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_type")
public class ClientType {

  @Id
  @Column(name = "client_id")
  Long id;

  @Column(name = "type")
  String type;

  @Column(name = "discount")
  String discount;

  @OneToMany(mappedBy = "clientType")
  List<Client> clients = new ArrayList<>();

  public ClientType() {
  }

  public ClientType(String type, String discount) {
    this.type = type;
    this.discount = discount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> clients) {
    this.clients = clients;
  }
}
