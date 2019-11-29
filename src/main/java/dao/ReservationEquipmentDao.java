package dao;

import entity.Reservation;
import entity.ReservationEquipment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationEquipmentDao {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveReservationEquipment(ReservationEquipment reservationEquipment) {
    entityManager.persist(reservationEquipment);
  }

  public ReservationEquipment findReservationEquipmentById(Long id) {
    return entityManager.find(ReservationEquipment.class, id);
  }

  public List<ReservationEquipment> findAllReservationEquipmentsListByReservationId(Long id){
    Query query = entityManager.createNamedQuery("ReservationsEquipments.findAllReservationsEquipmentsByReservationId");
    query.setParameter("id", id);
    return query.getResultList();
  }

  public void deleteReservationEquipment(Long id) {
    entityManager.remove(entityManager.find(ReservationEquipment.class, id));
  }

}
