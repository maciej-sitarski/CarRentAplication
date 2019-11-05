package dao;

import entity.Department;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

  public List<Department> findAllDepartments() {
    Query query = entityManager.createNamedQuery("Departments.findAll", Department.class);
    return query.getResultList();
  }
}
