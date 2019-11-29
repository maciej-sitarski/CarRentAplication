package mapper.reverseMapper;

import dao.CarDaoBean;
import dto.BrandDto;
import entity.Brand;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BrandMapper {

  @EJB
  CarDaoBean carDaoBean;

  public Brand mapBrand(BrandDto brandDto){
    Brand brand = new Brand();

    brand.setId(brandDto.getId());
    brand.setName(brandDto.getName());
    brand.setCars(carDaoBean.findCarsListByBrand(brandDto.getName()));

    return brand;
  }

}
