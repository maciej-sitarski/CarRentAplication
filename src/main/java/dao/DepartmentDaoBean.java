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

  public Department findDepartmentById(Long id) {
    return entityManager.find(Department.class, id);
  }

  public List<Department> findAllDepartments() {
    Query query = entityManager.createNamedQuery("Departments.findAll", Department.class);
    return query.getResultList();
  }

  public Department findGdanskDepartment(){
    Query query = entityManager.createNamedQuery("Department.findGdansk", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findWarszawaDepartment(){
    Query query = entityManager.createNamedQuery("Department.findWarszawa", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findSzczecinDepartment(){
    Query query = entityManager.createNamedQuery("Department.findSzczecin", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findLodzDepartment(){
    Query query = entityManager.createNamedQuery("Department.findLodz", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findPoznanDepartment(){
    Query query = entityManager.createNamedQuery("Department.findPoznan", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findKrakowDepartment(){
    Query query = entityManager.createNamedQuery("Department.findKrakow", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findLublinDepartment(){
    Query query = entityManager.createNamedQuery("Department.findLublin", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
  public Department findWroclawDepartment(){
    Query query = entityManager.createNamedQuery("Department.findWroclaw", Department.class);
    List<Department> positions = query.getResultList();
    return positions.get(0);
  }
}
