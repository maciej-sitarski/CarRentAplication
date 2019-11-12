package dao;

import entity.Position;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PositionDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void savePosition(Position position) {
    entityManager.persist(position);
  }

  public Position findPositionById(Long id) {
    return entityManager.find(Position.class, id);
  }
}
