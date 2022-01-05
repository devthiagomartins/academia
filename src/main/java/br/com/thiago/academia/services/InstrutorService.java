package br.com.thiago.academia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.academia.domain.Instrutor;
import br.com.thiago.academia.repositories.InstrutorRepository;
import br.com.thiago.academia.services.exceptions.ObjectNotFoundException;

@Service
public class InstrutorService {

	@Autowired
	private InstrutorRepository instrutorRepository;
	
	public Instrutor findById(Integer id) {

		Optional<Instrutor> obj = instrutorRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Instrutor.class.getName()));
	}

	public List<Instrutor> findAll() {
		
		return instrutorRepository.findAll();
	}
}
