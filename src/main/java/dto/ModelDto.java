package dto;

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
}
