package br.com.thiago.academia.domain.enums;

public enum Perfil {

	ADMIN(0,"ROLE_ADMIN"),
	CLIENTE(1,"ROLE_CLIENTE"),
	INSTRUTOR(2,"ROLE_INSTRUTOR");
	
	private Integer cod;
	private String descricao;
	
	
	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido: Id - "+cod);
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
