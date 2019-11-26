package mapper.reverseMapper;

import dao.CarDaoBean;
import dao.WorkerDaoBean;
import dto.DepartmentDto;
import entity.Department;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DepartmentMapper {

  @EJB
  CarDaoBean carDaoBean;

  @EJB
  WorkerDaoBean workerDaoBean;

  public Department mapDepartment(DepartmentDto departmentDto){
    Department department = new Department();

    department.setCity(departmentDto.getCity());
    department.setId(departmentDto.getId());
    department.setCars(carDaoBean.findCarsListByDepartment(departmentDto.getCity()));
    department.setWorkers(workerDaoBean.findWorkersByDepartment(departmentDto.getCity()));
    return department;
  }

}
