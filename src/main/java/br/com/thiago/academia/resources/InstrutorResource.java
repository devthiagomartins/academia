package br.com.thiago.academia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.Instrutor;
import br.com.thiago.academia.services.InstrutorService;

@RestController
@RequestMapping(value = "/instrutores")
public class InstrutorResource {
	
	@Autowired
	InstrutorService instrutorService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Instrutor> findById(@PathVariable Integer id){
		
		Instrutor obj = instrutorService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
