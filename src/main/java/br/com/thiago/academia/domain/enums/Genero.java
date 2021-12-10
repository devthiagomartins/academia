package br.com.thiago.academia.domain.enums;

public enum Genero {

	MASCULINO(0,"Masculino"),
	FEMININO(1,"Feminino"),
	OUTROS(2,"Outros");
	
	private Integer cod;
	private String descricao;
	
	
	private Genero(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public static Genero toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Genero x : Genero.values()) {
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
