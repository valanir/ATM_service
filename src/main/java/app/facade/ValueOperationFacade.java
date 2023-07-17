package app.facade;

import app.dto.rq.ValueOperationRequestDTO;
import app.dto.rs.UserResponseDTO;
import app.model.ValueOperation;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class ValueOperationFacade extends GeneralFacade<ValueOperation, ValueOperationRequestDTO, Void>{
  private final UserService userService;
  private final UserFacade userFacade;

  public UserResponseDTO withdrawMoney(ValueOperationRequestDTO valueOperationRequestDTO){
    return userFacade.convertToDto(userService.withdrawMoney(convertToEntity(valueOperationRequestDTO)));
  }

  public UserResponseDTO putMoney(ValueOperationRequestDTO valueOperationRequestDTO){
    return userFacade.convertToDto(userService.putMoney(convertToEntity(valueOperationRequestDTO)));
  }
}
