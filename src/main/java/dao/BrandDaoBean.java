package dao;

import entity.Brand;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrandDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Brand brand) {
    entityManager.persist(brand);
  }

  public Brand findBrandById(Long id) {
    return entityManager.find(Brand.class, id);
  }
}
