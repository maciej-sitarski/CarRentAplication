package dao;

import entity.Position;
import entity.Worker;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

  public List<Position> findAllPosition() {
    Query query = entityManager.createNamedQuery("Positions.findAll", Position.class);
    return query.getResultList();
  }

  public Position findWorkerPosition(){
    Query query = entityManager.createNamedQuery("Position.findWorker", Position.class);
    List<Position> positions = query.getResultList();
    return positions.get(0);
  }

  public Position findAdminPosition(){
    Query query = entityManager.createNamedQuery("Position.findAdmin", Position.class);
    List<Position> positions = query.getResultList();
    return positions.get(0);
  }

  public Position findMenagerPosition(){
    Query query = entityManager.createNamedQuery("Position.findMenager", Position.class);
    List<Position> positions = query.getResultList();
    return positions.get(0);
  }

  public Position findCoordinatorPosition(){
    Query query = entityManager.createNamedQuery("Position.findCoordinator", Position.class);
    List<Position> positions = query.getResultList();
    return positions.get(0);
  }
}
