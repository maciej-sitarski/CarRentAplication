package dto;

import java.util.Date;

public class ReservationEquipmentDto {

  private Long id;
  private Long number;
  private ReservationDto reservationDto;
  private EquipmentDto equipmentDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public ReservationDto getReservationDto() {
    return reservationDto;
  }

  public void setReservationDto(ReservationDto reservationDto) {
    this.reservationDto = reservationDto;
  }

  public EquipmentDto getEquipmentDto() {
    return equipmentDto;
  }

  public void setEquipmentDto(EquipmentDto equipmentDto) {
    this.equipmentDto = equipmentDto;
  }
}
