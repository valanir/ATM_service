package app.service;

import app.dto.rs.UserResponseDTO;
import app.exceptions.userException.UserNotFoundException;
import app.model.UserModel;
import app.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService extends GeneralService<UserModel> {
  private final UserModelRepository userModelRepository;
  public UserModel createUser(UserModel userModel){
    Random random = new Random();
    userModel.setLogin(random.nextInt(90000000) + 10000000L);
    return userModelRepository.save(userModel);
  }

  public UserModel getUser(Long login){
    return userModelRepository.getUserModelByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
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
