package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.thiago.academia.domain.enums.EstadoCivil;
import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Status;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cpf;
	private String email;
	private LocalDateTime dataDeCadastro;
	private Integer status;
	private Integer genero;
	private LocalDate dataDeNascimento;
	private String rg;
	private Integer estadoCivil;
	private String observacao;
	
	@OneToMany(mappedBy = "cliente")
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	public Cliente() {
		
	}

	



	public Cliente(Integer id, String nome, String cpf, String email, LocalDateTime dataDeCadastro, Status status,
			Genero genero, LocalDate dataDeNascimento, String rg, EstadoCivil estadoCivil, String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataDeCadastro = dataDeCadastro;
		this.status = status.getCod();
		this.genero = genero.getCod();
		this.dataDeNascimento = dataDeNascimento;
		this.rg = rg;
		this.estadoCivil = estadoCivil.getCod();
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(estadoCivil);
	}


	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil.getCod();
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


	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
