package co.mz.domain.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>, PaisRepositoryQueres {

	//List<Pais> findAllOrderByNome();
	
	//List<Pais> findAllOrderByReserva_idAsc();
	//List<Pais> findAllOrderBySub_Reserva_idAsc();
	//List<Pais> findAllOrderByCapitalAsc();



}
