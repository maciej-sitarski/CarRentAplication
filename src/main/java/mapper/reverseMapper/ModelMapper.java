package mapper.reverseMapper;

import dao.CarDaoBean;
import dto.ModelDto;
import entity.Model;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ModelMapper {

  @EJB
  SectionMapper sectionMapper;

  @EJB
  CarDaoBean carDaoBean;

  public Model mapModel(ModelDto modelDto){
    Model model = new Model();

    model.setId(modelDto.getId());
    model.setName(modelDto.getName());
    model.setSection(sectionMapper.mapSection(modelDto.getSectionDto()));
    model.setCars(carDaoBean.findCarsListByModel(modelDto.getName()));

    return model;
  }

}
