package co.mz.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>,PaisRepositoryQueres {

}
