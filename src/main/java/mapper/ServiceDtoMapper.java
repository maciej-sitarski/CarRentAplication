package mapper;

import dto.ServiceDto;
import entity.Service;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServiceDtoMapper {

  @EJB
  CarDtoMapper carDtoMapper;

  public ServiceDto mapServiceToDto(Service service) {
    ServiceDto serviceDto = new ServiceDto();
    serviceDto.setId(service.getId());
    serviceDto.setFixes(service.getFixes());
    serviceDto.setMileage(service.getMileage());
    serviceDto.setCarDto(carDtoMapper.mapCarToDto(service.getCars()));
    return serviceDto;
  }
}
