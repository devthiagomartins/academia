package br.com.thiago.academia.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.thiago.academia.domain.enums.Intensidade;

@Entity
public class Exercicio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer series;
	private Integer numeroDeRepeticoes;
	private Double carga;
	private Double intervalo;
	private Integer intensidade;
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "fichaDeTreino_id")
	private FichaDeTreino fichaDeTreino;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "aparelho_id")
	private Aparelho aparelho;
	
	public Exercicio(){
		
	}



	public Exercicio(Integer id, String nome, Integer series, Integer numeroDeRepeticoes, Double carga,
			Double intervalo, Intensidade intensidade, String observacao, FichaDeTreino fichaDeTreino,
			Categoria categoria, Aparelho aparelho) {
		super();
		this.id = id;
		this.nome = nome;
		this.series = series;
		this.numeroDeRepeticoes = numeroDeRepeticoes;
		this.carga = carga;
		this.intervalo = intervalo;
		this.intensidade = intensidade.getCod();
		this.observacao = observacao;
		this.fichaDeTreino = fichaDeTreino;
		this.categoria = categoria;
		this.aparelho = aparelho;
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

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getNumeroDeRepeticoes() {
		return numeroDeRepeticoes;
	}

	public void setNumeroDeRepeticoes(Integer numeroDeRepeticoes) {
		this.numeroDeRepeticoes = numeroDeRepeticoes;
	}

	public Double getCarga() {
		return carga;
	}

	public void setCarga(Double carga) {
		this.carga = carga;
	}

	public Double getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Double intervalo) {
		this.intervalo = intervalo;
	}

	public Intensidade getIntensidade() {
		return Intensidade.toEnum(intensidade);
	}

	public void setIntensidade(Intensidade intensidade) {
		this.intensidade = intensidade.getCod();
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacoes(String observacao) {
		this.observacao = observacao;
	}

	public FichaDeTreino getFichaDeTreino() {
		return fichaDeTreino;
	}

	public void setFichaDeTreino(FichaDeTreino fichaDeTreino) {
		this.fichaDeTreino = fichaDeTreino;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
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
		Exercicio other = (Exercicio) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
