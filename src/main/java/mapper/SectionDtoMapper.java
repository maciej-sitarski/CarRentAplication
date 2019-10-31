package mapper;

import dto.SectionDto;
import entity.Section;
import javax.ejb.Stateless;

@Stateless
public class SectionDtoMapper {

  public SectionDto mapSectionToDto(Section section){
    SectionDto sectionDto =  new SectionDto();

    sectionDto.setId(section.getId());
    sectionDto.setName(section.getName());
    sectionDto.setPrice(section.getPrice());

    return sectionDto;
  }
}
