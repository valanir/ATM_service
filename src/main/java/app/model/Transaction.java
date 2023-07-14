package app.model;

import app.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "custom_gen", sequenceName = "users_id_seq", allocationSize = 1)
public class Transaction extends BaseEntity{

  @ManyToOne
  @JoinColumn(name = "login")
  private UserModel userTransfer;

  private String transactionName;
  private Long userReceiveId;

}
