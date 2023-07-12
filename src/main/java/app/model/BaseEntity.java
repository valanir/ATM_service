package app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_gen")
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Long id;

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();
}
