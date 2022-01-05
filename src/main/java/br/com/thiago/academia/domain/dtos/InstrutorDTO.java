package br.com.thiago.academia.domain.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.thiago.academia.domain.Endereco;
import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;
import br.com.thiago.academia.domain.FichaDeTreino;
import br.com.thiago.academia.domain.Instrutor;
import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Perfil;
import br.com.thiago.academia.domain.enums.Status;

public class InstrutorDTO {
		
	private Integer id;
	
	private String nome;
	private String senha;
	private String cref;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeCadastro;
	
	private Integer status;
	private Integer genero;
	private String observacao;
	
	private Set<String> telefones = new HashSet<>();
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonIgnore
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	@JsonIgnore
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	
	public InstrutorDTO() {
		
	}

	public InstrutorDTO(Instrutor obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.senha = obj.getSenha();
		this.cref = obj.getCref();
		this.dataDeCadastro = obj.getDataDeCadastro();
		this.status = obj.getStatus().getCod();
		this.genero = obj.getGenero().getCod();
		this.observacao = obj.getObservacao();
		this.telefones = obj.getTelefones();
		this.enderecos = obj.getEnderecos();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toSet());
		this.avaliacoes = obj.getAvaliacoes();
		this.fichaDeTreinos = obj.getFichaDeTreinos();
		
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

	@JsonIgnore
	public List<FichaDeAvaliacaoFisica> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<FichaDeAvaliacaoFisica> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@JsonIgnore
	public List<FichaDeTreino> getFichaDeTreinos() {
		return fichaDeTreinos;
	}

	public void setFichaDeTreinos(List<FichaDeTreino> fichaDeTreinos) {
		this.fichaDeTreinos = fichaDeTreinos;
	}
	
	
	
	

}
