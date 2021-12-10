package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Status;

@Entity
public class Instrutor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cref;
	private LocalDateTime dataDeCadastro;
	private Integer status;
	private Integer genero;
	private String observacao;
	
	@OneToMany(mappedBy = "instrutor")
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "instrutor")
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	
	
	public Instrutor() {
		
	}


	public Instrutor(Integer id, String nome, String cref, LocalDateTime dataDeCadastro, Status status, Genero genero,
			String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cref = cref;
		this.dataDeCadastro = dataDeCadastro;
		this.status = status.getCod();
		this.genero = genero.getCod();
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


	public String getCref() {
		return cref;
	}


	public void setCref(String cref) {
		this.cref = cref;
	}


	public LocalDateTime getDataDeCadastro() {
		return dataDeCadastro;
	}


	public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}


	public Status getStatus() {
		return Status.toEnum(status);
	}


	public void setStatus(Status status) {
		this.status = status.getCod();
	}


	public Genero getGenero() {
		return Genero.toEnum(genero);
	}


	public void setGenero(Genero genero) {
		this.genero = genero.getCod();
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public List<FichaDeAvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}


	public void setAvaliacoes(List<FichaDeAvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}


	public List<FichaDeTreino> getFichaDeTreinos() {
		return fichaDeTreinos;
	}


	public void setFichaDeTreinos(List<FichaDeTreino> fichaDeTreinos) {
		this.fichaDeTreinos = fichaDeTreinos;
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
		Instrutor other = (Instrutor) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
