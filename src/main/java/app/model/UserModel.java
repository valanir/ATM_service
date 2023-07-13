package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "custom_gen", sequenceName = "users_id_seq", allocationSize = 1)
public class UserModel extends BaseEntity {
  private String name;
  private String lastName;

  @Column(unique=true)
  private Long login;

  @OneToMany(mappedBy = "userTransfer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<Transaction> transactions;

  @OneToMany(mappedBy = "userModel", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Set<DepositModel> depositModels;

  private String secretWord;
  private String pin;
  private Double uah = 0d;
  private Double usd = 0d;
  private Double euro = 0d;
  private Double poundSterling = 0d;
  private Double yuan = 0d;
  private Double zloty = 0d;
  private Double yen = 0d;
}
