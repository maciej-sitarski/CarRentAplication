package dto;

import java.util.Objects;

public class SectionDto {

  private Long id;
  private String name;
  private Long price;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SectionDto)) {
      return false;
    }
    SectionDto that = (SectionDto) o;
    return Objects.equals(getId(), that.getId()) &&
        Objects.equals(getName(), that.getName()) &&
        Objects.equals(getPrice(), that.getPrice());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getPrice());
  }
}
