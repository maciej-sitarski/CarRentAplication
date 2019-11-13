package service;

import dao.CarDaoBean;
import dto.CarDto;
import entity.Car;
import filterDate.FilterDistinctByKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.CarDtoMapper;

@Stateless
public class CarService {

  @EJB
  CarDaoBean carDaoBean;

  @EJB
  CarDtoMapper carDtoMapper;

  public List<CarDto> carList() {
    List<Car> carsDao = carDaoBean.findCarsList();
    List<CarDto> carsDto = new ArrayList<>();
    CarDto car;
    for (Car value : carsDao) {
      car = carDtoMapper.mapCarToDto(value);
      carsDto.add(car);
    }
    return carsDto;
  }

  public List<CarDto> uniqueCarsList() {
    return carList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }
}

