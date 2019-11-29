package mapper.reverseMapper;

import dao.ModelDaoBean;
import dto.SectionDto;
import entity.Section;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SectionMapper {

  @EJB
  ModelDaoBean modelDaoBean;

  public Section mapSection(SectionDto sectionDto) {
    Section section = new Section();
    section.setName(sectionDto.getName());
    section.setPrice(sectionDto.getPrice());
    section.setId(sectionDto.getId());
    section.setModels(modelDaoBean.findModelListBySection(sectionDto.getName()));
    return section;
  }
}
