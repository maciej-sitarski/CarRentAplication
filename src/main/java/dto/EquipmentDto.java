package dto;

public class EquipmentDto {

  private Long id;
  private Boolean isNavigation;
  private Boolean isInsurance;
  private Long numberOfBabyCarrier;
  private Long numberOfChildSeat;
  private Long numberOfPad;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
