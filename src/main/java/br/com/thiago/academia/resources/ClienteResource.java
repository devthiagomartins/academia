package br.com.thiago.academia.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.thiago.academia.domain.Cliente;
import br.com.thiago.academia.domain.dtos.ClienteDTO;
import br.com.thiago.academia.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		
		Cliente obj = clienteService.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
		
	}

}
