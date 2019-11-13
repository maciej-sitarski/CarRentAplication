package service;

import dao.ClientTypeDaoBean;
import entity.ClientType;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClientTypeService {

  @EJB
  ClientTypeDaoBean clientTypeDaoBean;

  public ClientType findClientTypeById(Long id){
    return clientTypeDaoBean.findClientTypeById(id);
  }


}
