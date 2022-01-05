package br.com.thiago.academia.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.Cliente;
import br.com.thiago.academia.domain.Instrutor;
import br.com.thiago.academia.domain.dtos.ClienteDTO;
import br.com.thiago.academia.domain.dtos.InstrutorDTO;
import br.com.thiago.academia.services.InstrutorService;

@RestController
@RequestMapping(value = "/instrutores")
public class InstrutorResource {
	
	@Autowired
	InstrutorService instrutorService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<InstrutorDTO> findById(@PathVariable Integer id){
		
		Instrutor obj = instrutorService.findById(id);
		return ResponseEntity.ok().body(new InstrutorDTO(obj));
		
	}
	
	@GetMapping
	public ResponseEntity<List<InstrutorDTO>> findAll(){
		List<Instrutor> list = instrutorService.findAll();
		List<InstrutorDTO> listDTO = list.stream().map(obj -> new InstrutorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
