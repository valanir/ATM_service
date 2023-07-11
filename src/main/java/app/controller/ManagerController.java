package app.controller;

import app.model.UserModel;
import app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerController {
  private final UserService userService;

  @PostMapping("/create")
  //@ApiOperation("Create user")
  public UserModel createUser(){
    return userService.createUser();
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
