package br.com.thiago.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.thiago.academia.domain.Aparelho;

@Repository
public interface AparelhoRepository extends JpaRepository<Aparelho, Integer>{

}
