package com.petshopping.domain.enums;

public enum Tipo {

	FUNCIONARIO(1, "ROLE_FUNCIONARIO"),
	Clinete (2, "ROLE_CLIENTE");
	
	private int codigo;
	private String descricao;
	
	private Tipo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static Tipo  toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(Tipo o : Tipo.values()){
			if(codigo.equals(o.getCodigo())) {
				return o;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + codigo);
	}



	 
	
	
}
