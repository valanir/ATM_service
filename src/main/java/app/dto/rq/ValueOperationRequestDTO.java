package app.dto.rq;

import app.annotation.Marker;
import app.enums.Values_name;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class ValueOperationRequestDTO {
  @JsonView(Marker.Value.class)
  private long userLogin;
  @JsonView(Marker.Value.class)
  private Values_name valueName;
  @JsonView(Marker.Value.class)
  private double valueSize;
}

