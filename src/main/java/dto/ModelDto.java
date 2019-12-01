package dto;

import java.util.Objects;

public class ModelDto {

  private Long id;
  private String name;
  private SectionDto sectionDto;

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

  public SectionDto getSectionDto() {
    return sectionDto;
  }

  public void setSectionDto(SectionDto sectionDto) {
    this.sectionDto = sectionDto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ModelDto)) {
      return false;
    }
    ModelDto modelDto = (ModelDto) o;
    return Objects.equals(getId(), modelDto.getId()) &&
        Objects.equals(getName(), modelDto.getName()) &&
        Objects.equals(getSectionDto(), modelDto.getSectionDto());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSectionDto());
  }
}
