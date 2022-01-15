package br.com.thiago.academia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.thiago.academia.domain.dtos.CategoriaDTO;
import br.com.thiago.academia.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id){
		
		CategoriaDTO dto = categoriaService.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		
		List<CategoriaDTO> listDTO = categoriaService.findAll();
		return ResponseEntity.ok().body(listDTO);
	}

	
	
}
