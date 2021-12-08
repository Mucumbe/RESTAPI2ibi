package co.mz.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.domain.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

}
