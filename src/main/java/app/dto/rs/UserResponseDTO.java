package app.dto.rs;

import app.annotation.Marker;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserResponseDTO {
  @JsonView({Marker.Details.class})
  private Long login;
  @JsonView({Marker.Details.class})
  private String name;
  @JsonView({Marker.Details.class})
  private String lastName;
  @JsonView({Marker.Details.class})
  private String secretWord;
  @JsonView({Marker.Details.class})
  private Double uah;
/*  Double Uah;
  Double Usd;
  Double Euro;
  Double PoundSterling;
  Double Yuan;
  Double Zloty;
  Double Yen;*/
}
