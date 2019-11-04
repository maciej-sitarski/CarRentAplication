package dto;

import java.util.Date;

public class ReservationDto {

  private Long id;
  private Date startDate;
  private Date endDate;
  private ClientDto clientDto;
  private WorkerDto workerDto;
  private CarDto carDto;

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
}
