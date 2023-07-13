package app.dto.rs;

import app.annotation.Marker;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserResponseDTO {
  @JsonView({Marker.Basic.class, Marker.Details.class})
  private Long login;
  @JsonView({Marker.Basic.class})
  private String name;
  @JsonView({Marker.Basic.class})
  private String lastName;
  @JsonView({Marker.Basic.class})
  private String secretWord;
  @JsonView({Marker.Basic.class, Marker.Details.class})
  private Double uah;
  @JsonView({Marker.Details.class})
  Double usd;
  @JsonView({Marker.Details.class})
  Double euro;
  @JsonView({Marker.Details.class})
  Double poundSterling;
  @JsonView({Marker.Details.class})
  Double yuan;
  @JsonView({Marker.Details.class})
  Double zloty;
  @JsonView({Marker.Details.class})
  Double yen;
}
