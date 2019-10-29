package dto;

import java.util.Date;

public class ReservationDto {

  private Long id;
  private Date startDate;
  private Date endDate;
  private String workerName;
  private String workerSurname;
  private String workerEmail;
  private String workerPesel;
  private String workerPositionName;
  private String clientName;
  private String clientSurname;
  private String clientEmail;
  private String clientPesel;
  private String clientPhoneNumber;
  private Long clientReservationNumber;
  private String departmentCity;
  private Boolean isNavigation;
  private Boolean isInsurance;
  private Long numberOfBabyCarrier;
  private Long numberOfChildSeat;
  private Long numberOfPad;
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

  public String getWorkerName() {
    return workerName;
  }

  public void setWorkerName(String workerName) {
    this.workerName = workerName;
  }

  public String getWorkerSurname() {
    return workerSurname;
  }

  public void setWorkerSurname(String workerSurname) {
    this.workerSurname = workerSurname;
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

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientSurname() {
    return clientSurname;
  }

  public void setClientSurname(String clientSurname) {
    this.clientSurname = clientSurname;
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

  public Long getClientReservationNumber() {
    return clientReservationNumber;
  }

  public void setClientReservationNumber(Long clientReservationNumber) {
    this.clientReservationNumber = clientReservationNumber;
  }

  public String getDepartmentCity() {
    return departmentCity;
  }

  public void setDepartmentCity(String departmentCity) {
    this.departmentCity = departmentCity;
  }

  public Boolean getNavigation() {
    return isNavigation;
  }

  public void setNavigation(Boolean navigation) {
    isNavigation = navigation;
  }

  public Boolean getInsurance() {
    return isInsurance;
  }

  public void setInsurance(Boolean insurance) {
    isInsurance = insurance;
  }

  public Long getNumberOfBabyCarrier() {
    return numberOfBabyCarrier;
  }

  public void setNumberOfBabyCarrier(Long numberOfBabyCarrier) {
    this.numberOfBabyCarrier = numberOfBabyCarrier;
  }

  public Long getNumberOfChildSeat() {
    return numberOfChildSeat;
  }

  public void setNumberOfChildSeat(Long numberOfChildSeat) {
    this.numberOfChildSeat = numberOfChildSeat;
  }

  public Long getNumberOfPad() {
    return numberOfPad;
  }

  public void setNumberOfPad(Long numberOfPad) {
    this.numberOfPad = numberOfPad;
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
