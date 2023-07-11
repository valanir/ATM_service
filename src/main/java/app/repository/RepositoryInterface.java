package app.repository;

import app.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryInterface<E extends BaseEntity> extends JpaRepository<E, Long> {
}