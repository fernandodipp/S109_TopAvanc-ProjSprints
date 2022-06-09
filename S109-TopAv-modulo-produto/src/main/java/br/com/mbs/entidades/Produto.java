package br.com.mbs.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Produto {

	public Integer idProduto;
	public String marcaProduto = null;
	public String modeloProduto = null;
	public Float precoProduto = null;
	public Integer quantidadeProduto = null;
	public String dataCadastro = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getModeloProduto() {
		return modeloProduto;
	}

	public void setModeloProduto(String modeloProduto) {
		this.modeloProduto = modeloProduto;
	}

	public Float getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Float precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	@Override
	public String toString() {

	return "\nId " + idProduto +
			"\nMarca: " + marcaProduto +
			"\nModelo " + modeloProduto;
	}

}
