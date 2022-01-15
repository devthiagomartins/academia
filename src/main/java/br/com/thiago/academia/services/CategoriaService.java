package br.com.thiago.academia.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.thiago.academia.domain.Categoria;
import br.com.thiago.academia.domain.dtos.CategoriaDTO;
import br.com.thiago.academia.repositories.CategoriaRepository;
import br.com.thiago.academia.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@Transactional
	public CategoriaDTO findById(Integer id) {

		Categoria obj = categoriaRepository.findById(id).get();
		
		
		if(obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		
		
		return new CategoriaDTO(obj);
		
	}
	
	@Transactional(readOnly = true)
	public List<CategoriaDTO> findAll(){
		
		List<Categoria> list = categoriaRepository.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
	
		return listDTO;
	}
	

}
