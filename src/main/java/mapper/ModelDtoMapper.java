package mapper;

import dto.ModelDto;
import entity.Model;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ModelDtoMapper {

  @EJB
  SectionDtoMapper sectionDtoMapper;

  public ModelDto mapModelToDto(Model model){
    ModelDto modelDto = new ModelDto();

    modelDto.setId(model.getId());
    modelDto.setName(model.getName());
    modelDto.setSectionDto(sectionDtoMapper.mapSectionToDto(model.getSection()));

    return modelDto;
  }
}
