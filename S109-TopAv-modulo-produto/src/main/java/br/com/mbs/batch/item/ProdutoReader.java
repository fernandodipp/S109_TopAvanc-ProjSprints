package br.com.mbs.batch.item;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.mbs.dados.ComprasDados;
import br.com.mbs.entidades.Compra;
import br.com.mbs.service.ProdutoService;

public class ProdutoReader implements ItemReader<Compra> {
	
	@Autowired
	private ProdutoService produtoService;

	private Iterator<Compra> it;
 
	private Compra compraRetorno;

	@PostConstruct
	public void postConstruct() {
	}

	@Override
	public Compra read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("+++ Iniciando " + this.getClass().getSimpleName() + " +++");
		
		if (compraRetorno == null) {
		it = produtoService.iteratorCompras();
		}
		while (it.hasNext()) {
			return compraRetorno = it.next();
		}
				
		compraRetorno = null;
		return compraRetorno;

	}

}
