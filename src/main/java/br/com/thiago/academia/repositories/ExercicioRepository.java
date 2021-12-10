package br.com.thiago.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiago.academia.domain.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Integer>{

}
