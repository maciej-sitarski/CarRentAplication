package dao;

import entity.Department;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DepartmentDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Department department) {
    entityManager.persist(department);
  }

  public Department findBrandById(Long id) {
    return entityManager.find(Department.class, id);
  }
}
