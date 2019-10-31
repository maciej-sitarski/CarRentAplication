package dto;

import java.util.Date;

public class ReservationDto {

  private Long id;
  private Date startDate;
  private Date endDate;
  private String workerNameAndSurname;
  private String workerEmail;
  private String workerPesel;
  private String workerPositionName;
  private String clientNameAndSurname;
  private String clientEmail;
  private String clientPesel;
  private String clientPhoneNumber;
  private String clientType;
  private String clientTypeDiscount;
  private String departmentCity;
  private String registrationCarNumber;
  private String brandCarName;
  private String modelCarName;
  private String sectionCarName;
  private Long sectionCarPrice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getWorkerNameAndSurname() {
    return workerNameAndSurname;
  }

  public void setWorkerNameAndSurname(String workerNameAndSurname) {
    this.workerNameAndSurname = workerNameAndSurname;
  }

  public String getWorkerEmail() {
    return workerEmail;
  }

  public void setWorkerEmail(String workerEmail) {
    this.workerEmail = workerEmail;
  }

  public String getWorkerPesel() {
    return workerPesel;
  }

  public void setWorkerPesel(String workerPesel) {
    this.workerPesel = workerPesel;
  }

  public String getWorkerPositionName() {
    return workerPositionName;
  }

  public void setWorkerPositionName(String workerPositionName) {
    this.workerPositionName = workerPositionName;
  }

  public String getClientNameAndSurname() {
    return clientNameAndSurname;
  }

  public void setClientNameAndSurname(String clientNameAndSurname) {
    this.clientNameAndSurname = clientNameAndSurname;
  }

  public String getClientEmail() {
    return clientEmail;
  }

  public void setClientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
  }

  public String getClientPesel() {
    return clientPesel;
  }

  public void setClientPesel(String clientPesel) {
    this.clientPesel = clientPesel;
  }

  public String getClientPhoneNumber() {
    return clientPhoneNumber;
  }

  public void setClientPhoneNumber(String clientPhoneNumber) {
    this.clientPhoneNumber = clientPhoneNumber;
  }

  public String getClientType() {
    return clientType;
  }

  public void setClientType(String clientType) {
    this.clientType = clientType;
  }

  public String getClientTypeDiscount() {
    return clientTypeDiscount;
  }

  public void setClientTypeDiscount(String clientTypeDiscount) {
    this.clientTypeDiscount = clientTypeDiscount;
  }

  public String getDepartmentCity() {
    return departmentCity;
  }

  public void setDepartmentCity(String departmentCity) {
    this.departmentCity = departmentCity;
  }

  public String getRegistrationCarNumber() {
    return registrationCarNumber;
  }

  public void setRegistrationCarNumber(String registrationCarNumber) {
    this.registrationCarNumber = registrationCarNumber;
  }

  public String getBrandCarName() {
    return brandCarName;
  }

  public void setBrandCarName(String brandCarName) {
    this.brandCarName = brandCarName;
  }

  public String getModelCarName() {
    return modelCarName;
  }

  public void setModelCarName(String modelCarName) {
    this.modelCarName = modelCarName;
  }

  public String getSectionCarName() {
    return sectionCarName;
  }

  public void setSectionCarName(String sectionCarName) {
    this.sectionCarName = sectionCarName;
  }

  public Long getSectionCarPrice() {
    return sectionCarPrice;
  }

  public void setSectionCarPrice(Long sectionCarPrice) {
    this.sectionCarPrice = sectionCarPrice;
  }
}
