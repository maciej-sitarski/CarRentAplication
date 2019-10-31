package dto;

public class CarDto {

  private Long id;
  private String registrationNumber;
  private String brandName;
  private String modelName;
  private String sectionName;
  private Long sectionPrice;
  private String departmentCity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public Long getSectionPrice() {
    return sectionPrice;
  }

  public void setSectionPrice(Long sectionPrice) {
    this.sectionPrice = sectionPrice;
  }

  public String getDepartmentCity() {
    return departmentCity;
  }

  public void setDepartmentCity(String departmentCity) {
    this.departmentCity = departmentCity;
  }
}
