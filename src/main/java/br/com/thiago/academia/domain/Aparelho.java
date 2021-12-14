package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.thiago.academia.domain.enums.StatusAparelho;

@Entity
public class Aparelho implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double cargaSuportada;
	private Integer statusAparelho;
	private String observacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aparelho")
	private List<Exercicio> exercicios = new ArrayList<>();
	
	public Aparelho() {
		
	}
	

	public Aparelho(Integer id, String nome, Double cargaSuportada, StatusAparelho statusAparelho, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaSuportada = cargaSuportada;
		this.statusAparelho = statusAparelho.getCod();
		this.observacao = observacao;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCargaSuportada() {
		return cargaSuportada;
	}

	public void setCargaSuportada(Double cargaSuportada) {
		this.cargaSuportada = cargaSuportada;
	}

	public StatusAparelho getStatusAparelho() {
		return StatusAparelho.toEnum(statusAparelho);
	}

	public void setStatusAparelho(StatusAparelho statusAparelho) {
		this.statusAparelho = statusAparelho.getCod();
	}

	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
