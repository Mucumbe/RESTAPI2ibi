package co.mz.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.mz.domain.Pais;
import co.mz.domain.Regiao;
import co.mz.domain.SubRegiao;
import co.mz.domain.Repository.PaisRepository;
import co.mz.domain.Repository.RegiaoRepository;
import co.mz.domain.Repository.SubRegiaoRepository;
import co.mz.domain.exception.EntidadeNaoEncontradaException;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@Autowired
	private SubRegiaoRepository subRegiaoRepository;
	
	public Pais guardar(Pais pais) {
		long idR= pais.getRegiao().getId();
		long idSR= pais.getSubRegiao().getId();
		
		Regiao regiao= regiaoRepository.findById(idR)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("Não existe Regiao com o codigo: %d%n",idR)));
		SubRegiao subRegiao= subRegiaoRepository.findById(idSR)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(String.format("Não existe Sub-Regiao com o codigo %n%d",idSR)));
		
		pais.setRegiao(regiao);
		pais.setSubRegiao(subRegiao);
		
		return paisRepository.save(pais);
		
		
	}
}
