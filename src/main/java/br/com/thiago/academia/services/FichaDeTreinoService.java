package br.com.thiago.academia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.thiago.academia.domain.FichaDeTreino;
import br.com.thiago.academia.repositories.FichaDeTreinoRepository;
import br.com.thiago.academia.services.exceptions.ObjectNotFoundException;

@Service
public class FichaDeTreinoService {

	@Autowired
	private FichaDeTreinoRepository fichaDeTreinoRepository;
	
	public FichaDeTreino findById(Integer id) {

		Optional<FichaDeTreino> obj = fichaDeTreinoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + FichaDeTreino.class.getName()));
	}
}
