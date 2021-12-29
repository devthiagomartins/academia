package br.com.thiago.academia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.FichaDeTreino;
import br.com.thiago.academia.services.FichaDeTreinoService;

@RestController
@RequestMapping(value = "/treinos")
public class FichaDeTreinoResource {
	
	@Autowired
	FichaDeTreinoService fichaDeTreinoService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<FichaDeTreino> findById(@PathVariable Integer id){
		
		FichaDeTreino obj = fichaDeTreinoService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
