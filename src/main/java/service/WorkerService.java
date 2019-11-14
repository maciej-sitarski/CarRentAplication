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

  public WorkerDto findWorkerDtoByEmail(String email){
    return workerDtoMapper.mapWorkerToDto(workerDaoBean.findWorkerByEmail(email).get());
  }

  public Optional<Worker> findWorkerByEmail(String email){
    return workerDaoBean.findWorkerByEmail(email);
  }

  public List findWorkerEmailInDB(String email){
    return workerDaoBean.findWorkerEmailInDB(email);
  }

  public List findWorkerPeselInDB(String pesel){
    return workerDaoBean.findWorkerPeselInDB(pesel);
  }

  public List findWorkerNumberInDB(String number){
    return workerDaoBean.findWorkerNumberInDB(number);
  }

  public List<WorkerDto> findAllWorkersDto(){
    return workerDaoBean.findAllWorkers().stream().map(worker->workerDtoMapper.mapWorkerToDto(worker)).collect(
        Collectors.toList());
  }

  public Worker findWorkerById(Long id){
    return workerDaoBean.findWorkerById(id);
  }

  public WorkerDto findWorkerDtoById(Long id){
    return workerDtoMapper.mapWorkerToDto(workerDaoBean.findWorkerById(id));
  }

}
