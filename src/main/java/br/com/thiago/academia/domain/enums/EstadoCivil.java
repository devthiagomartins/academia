package br.com.thiago.academia.domain.enums;

public enum EstadoCivil {
	
	SOLTEIRO(0,"Solteiro(a)"),
	CASADO(1,"Casado(a)"),
	SEPARADO(2,"Separado(a)"),
	DIVORCIADO(3,"Divorciado(a)"),
	VIUVO(4,"Viuvo(a)");
	
	private Integer cod;
	private String descricao;
	
	
	private EstadoCivil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static EstadoCivil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoCivil x : EstadoCivil.values()) {
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
	
