package app.dto.rq;

import app.annotation.Marker;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class UserRequestDTO {
  String name;
  String lastName;
  String secretWord;
  Long login;
}
