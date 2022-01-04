package br.com.thiago.academia.domain.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.thiago.academia.domain.Endereco;
import br.com.thiago.academia.domain.FichaDeAvaliacaoFisica;
import br.com.thiago.academia.domain.FichaDeTreino;
import br.com.thiago.academia.domain.Instrutor;

public class InstrutorDTO {
	
private Integer id;
	
	private String nome;
	
	
	private String cref;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeCadastro;
	
	private Integer status;
	private Integer genero;
	private String observacao;
	
	private Set<String> telefones = new HashSet<>();
	
	private List<Endereco> enderecos = new ArrayList<>();
	
	private Set<Integer> perfis = new HashSet<>();
	
	private List<FichaDeAvaliacaoFisica> avaliacoes = new ArrayList<>();
	
	private List<FichaDeTreino> fichaDeTreinos = new ArrayList<>();
	
	public InstrutorDTO() {
		
	}

	public InstrutorDTO(Instrutor obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cref = obj.getCref();
		this.dataDeCadastro = obj.getDataDeCadastro();
		this.status = obj.getStatus();
		this.genero = obj.getGenero();
		this.observacao = obj.getObservacao();
		this.telefones = obj.getTelefones();
		this.enderecos = obj.getEnderecos();
		this.perfis = obj.getPerfis();
		this.avaliacoes = obj.getAvaliacoes();
		this.fichaDeTreinos = obj.getFichaDeTreinos();
	}
	
	

}
