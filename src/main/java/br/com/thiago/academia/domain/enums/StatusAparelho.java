package br.com.thiago.academia.domain.enums;

public enum StatusAparelho {

	NORMAL(0,"Normal"),
	MANUTENCAO(1,"Em manutenção");
	
	private Integer cod;
	private String descricao;
	

	
	private StatusAparelho(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static StatusAparelho toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusAparelho x : StatusAparelho.values()) {
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
