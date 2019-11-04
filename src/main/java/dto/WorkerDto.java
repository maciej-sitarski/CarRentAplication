package dto;

public class WorkerDto {

  private Long id;
  private String nameAndSurname;
  private String email;
  private String pesel;
  private DepartmentDto departmentDto;
  private PositionDto positionDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameAndSurname() {
    return nameAndSurname;
  }

  public void setNameAndSurname(String nameAndSurname) {
    this.nameAndSurname = nameAndSurname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  public DepartmentDto getDepartmentDto() {
    return departmentDto;
  }

  public void setDepartmentDto(DepartmentDto departmentDto) {
    this.departmentDto = departmentDto;
  }

  public PositionDto getPositionDto() {
    return positionDto;
  }

  public void setPositionDto(PositionDto positionDto) {
    this.positionDto = positionDto;
  }
}
