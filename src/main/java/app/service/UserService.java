package app.service;

import app.exceptions.userException.UserHasNotEnoughMoney;
import app.exceptions.userException.UserNotFoundException;
import app.model.DepositModel;
import app.model.Transaction;
import app.model.UserModel;
import app.model.ValueOperation;
import app.repository.UserModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService extends GeneralService<UserModel> {
  private final UserModelRepository userModelRepository;
  private final TransactionService transactionService;
  private final DepositService depositService;

  public UserModel createUser(UserModel userModel){
    Random random = new Random();
    userModel.setLogin(random.nextInt(90000000) + 10000000L);
    userModel.setPin((random.nextInt(90000000) + 10000000L) / 10000);
    return userModelRepository.save(userModel);
  }

  public UserModel getUser(Long login){
    return userModelRepository.getUserModelByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
  }

  public UserModel getUserValues(Long login){
    return userModelRepository.getUserModelByLogin(login).orElseThrow(() -> new UserNotFoundException(login));
  }

  public UserModel putMoney(ValueOperation valueOperation){
    //TODO: fix exception
    UserModel user = userModelRepository.getUserModelByLogin(valueOperation.getLoginUser())
                                            .orElseThrow(() -> new UserNotFoundException(valueOperation.getLoginUser()));
    switch (valueOperation.getValuesName()){
      case UAH -> user.setUah(user.getUah() + valueOperation.getValueSize());
      case USD -> user.setUsd(user.getUsd() + valueOperation.getValueSize());
      case EURO -> user.setEuro(user.getEuro() + valueOperation.getValueSize());
      case POUNDSTERLING -> user.setPoundSterling(user.getPoundSterling() + valueOperation.getValueSize());
      case YUAN -> user.setYuan(user.getYuan() + valueOperation.getValueSize());
      case ZLOTY -> user.setZloty(user.getZloty() + valueOperation.getValueSize());
      case YEN -> user.setYen(user.getYen() + valueOperation.getValueSize());
    }
    transactionService.save(new Transaction(user, "Money from bank", valueOperation.getValueSize(),
                            valueOperation.getValuesName().toString(), user));
    save(user);
    return user;
  }

  public UserModel withdrawMoney(ValueOperation valueOperation) {
    //TODO: fix exception
    UserModel user = userModelRepository.getUserModelByLogin(valueOperation.getLoginUser())
      .orElseThrow(() -> new UserNotFoundException(valueOperation.getLoginUser()));

    switch (valueOperation.getValuesName()) {
      case UAH -> {
        if (valueOperation.getValueSize() > user.getUah()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setUah(user.getUah() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case USD -> {
        if (valueOperation.getValueSize() > user.getUsd()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setUsd(user.getUsd() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case EURO -> {
        if (valueOperation.getValueSize() > user.getEuro()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setEuro(user.getEuro() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case POUNDSTERLING -> {
        if (valueOperation.getValueSize() > user.getPoundSterling()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setPoundSterling(user.getPoundSterling() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case YUAN -> {
        if (valueOperation.getValueSize() > user.getYuan()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setYuan(user.getYuan() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case ZLOTY -> {
        if (valueOperation.getValueSize() > user.getZloty()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setZloty(user.getZloty() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
      case YEN -> {
        if (valueOperation.getValueSize() > user.getYen()) new UserHasNotEnoughMoney(user.getLogin());
        else {
          user.setYen(user.getYen() - valueOperation.getValueSize());
          transactionService.save(new Transaction(user, "Cash withdrawal", valueOperation.getValueSize(),
            valueOperation.getValuesName().toString(), user));
        }
      }
    }
    save(user);
    return user;
  }

  public UserModel depositMoney(DepositModel depositMoney){
    UserModel user = userModelRepository.getUserModelByLogin(depositMoney.getLoginUser())
      .orElseThrow(() -> new UserNotFoundException(depositMoney.getLoginUser()));
    depositService.save(new DepositModel(user, depositMoney.getValuesName(), depositMoney.getValueSize(), depositMoney.));
    return user;
  }

  @Transactional
  public String deleteUser(Long login){
    UserModel userModel = getUser(login);
    userModelRepository.delete(userModel);
    return "User " + login + " has been remove";
  }
  /*
  changePin
  getCountMoney
  sendMoney
  openDeposit
  getTransactionList
  showAllValue
  convertValue

   */

}
