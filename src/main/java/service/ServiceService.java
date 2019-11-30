package service;

import dao.ServiceDaoBean;
import dto.ServiceDto;
import entity.Service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.ServiceDtoMapper;

@Stateless
public class ServiceService {

  @EJB
  ServiceDaoBean serviceDaoBean;

  @EJB
  ServiceDtoMapper serviceDtoMapper;

  public List<ServiceDto> findServiceByCarId(Long id){
    List<Service> serviceList = serviceDaoBean.findServiceByCarId(id);
    List<ServiceDto> serviceDtoList = new ArrayList<>();
    for (Service service : serviceList) {
      serviceDtoList.add(serviceDtoMapper.mapServiceToDto(service));
    }
    return serviceDtoList;
    }


}
