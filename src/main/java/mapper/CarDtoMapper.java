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
    carDto.setBrandDto(brandDtoMapper.mapBrandToDto(car.getBrand()));
    carDto.setDepartmentDto(departmentDtoMapper.mapDepartmentToDto(car.getDepartment()));
    carDto.setModelDto(modelDtoMapper.mapModelToDto(car.getModel()));

    return carDto;
  }
}
