package co.mz.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.mz.domain.Pais;
import co.mz.domain.Repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@Autowired
	private PaisRepository repository;

	@GetMapping
	private List<Pais> listar() {
		return repository.findAll();
	}
}
