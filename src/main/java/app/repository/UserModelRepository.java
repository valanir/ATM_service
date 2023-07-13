package app.repository;

import app.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserModelRepository extends RepositoryInterface<UserModel>{
  Optional<UserModel> getUserModelByLogin(Long login);
    /*
  getCountMoney
  sendMoney
  openDeposit
  getTransactionList
  showAllValue
  convertValue

   */

}
