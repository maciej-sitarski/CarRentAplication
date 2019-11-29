package dao;

import entity.Car;
import entity.Reservation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveReservation(Reservation reservation) {
    entityManager.persist(reservation);
  }

  public Reservation findReservationById(Long id) {
    return entityManager.find(Reservation.class, id);
  }
  public List<Reservation> findAllReservationsFromDepartmentList(String city){
    Query query = entityManager.createNamedQuery("Reservations.findAllReservationsFromDepartment");
    query.setParameter("city", city);
    return query.getResultList();
  }

  public List<Reservation> findReservationsByCars(Long id){
    Query query = entityManager.createNamedQuery("Reservations.findReservationsByCars");
    query.setParameter("id", id);
    return query.getResultList();
  }

  public List<Reservation> findAllClientReservations(Long id){
    Query query = entityManager.createNamedQuery("Reservations.findReservationsByCars");
    query.setParameter("id", id);
    return query.getResultList();
  }

  public void deleteReservation(Long id) {
    entityManager.remove(entityManager.find(Reservation.class, id));
  }
}
