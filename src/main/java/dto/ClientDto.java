package dto;

public class ClientDto {

  private Long id;
  private String fullName;
  private String email;
  private String pesel;
  private String phoneNumber;
  private String password;
  private ClientTypeDto clientTypeDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public ClientTypeDto getClientTypeDto() {
    return clientTypeDto;
  }

  public void setClientTypeDto(ClientTypeDto clientTypeDto) {
    this.clientTypeDto = clientTypeDto;
  }
}
