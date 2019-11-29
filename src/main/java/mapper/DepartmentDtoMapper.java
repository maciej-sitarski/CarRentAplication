package mapper;

import dto.DepartmentDto;
import entity.Department;
import javax.ejb.Stateless;

@Stateless
public class DepartmentDtoMapper {

  public DepartmentDto mapDepartmentToDto(Department department) {
    DepartmentDto departmentDto = new DepartmentDto();
    departmentDto.setId(department.getId());
    departmentDto.setCity(department.getCity());
    return departmentDto;
  }
}
