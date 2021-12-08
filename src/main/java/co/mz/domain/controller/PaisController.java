package co.mz.domain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mz.domain.Pais;
import co.mz.domain.Repository.PaisRepository;
import co.mz.domain.exception.EntidadeNaoEncontradaException;
import co.mz.domain.service.PaisService;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository repository;
	@Autowired
	private PaisService service;

	@GetMapping
	private List<Pais> listar() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pais> listarId(@PathVariable long id) {

		Optional<Pais> optional = repository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Pais> guardar(@RequestBody Pais pais) {
		try {
			pais = service.guardar_Actualizar(pais);
			return ResponseEntity.status(HttpStatus.CREATED).body(pais);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pais> apagar(@PathVariable long id) {

		try {
			service.apagar(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {

			return ResponseEntity.notFound().build();
		}
	}

}
