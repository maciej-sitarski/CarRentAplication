package mapper;

import dto.BrandDto;
import entity.Brand;
import javax.ejb.Stateless;

@Stateless
public class BrandDtoMapper {

  public BrandDto mapBrandToDto(Brand brand){
    BrandDto brandDto = new BrandDto();

    brandDto.setId(brand.getId());
    brandDto.setName(brand.getName());

    return brandDto;
  }
}
