package service;

import dao.SectionDaoBean;
import dto.SectionDto;
import entity.Section;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.SectionDtoMapper;

@Stateless
public class SectionService {

  @EJB
  SectionDaoBean sectionDaoBean;

  @EJB
  SectionDtoMapper sectionDtoMapper;

  public List<SectionDto> sectionList(){
    List<Section> sectionList = sectionDaoBean.sectionsList();
    SectionDto sectionDto;
    List<SectionDto> sectionDtoList = new ArrayList<>();
    for (Section section : sectionList) {
      sectionDto = sectionDtoMapper.mapSectionToDto(section);
      sectionDtoList.add(sectionDto);
    }
    return sectionDtoList;
  }
}
