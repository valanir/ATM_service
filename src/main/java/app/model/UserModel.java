package app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Data
@Accessors(chain = true)
@SequenceGenerator(name = "custom_gen", sequenceName = "user_id_seq", allocationSize = 1)
public class UserModel extends BaseEntity{
  Long login;
  String password;
  String secretWord;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "currency_id")
  Currency currency;
}
