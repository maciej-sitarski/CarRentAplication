package dto;

public class ServiceDto {
  private Long id;
  private Long mileage;
  private String fixes;
  private CarDto carDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMileage() {
    return mileage;
  }

  public void setMileage(Long mileage) {
    this.mileage = mileage;
  }

  public String getFixes() {
    return fixes;
  }

  public void setFixes(String fixes) {
    this.fixes = fixes;
  }

  public CarDto getCarDto() {
    return carDto;
  }

  public void setCarDto(CarDto carDto) {
    this.carDto = carDto;
  }
}
