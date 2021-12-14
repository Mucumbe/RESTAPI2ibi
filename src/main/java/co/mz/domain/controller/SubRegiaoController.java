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

import co.mz.domain.SubRegiao;
import co.mz.domain.Repository.SubRegiaoRepository;

@RestController
@RequestMapping("/subregioes")
public class SubRegiaoController {

	/**
	 * @author Blandino Junior Sibone Mucumbe
	 *
	 */
	@Autowired
	private SubRegiaoRepository repository;

	/* metodo reponsalve por cadastrar uma Subregiao*/
	@PostMapping
	public ResponseEntity<SubRegiao> guardar(@RequestBody SubRegiao subRegiao) {

		subRegiao = repository.save(subRegiao);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	/* metodo reponsalve por listar regioes*/
	@GetMapping
	public List<SubRegiao> listar() {
		List<SubRegiao> subRegiaos = repository.findAll();
		
		if (subRegiaos.isEmpty()) {
			SubRegiao subRegiao1 = new SubRegiao();
			subRegiao1.setNome("SubRegiao 1");
			repository.save(subRegiao1);

			SubRegiao subRegiao2 = new SubRegiao();
			subRegiao2.setNome("SubRegiao 2");
			repository.save(subRegiao2);

			SubRegiao subRegiao3 = new SubRegiao();
			subRegiao3.setNome("SubRegiao 3");
			repository.save(subRegiao3);

			SubRegiao subRegiao4 = new SubRegiao();
			subRegiao4.setNome("SubRegiao 4");
			repository.save(subRegiao4);
		}
		return repository.findAll();
	}
}
