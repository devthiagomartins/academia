package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FichaDeAvaliacaoFisica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double peso;
	private Date dataDeRegistro;
	private Double gastoMetabolico;
	private Integer idadeMetabolica;
	private Double porcentagemDeLiquido;
	private Double gorduraVisceral;
	private Double massaOssea;
	private Double porcentagemDeGordura;
	private Double massaMuscular;
	private Double pesoGordo;
	private String observacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;
	
	public FichaDeAvaliacaoFisica() {
		
	}



	public FichaDeAvaliacaoFisica(Integer id, Double peso, Date dataDeResigtro, Double gastoMetabolico,
			Integer idadeMetabolica, Double porcentagemDeLiquido, Double gorduraVisceral, Double massaOssea,
			Double porcentagemDeGordura, Double massaMuscular, Double pesoGordo, String observacao, Cliente cliente,
			Instrutor instrutor) {
		super();
		this.id = id;
		this.peso = peso;
		this.dataDeRegistro = dataDeResigtro;
		this.gastoMetabolico = gastoMetabolico;
		this.idadeMetabolica = idadeMetabolica;
		this.porcentagemDeLiquido = porcentagemDeLiquido;
		this.gorduraVisceral = gorduraVisceral;
		this.massaOssea = massaOssea;
		this.porcentagemDeGordura = porcentagemDeGordura;
		this.massaMuscular = massaMuscular;
		this.pesoGordo = pesoGordo;
		this.observacao = observacao;
		this.cliente = cliente;
		this.instrutor = instrutor;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Date getDataDeRegistro() {
		return dataDeRegistro;
	}

	public void setDataDeRegistro(Date dataDeResigtro) {
		this.dataDeRegistro = dataDeResigtro;
	}

	public Double getGastoMetabolico() {
		return gastoMetabolico;
	}

	public void setGastoMetabolico(Double gastoMetabolico) {
		this.gastoMetabolico = gastoMetabolico;
	}

	public Integer getIdadeMetabolica() {
		return idadeMetabolica;
	}

	public void setIdadeMetabolica(Integer idadeMetabolica) {
		this.idadeMetabolica = idadeMetabolica;
	}

	public Double getPorcentagemDeLiquido() {
		return porcentagemDeLiquido;
	}

	public void setPorcentagemDeLiquido(Double porcentagemDeLiquido) {
		this.porcentagemDeLiquido = porcentagemDeLiquido;
	}

	public Double getGorduraVisceral() {
		return gorduraVisceral;
	}

	public void setGorduraVisceral(Double gorduraVisceral) {
		this.gorduraVisceral = gorduraVisceral;
	}

	public Double getMassaOssea() {
		return massaOssea;
	}

	public void setMassaOssea(Double massaOssea) {
		this.massaOssea = massaOssea;
	}

	public Double getPorcentagemDeGordura() {
		return porcentagemDeGordura;
	}

	public void setPorcentagemDeGordura(Double porcentagemDeGordura) {
		this.porcentagemDeGordura = porcentagemDeGordura;
	}

	public Double getMassaMuscular() {
		return massaMuscular;
	}

	public void setMassaMuscular(Double massaMuscular) {
		this.massaMuscular = massaMuscular;
	}

	public Double getPesoGordo() {
		return pesoGordo;
	}

	public void setPesoGordo(Double pesoGordo) {
		this.pesoGordo = pesoGordo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
		FichaDeAvaliacaoFisica other = (FichaDeAvaliacaoFisica) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
