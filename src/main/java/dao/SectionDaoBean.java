package dao;

import entity.Section;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SectionDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveSection(Section section) {
    entityManager.persist(section);
  }

  public Section findBrandById(Long id) {
    return entityManager.find(Section.class, id);
  }

  public List<Section> sectionsList() {
    Query query = entityManager.createNamedQuery("Section.findAll", Section.class);
    return query.getResultList();
  }
}
