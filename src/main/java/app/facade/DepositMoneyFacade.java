package app.facade;

import app.dto.rq.DepositRequestDTO;
import app.dto.rq.ValueOperationRequestDTO;
import app.dto.rs.UserResponseDTO;
import app.model.DepositModel;
import app.model.UserModel;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DepositMoneyFacade extends GeneralFacade<DepositModel, DepositRequestDTO, Void> {
  private final UserService userService;
  private final UserFacade userFacade;

  public UserResponseDTO depositMoney(DepositRequestDTO depositRequestDTO){
    return userFacade.convertToDto(userService.depositMoney(convertToEntity(depositRequestDTO)));
  }
}
