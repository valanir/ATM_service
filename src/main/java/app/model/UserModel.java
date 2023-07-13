package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "custom_gen", sequenceName = "users_id_seq", allocationSize = 1)
public class UserModel extends BaseEntity {
  private String name;
  private String lastName;

  @GeneratedValue
  private Long login;

  private String secretWord;
  private String pin;
  private Double uah = 0d;
  private Double Usd = 0d;
  private Double Euro = 0d;
  private Double PoundSterling = 0d;
  private Double Yuan = 0d;
  private Double Zloty = 0d;
  private Double Yen = 0d;
}
