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
    List<CarDto> carList = carList();
    return carList.stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }

  public List<CarDto> aCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("a")).collect(
            Collectors.toList());
  }

  public List<CarDto> uniqueACarsList() {
    return aCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }

  public List<CarDto> bCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("b")).collect(
            Collectors.toList());
  }

  public List<CarDto> uniqueBCarsList() {
    return bCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName())).collect(
            Collectors.toList());
  }

  public List<CarDto> cCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("c")).collect(
            Collectors.toList());
  }

  public List<CarDto> uniqueCCarsList() {
    return cCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName()))
        .collect(Collectors.toList());
  }

  public List<CarDto> dCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("d")).collect(
            Collectors.toList());
  }

  public List<CarDto> uniqueDCarsList() {
    return dCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName()))
        .collect(Collectors.toList());
  }

  public List<CarDto> suvCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("suv")).collect(
            Collectors.toList());
  }

  public List<CarDto> uniqueSuvCarsList() {
    return suvCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName()))
        .collect(Collectors.toList());
  }

  public List<CarDto> sevenPersonCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("7os")).collect(
            Collectors.toList());
  }

  public List<CarDto> unique7osCarsList() {
    return sevenPersonCarsList().stream()
        .filter(FilterDistinctByKey.distinctByKey(p -> p.getModelDto().getName()))
        .collect(Collectors.toList());
  }

  public List<CarDto> BusCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("bus")).collect(
            Collectors.toList());
  }

  public List<CarDto> sevenPersonCarsList() {
    return carList().stream()
        .filter(x -> x.getModelDto().getSectionDto().getName().equalsIgnoreCase("7os")).collect(
            Collectors.toList());
  }


}

