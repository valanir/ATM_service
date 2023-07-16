package app.exceptions.userException;

import app.exceptions.BadRequestException;

public class UserHasNotEnoughMoney extends BadRequestException {
  public UserHasNotEnoughMoney(Long login) { super("User: " + login + " has not enough money");
  }
}