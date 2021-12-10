package br.com.thiago.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiago.academia.domain.FichaDeTreino;

@Repository
public interface FichaDeTreinoRepository extends JpaRepository<FichaDeTreino, Integer>{

}
