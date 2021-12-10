package br.com.thiago.academia.domain.enums;

public enum Intensidade {

	LEVE(0,"Leve"),
	MODERADA(1,"Moderada"),
	ALTA(2,"Alta");

	private Integer cod;
	private String descricao;
	
	private Intensidade(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public static Intensidade toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Intensidade x : Intensidade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}
	
	
	

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
