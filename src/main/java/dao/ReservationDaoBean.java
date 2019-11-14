package dao;

import entity.Reservation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
