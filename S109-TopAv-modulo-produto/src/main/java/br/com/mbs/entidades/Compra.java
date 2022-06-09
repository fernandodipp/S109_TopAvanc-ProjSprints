package br.com.mbs.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {
		public Integer idCompra;
		public Produto produtoComprado;
		public Integer unidadesCompradas;
		public String comprador;
		public String dataCompra = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		@Override
		public String toString() {
			return "\nCompra ID " + idCompra +
					"\nProduto comprado " + produtoComprado +
					"\nUnidades compradas " + unidadesCompradas +
					"\nValor por Unidade R$" + getValorDaCompra() +
					"\nComprador " + comprador +
					"\nData e Hora " + dataCompra;
		}

		public Float getValorDaCompra() {
			return produtoComprado.precoProduto;
		}

		public Integer getIdCompra() {
			return idCompra;
		}

		public void setIdCompra(Integer idCompra) {
			this.idCompra = idCompra;
		}

		public Produto getProdutoComprado() {
			return produtoComprado;
		}

		public void setProdutoComprado(Produto produtoComprado) {
			this.produtoComprado = produtoComprado;
		}

		public Integer getUnidadesCompradas() {
			return unidadesCompradas;
		}

		public void setUnidadesCompradas(Integer unidadesCompradas) {
			this.unidadesCompradas = unidadesCompradas;
		}

		public String getComprador() {
			return comprador;
		}

		public void setComprador(String comprador) {
			this.comprador = comprador;
		}

		public String getDataCompra() {
			return dataCompra;
		}

		public void setDataCompra(String dataCompra) {
			this.dataCompra = dataCompra;
		}



}
