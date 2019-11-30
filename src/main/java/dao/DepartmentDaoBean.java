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

  public void saveDepartment(Department department) {
    entityManager.persist(department);
  }

  public List<Department> findAllDepartments() {
    Query query = entityManager.createNamedQuery("Departments.findAll", Department.class);
    return query.getResultList();
  }

  public Department findWarszawaDepartment() {
    Query query = entityManager.createNamedQuery("Department.findWarszawa", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
}
