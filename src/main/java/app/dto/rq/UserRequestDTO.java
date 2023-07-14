package app.dto.rq;

import app.annotation.Marker;
import app.enums.Values_name;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserRequestDTO {
  @JsonView({Marker.New.class})
  private String name;
  @JsonView({Marker.New.class})
  private String lastName;
  @JsonView({Marker.New.class})
  private String secretWord;
/*  @JsonView({Marker.Value.class})
  private Values_name valuesName;*/
  @JsonView({Marker.Value.class})
  private Long login;

  @JsonView({Marker.Value.class})
  private Double uah;
  @JsonView({Marker.Value.class})
  Double usd;
  @JsonView({Marker.Value.class})
  Double euro;
  @JsonView({Marker.Value.class})
  Double poundSterling;
  @JsonView({Marker.Value.class})
  Double yuan;
  @JsonView({Marker.Value.class})
  Double zloty;
  @JsonView({Marker.Value.class})
  Double yen;
}
