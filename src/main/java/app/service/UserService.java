package app.service;

import app.dto.rs.UserResponseDTO;
import app.model.UserModel;
import app.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService extends GeneralService<UserModel> {
  private final UserModelRepository userModelRepository;
  public UserModel createUser(UserModel userModel){
    return userModelRepository.save(userModel);

  }
  /*
  changePin
  getCountMoney
  sendMoney
  openDeposit
  getTransactionList
  showAllValue
  convertValue

   */

}
