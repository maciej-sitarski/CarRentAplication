package service;

import dao.WorkerDaoBean;
import entity.Worker;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class WorkerService {

  @EJB
  WorkerDaoBean workerDaoBean;

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

}
