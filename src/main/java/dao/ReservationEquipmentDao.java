package dao;

import entity.ReservationEquipment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationEquipmentDao {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(ReservationEquipment reservationEquipment) {
    entityManager.persist(reservationEquipment);
  }

  public ReservationEquipment findBrandById(Long id) {
    return entityManager.find(ReservationEquipment.class, id);
  }

}
