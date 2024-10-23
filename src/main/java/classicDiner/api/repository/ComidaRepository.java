package classicDiner.api.repository;

import classicDiner.api.model.Comida;
import jakarta.persistence.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
    Page<Comida> findAllByAtivoTrue(Pageable paginacao);
}
