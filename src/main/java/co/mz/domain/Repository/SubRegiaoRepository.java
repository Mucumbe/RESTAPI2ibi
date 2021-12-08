package co.mz.domain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.domain.SubRegiao;

@Repository
public interface SubRegiaoRepository extends JpaRepository<SubRegiao, Long> {

}
