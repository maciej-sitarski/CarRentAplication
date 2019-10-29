package dto;

public class ModelDto {

  private Long id;
  private String name;
  private String sectionName;
  private Long sectionPrice;

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

  public String getSectionName() {
    return sectionName;
  }

  public void setSectionName(String sectionName) {
    this.sectionName = sectionName;
  }

  public Long getSectionPrice() {
    return sectionPrice;
  }

  public void setSectionPrice(Long sectionPrice) {
    this.sectionPrice = sectionPrice;
  }
}
