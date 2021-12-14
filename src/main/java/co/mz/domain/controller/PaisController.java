package co.mz.domain.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.mz.domain.Pais;
import co.mz.domain.Repository.PaisRepository;
import co.mz.domain.exception.EntidadeNaoEncontradaException;
import co.mz.domain.service.PaisService;


/**
 * @author Blandino Junior Sibone Mucumbe
 *
 */
@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository repository;
	@Autowired
	private PaisService service;

	/* metodo reponsalve por listar paises */
	@GetMapping
	private List<Pais> listar() {
		return repository.findAll();
	}
	/*Metodo responsavel por listar paises com combinação de varios atributos */
	@GetMapping("/listaDinamica")
	public List<Pais> listarOrdenada(String nome,String capital,String regiao,String Subregioao){
		
		return repository.find(nome, capital, regiao, Subregioao);
	}

	/* metodo reponsalve por retornar um pais corepondente a um ID*/
	@GetMapping("/{id}")
	public ResponseEntity<Pais> listarId(@PathVariable long id) {

		Optional<Pais> optional = repository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

	/* metodo reponsalvel por registrar propiedades de um novo pais*/
	@PostMapping
	public ResponseEntity<Pais> guardar(@RequestBody Pais pais) {
		try {
			pais = service.guardar_Actualizar(pais);
			return ResponseEntity.status(HttpStatus.CREATED).body(pais);
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	/*
	 * Metodo responsalvel por apagar propiedades de um pais corespondente a um id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Pais> apagar(@PathVariable long id) {

		try {
			service.apagar(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException e) {

			return ResponseEntity.notFound().build();
		}
	}

	/*
	 * Metodo responsavel por editar atributos de um pais 'So actualiza os atributos colocados nos endpoit
	 */
	@PatchMapping("/{id}")
	public ResponseEntity<Pais> editar(@PathVariable long id, @RequestBody Map<String, Object> campos) {
		Optional<Pais> paisActual = repository.findById(id);

		if (paisActual.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		merge(campos, paisActual.get());
		
		Pais paisActualizado=service.guardar_Actualizar(paisActual.get());
		
		return ResponseEntity.ok(paisActualizado);
	}

	/*
	 * Metodo responsavel por auxiliar o metodo editar para editar os atributos de forma parcial ou completa
	 */
	public void merge(Map<String, Object> campoOrigem, Pais paisDestiono) {

		ObjectMapper objectMapper = new ObjectMapper();
		Pais paisOrigem = objectMapper.convertValue(campoOrigem, Pais.class);

		campoOrigem.forEach((nome, propiedade) -> {
			Field field = ReflectionUtils.findField(Pais.class, nome);
			field.setAccessible(true);

			Object novoValor = ReflectionUtils.getField(field, paisOrigem);

			ReflectionUtils.setField(field, paisDestiono, novoValor);

		});
	}

}
