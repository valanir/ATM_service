package app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "Curency")
@NoArgsConstructor
@Data
@Accessors(chain = true)
@SequenceGenerator(name = "custom_gen", sequenceName = "currency_id_seq", allocationSize = 1)
public class Currency extends BaseEntity{
  Double Uah;
  Double Usd;
  Double Euro;
  Double PoundSterling;
  Double Yuan;
  Double Zloty;
  Double Yen;
}
