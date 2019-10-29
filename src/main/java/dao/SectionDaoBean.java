package dao;

import entity.Section;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SectionDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Section section) {
    entityManager.persist(section);
  }

  public Section findBrandById(Long id) {
    return entityManager.find(Section.class, id);
  }
}
