package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.thiago.academia.domain.enums.StatusTreino;

@Entity
public class FichaDeTreino implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer statusTreino;
	private Date dataDeRegistro;
	private Date dataDeInicio;
	private Date dataDeConclusao;
	private String objetivo;
	private Integer frequenciaSemanal;
	private String observacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "fichaDeTreino")
	private List<Exercicio> exercicios = new ArrayList<>();
	
	public FichaDeTreino() {
		
	}


	public FichaDeTreino(Integer id, String nome, StatusTreino statusTreino, Date dataDeRegistro,
			Date dataDeInicio, Date dataDeConclusao, String objetivo, Integer frequenciaSemanal,
			String observacao, Instrutor instrutor, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.statusTreino = statusTreino.getCod();
		this.dataDeRegistro = dataDeRegistro;
		this.dataDeInicio = dataDeInicio;
		this.dataDeConclusao = dataDeConclusao;
		this.objetivo = objetivo;
		this.frequenciaSemanal = frequenciaSemanal;
		this.observacao = observacao;
		this.instrutor = instrutor;
		this.cliente = cliente;
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

	public StatusTreino getStatusTreino() {
		return StatusTreino.toEnum(statusTreino);
	}

	public void setStatusTreino(StatusTreino statusTreino) {
		this.statusTreino = statusTreino.getCod();
	}

	public Date getDataDeRegistro() {
		return dataDeRegistro;
	}

	public void setDataDeRegistro(Date dataDeRegistro) {
		this.dataDeRegistro = dataDeRegistro;
	}

	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public Date getDataDeConclusao() {
		return dataDeConclusao;
	}

	public void setDataDeConclusao(Date dataDeConclusao) {
		this.dataDeConclusao = dataDeConclusao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Integer getFrequenciaSemanal() {
		return frequenciaSemanal;
	}

	public void setFrequenciaSemanal(Integer frequenciaSemanal) {
		this.frequenciaSemanal = frequenciaSemanal;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
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
		FichaDeTreino other = (FichaDeTreino) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
