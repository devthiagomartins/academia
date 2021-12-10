package br.com.thiago.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;

@Repository
public interface FichaDeAvaliacaoFisicaRepository extends JpaRepository<FichaDeAvaliacaoFisica, Integer>{

}
