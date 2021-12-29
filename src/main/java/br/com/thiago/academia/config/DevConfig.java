package br.com.thiago.academia.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.thiago.academia.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaDB() throws ParseException {
		
		if(strategy.equals("create")) {
			dbService.instanciaDB();
		}
		
		return false;
		
	
	}
	
	
}
