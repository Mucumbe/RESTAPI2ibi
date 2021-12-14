package co.mz.domain.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mz.domain.Regiao;
import co.mz.domain.Repository.RegiaoRepository;

/**
 * @author Blandino Junior Sibone Mucumbe
 *
 */

@RestController
@RequestMapping("/regioes")
public class RegiaoController {
	
	@Autowired
	private RegiaoRepository repository;

	/* metodo reponsalve por cadastrar uma regiao*/
	@PostMapping
	public ResponseEntity<Regiao> guardar(@RequestBody Regiao regiao) {
		
		regiao=repository.save(regiao);
		return ResponseEntity.status(HttpStatus.CREATED).body(regiao);
		
	}
	
	/* metodo reponsalve por listar regioes*/
	@GetMapping
	public List<Regiao> listar(){
		List<Regiao> regiaos=repository.findAll();
		if (regiaos.isEmpty()) {
			Regiao regiao1 = new Regiao();
			regiao1.setNome("Regiao 1");
			repository.save(regiao1);
			
			Regiao regiao2 = new Regiao();
			regiao2.setNome("Regiao 2");
			repository.save(regiao2);
			
			Regiao regiao3 = new Regiao();
			regiao3.setNome("Regiao 3");
			repository.save(regiao3);
			
			Regiao regiao4 = new Regiao();
			regiao4.setNome("Regiao 4");
			repository.save(regiao4);
			System.err.println("entrou");
		}
		return repository.findAll(); 
	}
}