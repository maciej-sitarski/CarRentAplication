package dao;

import entity.Equipment;
import entity.Position;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EquipmentDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveEquipment(Equipment equipment) {
    entityManager.persist(equipment);
  }

  public Equipment findEquipmentById(Long id) {
    return entityManager.find(Equipment.class, id);
  }

  public List<Equipment> findAllEquipments() {
    Query query = entityManager.createNamedQuery("Equipment.findAll", Equipment.class);
    return query.getResultList();
  }
}
