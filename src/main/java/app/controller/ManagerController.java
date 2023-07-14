package app.controller;

import app.annotation.Marker;
import app.dto.rq.UserRequestDTO;
import app.dto.rq.ValueOperationRequestDTO;
import app.dto.rs.UserResponseDTO;
import app.facade.UserFacade;
import app.facade.ValueOperationFacade;
import app.model.UserModel;
import app.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerController {
  private final UserFacade userFacade;
  private final ValueOperationFacade valueOperationFacade;

  //http://localhost:8080/swagger-ui/index.html#/

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonView({Marker.Basic.class})
  //@ApiOperation("Create user")
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody @JsonView(Marker.New.class) @Valid UserRequestDTO signUpDTO){
    return ResponseEntity.ok(userFacade.createUser(signUpDTO));
  }


  @GetMapping("{login}")
  @JsonView({Marker.Basic.class})
  public ResponseEntity<UserResponseDTO> getUser(@PathVariable(name = "login") @Positive Long login){
    return ResponseEntity.ok(userFacade.getUser(login));
  }

  @DeleteMapping("{login}/delete")
  public ResponseEntity deleteUser(@PathVariable(name = "login") @Positive Long login) {
    return ResponseEntity.ok(userFacade.deleteUser(login));
  }

  @JsonView({Marker.Details.class})
  @GetMapping("{login}/all_value")
  public ResponseEntity<UserResponseDTO> getAllValues(@PathVariable(name = "login") @Positive Long login){
    return ResponseEntity.ok(userFacade.getUserValues(login));
  }

  @PostMapping("withdraw")
  ResponseEntity<UserResponseDTO> withdrawMoney(@RequestBody @JsonView(Marker.Value.class) @Valid ValueOperationRequestDTO valueOperationRequestDTO){
    return ResponseEntity.ok(valueOperationFacade.withdrawMoney(valueOperationRequestDTO));
  }

  @PostMapping("put_money")
  ResponseEntity<UserResponseDTO> putMoney(@RequestBody @JsonView(Marker.Value.class) @Valid ValueOperationRequestDTO valueOperationRequestDTO){
    return ResponseEntity.ok(valueOperationFacade.putMoney(valueOperationRequestDTO));
  }

  //putMoney

  /*
  setValue
  openDeposit
  getTransactionList
  showAllValue
   */
}
