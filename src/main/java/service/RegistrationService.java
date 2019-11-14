package service;

import entity.Client;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegistrationService {

  @EJB
  ClientService clientService;

  @EJB
  WorkerService workerService;


  public boolean isClientEmailInDataBase (String email){
    List emails= clientService.findClientEmailInDB(email);
    if(!emails.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isClientPeselInDataBase (String pesel){
    List pesels = clientService.findClientPeselInDB(pesel);
    if(!pesels.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isClientNumberInDataBase (String number){
    List numbers = clientService.findClientNumberInDB(number);
    if(!numbers.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isWorkerEmailInDataBase (String email){
    List emails= workerService.findWorkerEmailInDB(email);
    if(!emails.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isWorkerPeselInDataBase (String pesel){
    List pesels = workerService.findWorkerPeselInDB(pesel);
    if(!pesels.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean isWorkerNumberInDataBase (String number){
    List numbers = workerService.findWorkerNumberInDB(number);
    if(!numbers.isEmpty()) {
      return true;
    }
    return false;
  }

}
