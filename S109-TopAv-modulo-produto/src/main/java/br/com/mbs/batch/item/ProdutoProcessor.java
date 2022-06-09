package br.com.mbs.batch.item;

import org.springframework.batch.item.ItemProcessor;

import br.com.mbs.entidades.Compra;


public class ProdutoProcessor implements ItemProcessor<Compra, Compra> {

	@Override
	public Compra process(Compra compra) throws Exception {
		System.out.println("+++ Iniciando " + this.getClass().getSimpleName() + " +++");
		if(compra.getValorDaCompra()>10) {
			System.out.println(compra.toString());
			return compra;
		}
		return null;
	}
}
