package br.edu.unicid.bean;

import java.util.Date;

public class Produto {

	// padrão JavaBean ou POJO – Classe com getters/setters, mais métodos
	// construtores

	private int idProduto;
	private String nomeProduto;
	private String descProduto;
	private String fotoProduto;
	private Double precoProduto;
	private int codCategoria;
	
	public Produto(int idProduto, String nomeProduto, String descProduto, String fotoProduto, Double precoProduto, int codCategoria) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descProduto = descProduto;
		this.fotoProduto = fotoProduto;
		this.precoProduto = precoProduto;
		this.codCategoria = codCategoria;
	}
	
	public Produto() {
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescProduto() {
		return descProduto;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}

	public String getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

}
