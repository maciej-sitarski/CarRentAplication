package dto;

import java.util.Objects;

public class DepartmentDto {

  private Long id;
  private String city;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DepartmentDto)) {
      return false;
    }
    DepartmentDto that = (DepartmentDto) o;
    return Objects.equals(getId(), that.getId()) &&
        Objects.equals(getCity(), that.getCity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getCity());
  }
}
