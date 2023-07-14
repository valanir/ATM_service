package app.model;

import app.annotation.Marker;
import app.enums.Values_name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ValueOperation extends BaseEntity {
  private Long loginUser;
  private Values_name valuesName;
  private Double valueSize;
}
