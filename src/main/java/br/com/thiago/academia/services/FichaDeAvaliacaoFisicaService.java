package br.com.thiago.academia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;
import br.com.thiago.academia.repositories.FichaDeAvaliacaoFisicaRepository;
import br.com.thiago.academia.services.exceptions.ObjectNotFoundException;

@Service
public class FichaDeAvaliacaoFisicaService {

	@Autowired
	private FichaDeAvaliacaoFisicaRepository fichaDeAvaliacaoFisicaRepository;
	
	public FichaDeAvaliacaoFisica findById(Integer id) {

		Optional<FichaDeAvaliacaoFisica> obj = fichaDeAvaliacaoFisicaRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + FichaDeAvaliacaoFisica.class.getName()));
	}
}
