package mapper;

import dto.CarDto;
import entity.Car;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarDtoMapper {

  @EJB
  DepartmentDtoMapper departmentDtoMapper;

  @EJB
  BrandDtoMapper brandDtoMapper;

  @EJB
  ModelDtoMapper modelDtoMapper;

  public CarDto mapCarToDto(Car car){
    CarDto carDto = new CarDto();

    carDto.setId(car.getId());
    carDto.setRegistrationNumber(car.getRegistrationNumber());
    carDto.setBrandName(brandDtoMapper.mapBrandToDto(car.getBrand()).getName());
    carDto.setDepartmentCity(departmentDtoMapper.mapDepartmentToDto(car.getDepartment()).getCity());
    carDto.setModelName(modelDtoMapper.mapModelToDto(car.getModel()).getName());
    carDto.setSectionName(modelDtoMapper.mapModelToDto(car.getModel()).getSectionName());
    carDto.setSectionPrice(modelDtoMapper.mapModelToDto(car.getModel()).getSectionPrice());

    return carDto;
  }
}
