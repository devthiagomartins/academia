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

import br.com.thiago.academia.domain.dtos.ClienteDTO;
import br.com.thiago.academia.domain.enums.EstadoCivil;
import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Perfil;
import br.com.thiago.academia.domain.enums.Status;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeCadastro = new Date();
	
	private Integer status;
	private Integer genero;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeNascimento;
	
	private String rg;
	private Integer estadoCivil;
	private String observacao;
	
	private String senha;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS_CLIENTE")
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	 
	@ElementCollection
	@CollectionTable(name = "TELEFONES_CLIENTE")
	private Set<String> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	public Cliente() {
		addPerfil(Perfil.CLIENTE);
		
	}

	



	public Cliente(Integer id, String nome, String cpf, String email, Date dataDeCadastro, Status status,
			Genero genero, Date dataDeNascimento, String rg, EstadoCivil estadoCivil, String observacao, String senha) {
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
		this.senha = senha;
		
		addPerfil(Perfil.CLIENTE);
	}


	public Cliente(ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.dataDeCadastro = obj.getDataDeCadastro();
		this.status = obj.getStatus().getCod();
		this.genero = obj.getGenero().getCod();
		this.dataDeNascimento = obj.getDataDeNascimento();
		this.rg = obj.getRg();
		this.estadoCivil = obj.getEstadoCivil().getCod();
		this.observacao = obj.getObservacao();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toSet());
		this.telefones = obj.getTelefones();
		this.enderecos = obj.getEnderecos();
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
	

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
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


	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(Date dataDeNascimento) {
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

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCod());
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
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
