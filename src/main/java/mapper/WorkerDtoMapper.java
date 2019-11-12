package mapper;

import dto.WorkerDto;
import entity.Worker;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class WorkerDtoMapper {

  @EJB
  PositionDtoMapper positionDtoMapper;

  @EJB
  DepartmentDtoMapper departmentDtoMapper;

  public WorkerDto mapWorkerToDto(Worker worker) {
    WorkerDto workerDto = new WorkerDto();

    workerDto.setId(worker.getId());
    workerDto.setNameAndSurname(worker.getFullName());
    workerDto.setEmail(worker.getEmail());
    workerDto.setPesel(worker.getPesel());
    workerDto.setPhoneNumber(worker.getPhoneNumber());
    workerDto.setPassword(worker.getPassword());
    workerDto.setDepartmentDto(departmentDtoMapper.mapDepartmentToDto(worker.getDepartment()));
    workerDto.setPositionDto(positionDtoMapper.mapPositionToDto(worker.getPosition()));

    return workerDto;
  }
}
