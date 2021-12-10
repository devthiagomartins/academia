package br.com.thiago.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiago.academia.domain.Instrutor;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Integer>{

}
