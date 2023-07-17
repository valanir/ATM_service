package app.dto.rq;

import app.annotation.Marker;
import app.enums.Values_name;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepositRequestDTO {
  @JsonView(Marker.Deposit.class)
  private long userLogin;
  @JsonView(Marker.Deposit.class)
  private Values_name valueName;
  @JsonView(Marker.Deposit.class)
  private double valueSize;
  @JsonView(Marker.Deposit.class)
  private LocalDateTime depositTime;
}
