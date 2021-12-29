package br.com.thiago.academia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;
import br.com.thiago.academia.services.FichaDeAvaliacaoFisicaService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class FichaDeAvaliacaoFisicaResource {
	
	@Autowired
	FichaDeAvaliacaoFisicaService fichaDeAvaliacaoFisicaService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<FichaDeAvaliacaoFisica> findById(@PathVariable Integer id){
		
		FichaDeAvaliacaoFisica obj = fichaDeAvaliacaoFisicaService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
