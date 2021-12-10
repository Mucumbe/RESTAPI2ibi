package co.mz.domain.Repository;

import java.util.List;

import co.mz.domain.Pais;

public interface PaisRepositoryQueres {

	List<Pais> find(String nome,String capital,String regiao,String subRegiao);
}
