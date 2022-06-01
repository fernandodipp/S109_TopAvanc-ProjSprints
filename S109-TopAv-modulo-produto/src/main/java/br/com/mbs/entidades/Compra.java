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
					"\nComprador " + comprador +
					"\nData e Hora " + dataCompra;
		}

}
