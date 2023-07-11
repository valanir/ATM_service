package app.service;

import app.model.UserModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.UserDatabase;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService extends GeneralService<UserModel> {
  public UserModel createUser(){
    return new UserModel();
  }
  /*
  getCountMoney
  sendMoney
  openDeposit
  getTransactionList
  showAllValue
  convertValue

   */

}
