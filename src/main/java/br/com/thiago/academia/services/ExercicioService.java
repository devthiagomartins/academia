package br.com.thiago.academia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.academia.domain.Exercicio;
import br.com.thiago.academia.repositories.ExercicioRepository;
import br.com.thiago.academia.services.exceptions.ObjectNotFoundException;

@Service
public class ExercicioService {

	@Autowired
	private ExercicioRepository exercicioRepository;
	
	public Exercicio findById(Integer id) {

		Optional<Exercicio> obj = exercicioRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Exercicio.class.getName()));
	}
}
