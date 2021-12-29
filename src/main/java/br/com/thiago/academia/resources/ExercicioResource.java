package br.com.thiago.academia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.Exercicio;
import br.com.thiago.academia.services.ExercicioService;

@RestController
@RequestMapping(value = "/exercicios")
public class ExercicioResource {
	
	@Autowired
	ExercicioService exercicioService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Exercicio> findById(@PathVariable Integer id){
		
		Exercicio obj = exercicioService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
