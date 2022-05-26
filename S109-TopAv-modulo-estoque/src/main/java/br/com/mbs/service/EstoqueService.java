package br.com.mbs.service;

import br.com.mbs.dados.EstoqueDados;

public class EstoqueService {
	EstoqueDados estoqueDados = new EstoqueDados();
	
	public boolean verificarEstoque (Integer idProduto, Integer quantidade) {
		if (estoqueDados.verificarExistenciaProdutoEsoque(idProduto)==true) {
			Integer disponivelProdutoEstoque = estoqueDados.retornaQuantidadeProdutoEstoque(idProduto);
			if (disponivelProdutoEstoque >= quantidade) {
				System.out.println("A quantidade do pedido � suficiente");
				return true;
			}
		} 
		System.out.println("Produto n�o existe ou n�o � suficiente em estoque");
		return false;		
	}
	
	public boolean verificarEstoque (Integer idProduto) {
		if (estoqueDados.verificarExistenciaProdutoEsoque(idProduto)==true) {
			System.out.println("Produto verificado em estoque: ele existe");
			return true;
		} 
		return false;		
	}
	
	public void atualizarEstoque (Integer idProduto, Integer quantidade) {
		if (estoqueDados.verificarExistenciaProdutoEsoque(idProduto) == false) {
			estoqueDados.registrarProdutoEstoque(idProduto, quantidade);
		} else if (verificarEstoque(idProduto, quantidade) == true) {
			Integer novaQuantidadeProdutoEstoque = 
					estoqueDados.retornaQuantidadeProdutoEstoque(idProduto) - quantidade;
			estoqueDados.atualizarProdutoEstoque(idProduto, novaQuantidadeProdutoEstoque);
		}		
		
	}

}
