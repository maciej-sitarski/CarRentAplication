package dao;

import entity.Position;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PositionDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Position position) {
    entityManager.persist(position);
  }

  public Position findBrandById(Long id) {
    return entityManager.find(Position.class, id);
  }
}
