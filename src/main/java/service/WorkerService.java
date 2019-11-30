package service;

import dao.WorkerDaoBean;
import dto.WorkerDto;
import entity.Worker;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.WorkerDtoMapper;

@Stateless
public class WorkerService {

  @EJB
  WorkerDaoBean workerDaoBean;

  @EJB
  WorkerDtoMapper workerDtoMapper;

  public Optional<Worker> findWorkerByEmail(String email) {
    return workerDaoBean.findWorkerByEmail(email);
  }

  public List findWorkerEmailInDB(String email) {
    return workerDaoBean.findWorkerEmailInDB(email);
  }

  public List findWorkerPeselInDB(String pesel) {
    return workerDaoBean.findWorkerPeselInDB(pesel);
  }

  public List findWorkerNumberInDB(String number) {
    return workerDaoBean.findWorkerNumberInDB(number);
  }

  public List<WorkerDto> findAllWorkersDto() {
    return workerDaoBean.findAllWorkers().stream()
        .map(worker -> workerDtoMapper.mapWorkerToDto(worker)).collect(
            Collectors.toList());
  }

  public WorkerDto findWorkerDtoById(Long id) {
    return workerDtoMapper.mapWorkerToDto(workerDaoBean.findWorkerById(id));
  }

  public List<WorkerDto> findListOfWorkersDtoFromDepartment(String city) {
    List<WorkerDto> WorkerDtoList = workerDaoBean.findWorkersByDepartment(city).stream()
        .map(worker -> workerDtoMapper.mapWorkerToDto(worker)).collect(
            Collectors.toList());
    return WorkerDtoList;
  }

}
