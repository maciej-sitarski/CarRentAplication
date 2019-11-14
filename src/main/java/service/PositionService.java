package service;

import dao.PositionDaoBean;
import entity.Position;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PositionService {

  @EJB
  PositionDaoBean positionDaoBean;

  public Position findWorkerPosition(){
    return positionDaoBean.findWorkerPosition();
  }

  public Position findAdminPosition(){
    return positionDaoBean.findAdminPosition();
  }

  public Position findCoordinatorPosition(){
    return positionDaoBean.findCoordinatorPosition();
  }

  public Position findMenagerPosition(){
    return positionDaoBean.findMenagerPosition();
  }

}
