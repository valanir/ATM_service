package app.facade;

import app.dto.rq.UserRequestDTO;
import app.dto.rs.UserResponseDTO;
import app.model.UserModel;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Log4j2
@Component
@RequiredArgsConstructor
public class UserFacade extends GeneralFacade<UserModel, UserRequestDTO, UserResponseDTO>{

  private final UserService userService;



  public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
    return convertToDto(userService.createUser(convertToEntity(userRequestDTO)));
  }

  public UserResponseDTO getUser(Long login){
    return convertToDto(userService.getUser(login));
  }

  public UserResponseDTO getUserValues(Long login){
    return convertToDto(userService.getUserValues(login));
  }

  public UserResponseDTO withdrawMoney(UserRequestDTO userRequestDTO){
    System.out.println(mapToEntity(userRequestDTO, new UserModel()));
    return convertToDto(userService.withdrawMoney(mapToEntity(userRequestDTO, new UserModel())));
  }

  public String deleteUser(Long login){
    return userService.deleteUser(login);
  }
}
