package br.com.thiago.academia.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.thiago.academia.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dbService;
	
	
	@Bean
	public void instanciaDB() throws ParseException {
		
		this.dbService.instanciaDB();
	}
	
	
}
