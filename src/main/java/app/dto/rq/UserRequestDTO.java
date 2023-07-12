package app.dto.rq;

import app.annotation.Marker;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserRequestDTO {
  @JsonView({Marker.New.class})
  String name;
  @JsonView({Marker.New.class})
  String lastName;
  @JsonView({Marker.New.class})
  String secretWord;
}
