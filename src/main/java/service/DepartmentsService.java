package service;

import dao.DepartmentDaoBean;
import dto.DepartmentDto;
import entity.Department;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.DepartmentDtoMapper;

@Stateless
public class DepartmentsService {

  @EJB
  DepartmentDaoBean departmentDaoBean;

  @EJB
  DepartmentDtoMapper departmentDtoMapper;

  public List<DepartmentDto> findListOfDepartmentsDto() {
    List<Department> departments = departmentDaoBean.findAllDepartments().stream().sorted(
        Comparator.comparing(Department::getCity)).collect(Collectors.toList());
    return departments.stream()
        .map(department -> departmentDtoMapper.mapDepartmentToDto(department)).collect(
            Collectors.toList());
  }
}
