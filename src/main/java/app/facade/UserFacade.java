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
}
