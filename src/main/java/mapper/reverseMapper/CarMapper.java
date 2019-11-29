package mapper.reverseMapper;

import dao.ReservationDaoBean;
import dto.CarDto;
import entity.Car;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarMapper {

  @EJB
  ReservationDaoBean reservationDaoBean;

  @EJB
  BrandMapper brandMapper;

  @EJB
  ModelMapper modelMapper;

  @EJB
  DepartmentMapper departmentMapper;

  public Car mapCar(CarDto carDto){
    Car car = new Car();

    car.setId(carDto.getId());
    car.setRegistrationNumber(null);
    car.setReservations(reservationDaoBean.findReservationsByCars(carDto.getId()));
    car.setBrand(brandMapper.mapBrand(carDto.getBrandDto()));
    car.setModel(modelMapper.mapModel(carDto.getModelDto()));
    car.setDepartment(departmentMapper.mapDepartment(carDto.getDepartmentDto()));
    return car;
  }

}
