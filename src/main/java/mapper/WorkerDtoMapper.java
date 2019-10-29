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
    workerDto.setName(worker.getName());
    workerDto.setSurname(worker.getSurname());
    workerDto.setEmail(worker.getEmail());
    workerDto.setPesel(worker.getPesel());
    workerDto.setPositionName(positionDtoMapper.mapPositionToDto(worker.getPosition()).getName());
    workerDto.setDepartmentCity(
        departmentDtoMapper.mapDepartmentToDto(worker.getDepartment()).getCity());

    return workerDto;
  }
}
