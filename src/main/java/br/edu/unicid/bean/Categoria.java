package br.edu.unicid.bean;

import java.util.Date;

public class Categoria {

	// padrão JavaBean ou POJO – Classe com getters/setters, mais métodos
	// construtores

	private int codCategoria;
	private String nomeCategoria;
	private String linhaCategoria;
	private String faixaCategoria;

	public Categoria(int codCategoria, String nomeCategoria, String linhaCategoria, String faixaCategoria) {
		this.codCategoria = codCategoria;
		this.nomeCategoria = nomeCategoria;
		this.linhaCategoria = linhaCategoria;
		this.faixaCategoria = faixaCategoria;
	}
	
	public Categoria() {
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getLinhaCategoria() {
		return linhaCategoria;
	}

	public void setLinhaCategoria(String linhaCategoria) {
		this.linhaCategoria = linhaCategoria;
	}

	public String getFaixaCategoria() {
		return faixaCategoria;
	}

	public void setFaixaCategoria(String faixaCategoria) {
		this.faixaCategoria = faixaCategoria;
	}

	

}
