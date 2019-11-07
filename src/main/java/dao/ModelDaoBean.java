package dao;

import entity.Model;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ModelDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveModel(Model model) {
    entityManager.persist(model);
  }

  public Model findBrandById(Long id) {
    return entityManager.find(Model.class, id);
  }
}
