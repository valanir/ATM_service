package app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/operations")
public class UserController {
  /*
  getCountMoney
  sendMoney
  openDeposit
  getTransactionList
  showAllValue
  convertValue

   */
}
