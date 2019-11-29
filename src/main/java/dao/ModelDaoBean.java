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

  public Model findModelById(Long id) {
    return entityManager.find(Model.class, id);
  }

  public List<Model> findModelList(){
    Query query = entityManager.createNamedQuery("Models.findAll");
    return query.getResultList();
  }

  public List<Model> findModelListBySection(String name){
    Query query = entityManager.createNamedQuery("Models.findAllBySection");
    query.setParameter("name", name);
    return query.getResultList();
  }
}
