package app.exceptions.userException;

import app.exceptions.BadRequestException;

public class UserNotFoundException extends BadRequestException {
  public UserNotFoundException(Long login) {
    super("User with login: " + login + " not found");
  }
}
