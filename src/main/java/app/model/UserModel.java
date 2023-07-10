package app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Data
@SequenceGenerator(name = "custom_gen", sequenceName = "user_id_seq", allocationSize = 1)
public class UserModel extends BaseEntity{
  Long login;
  String password;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "currency_id")
  Currency currency;
}
