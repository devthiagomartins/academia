package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Perfil;
import br.com.thiago.academia.domain.enums.Status;

@Entity
public class Instrutor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String senha;
	
	@Column(unique = true)
	private String cref;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeCadastro;
	
	private Integer status;
	private Integer genero;
	private String observacao;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TELEFONES_INSTRUTOR")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "instrutor")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "PERFIS_INSTRUTOR")
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "instrutor")
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "instrutor")
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	
	
	public Instrutor() {
		addPerfil(Perfil.INSTRUTOR);
	}


	public Instrutor(Integer id, String nome ,String cref, Date dataDeCadastro, Status status, Genero genero,
			String observacao,  String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.cref = cref;
		this.dataDeCadastro = dataDeCadastro;
		this.status = status.getCod();
		this.genero = genero.getCod();
		this.observacao = observacao;
		addPerfil(Perfil.INSTRUTOR);
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

	

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCref() {
		return cref;
	}


	public void setCref(String cref) {
		this.cref = cref;
	}


	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}


	public void setDataDeCadastro(Date dataDeCadastro) {
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


	
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCod());
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	
	

	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
