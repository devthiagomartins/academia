package br.com.thiago.academia.domain.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.thiago.academia.domain.Cliente;
import br.com.thiago.academia.domain.Endereco;
import br.com.thiago.academia.domain.enums.EstadoCivil;
import br.com.thiago.academia.domain.enums.Genero;
import br.com.thiago.academia.domain.enums.Perfil;
import br.com.thiago.academia.domain.enums.Status;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cpf;
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
	private Set<Integer> perfis = new HashSet<>();
	private Set<String> telefones = new HashSet<>();
	private List<Endereco> enderecos = new ArrayList<>();
	

	public ClienteDTO() {
		
	}


	public ClienteDTO(Cliente obj) {
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


	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}


	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}


	public Status getStatus() {
		return Status.toEnum(status);
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Genero getGenero() {
		return Genero.toEnum(genero);
	}


	public void setGenero(Integer genero) {
		this.genero = genero;
	}


	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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


	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}


	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCod());
	}


	public Set<String> getTelefones() {
		return telefones;
	}


	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	
	
	
}
