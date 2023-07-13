package app.controller;

import app.annotation.Marker;
import app.dto.rq.UserRequestDTO;
import app.dto.rs.UserResponseDTO;
import app.facade.UserFacade;
import app.model.UserModel;
import app.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Log4j2
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerController {
  private final UserFacade userFacade;

  @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  //@ApiOperation("Create user")
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody @JsonView(Marker.New.class) @Valid UserRequestDTO signUpDTO){
    return ResponseEntity.ok(userFacade.createUser(signUpDTO));
  }

  @GetMapping("{login}")
  public ResponseEntity<UserResponseDTO> getUser(@PathVariable(name = "login") @Positive Long login){
    return ResponseEntity.ok(userFacade.getUser(login));
  }

  /*
  createUser
  deleteUser
  setValue
  openDeposit
  getTransactionList
  showAllValue
   */
}
