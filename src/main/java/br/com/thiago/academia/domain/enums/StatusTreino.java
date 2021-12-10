package br.com.thiago.academia.domain.enums;

public enum StatusTreino {
	
	PENDENTE(0,"Pendente"),
	ANDAMENTO(1,"Em andamento"),
	CONCLUIDO(2,"Concluído"),
	CANCELADO(3,"Cancelado");
	
	
	private Integer cod;
	private String descricao;
	
	
	
	private StatusTreino(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public static StatusTreino toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusTreino x : StatusTreino.values()) {
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
