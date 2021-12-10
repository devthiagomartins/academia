package br.com.thiago.academia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.thiago.academia.domain.Cidade;
import br.com.thiago.academia.domain.Estado;
import br.com.thiago.academia.repositories.EstadoRepository;

@SpringBootApplication
public class AcademiaApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado estado01 = new Estado(null, "Goiás");
		
		estadoRepository.saveAll(Arrays.asList(estado01));
		
		
		
	}

}
