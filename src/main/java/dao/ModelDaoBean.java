package dao;

import entity.Model;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ModelDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveModel(Model model) {
    entityManager.persist(model);
  }

  public List<Model> findModelListBySection(String name) {
    Query query = entityManager.createNamedQuery("Models.findAllBySection");
    query.setParameter("name", name);
    return query.getResultList();
  }
}
