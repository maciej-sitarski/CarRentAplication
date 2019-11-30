package dto;

import java.util.Date;

public class ReservationDto {

  private Long id;
  private String startDate;
  private String endDate;
  private String startHour;
  private String endHour;
  private Long price;
  private ClientDto clientDto;
  private WorkerDto workerDto;
  private CarDto carDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public ClientDto getClientDto() {
    return clientDto;
  }

  public void setClientDto(ClientDto clientDto) {
    this.clientDto = clientDto;
  }

  public WorkerDto getWorkerDto() {
    return workerDto;
  }

  public void setWorkerDto(WorkerDto workerDto) {
    this.workerDto = workerDto;
  }

  public CarDto getCarDto() {
    return carDto;
  }

  public void setCarDto(CarDto carDto) {
    this.carDto = carDto;
  }

  public String getStartHour() {
    return startHour;
  }

  public void setStartHour(String startHour) {
    this.startHour = startHour;
  }

  public String getEndHour() {
    return endHour;
  }

  public void setEndHour(String endHour) {
    this.endHour = endHour;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }
}
