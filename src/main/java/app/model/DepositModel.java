package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "deposit")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "custom_gen", sequenceName = "deposit_id_seq", allocationSize = 1)
public class DepositModel extends BaseEntity{
  @ManyToOne
  @JoinColumn(name = "login")
  private UserModel userModel;
  private Long valueSum;
  private LocalDateTime term;
}
