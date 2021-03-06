package br.com.mbs.service;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mbs.dados.ComprasDados;
import br.com.mbs.dados.ProdutoDados;
import br.com.mbs.entidades.Compra;
import br.com.mbs.entidades.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoDados produtoDados;
	@Autowired
	ComprasDados comprasDados;	

	public int inserirProduto (Produto produto) {
		if (produtoDados.verificarExistenciaProduto(produto.idProduto)) {
			//409 conflict
			return 409;
		}
		if (produto.marcaProduto.isEmpty() || produto.marcaProduto.isBlank() || produto.modeloProduto.isEmpty() || produto.modeloProduto.isBlank()) {
			return 400;
		}
		if (produto.precoProduto.equals("") || produto.precoProduto.equals(0)) {
			return 400;
		}
		if (produto.quantidadeProduto.equals("") || produto.quantidadeProduto.equals(0) || produto.quantidadeProduto<0) {
			return 400;
		}
		produtoDados.salvarProduto(produto);
		//201 created
		return 201;
		}


	public int removerProduto (Integer idProduto) {
		if (!produtoDados.verificarExistenciaProduto(idProduto)) {
			return 404;
		}
		produtoDados.deletarProduto(idProduto);
		//202 accepted
		return 202;
	}

	public int alterarProduto (Produto produto, Integer idProduto) {
		if (!produtoDados.verificarExistenciaProduto(produto.idProduto)) {
			return 404;
		}
		if (produto.marcaProduto.isEmpty() || produto.marcaProduto.isBlank() || produto.modeloProduto.isEmpty() || produto.modeloProduto.isBlank()) {
			return 400;
		}
		if (produto.precoProduto.equals("") || produto.precoProduto.equals(0)) {
			return 400;
		}
		if (produto.quantidadeProduto.equals("") || produto.quantidadeProduto.equals(0) || produto.quantidadeProduto<0) {
			return 400;
		}
		produtoDados.atualizarProduto(idProduto, produto);
		//200 ok
		return 200;
	}

	public Collection<Produto> listarTodosProdutos () {
		return produtoDados.listarProdutos();
	}

	public Collection<Compra> listarTodasCompras () {
		return comprasDados.listarCompras();
	}

	public Iterator<Compra> iteratorCompras(){
		return comprasDados.arrayCompras().iterator();
	}

	public Produto buscarIdProduto(Integer idProduto) {
		if (!produtoDados.verificarExistenciaProduto(idProduto)) {
			Produto produtoVazio = new Produto();
			produtoVazio.idProduto = null;
			produtoVazio.marcaProduto = null;
			produtoVazio.precoProduto = null;
			produtoVazio.quantidadeProduto = null;
			return produtoVazio;
		}
		return produtoDados.buscarPorId(idProduto);
	}

	public Compra realizarCompra (Integer idProduto, Integer quantidadePedido, String comprador) {
		if (!produtoDados.verificarExistenciaProduto(idProduto)) {
			System.out.println("Produto n?o existe no mapa");
		Compra compraVazia = new Compra();
		compraVazia.idCompra = null;
		compraVazia.produtoComprado = null;
		compraVazia.comprador = null;
		compraVazia.unidadesCompradas = null;
		compraVazia.dataCompra = null;
		return compraVazia;
		} else if (produtoDados.buscarPorId(idProduto).quantidadeProduto < quantidadePedido){
			System.out.println("Compra excede quantidade em estoque");
			Compra compraVazia = new Compra();
			compraVazia.idCompra = null;
			compraVazia.produtoComprado = null;
			compraVazia.comprador = null;
			compraVazia.unidadesCompradas = null;
			compraVazia.dataCompra = null;
			return compraVazia;
		}
		System.out.println("Prosseguindo com a compra");
		Produto produtoComprado = produtoDados.buscarPorId(idProduto);
		produtoComprado.quantidadeProduto = produtoComprado.quantidadeProduto - quantidadePedido;
		produtoDados.atualizarProduto(idProduto, produtoComprado);
		Compra novaCompra = new Compra();
		novaCompra.produtoComprado = produtoDados.buscarPorId(idProduto);
		novaCompra.unidadesCompradas = quantidadePedido;
		novaCompra.comprador = comprador;
		comprasDados.registrarCompra(novaCompra);
		System.out.println("Compra realizada com sucesso");
		return novaCompra;
	}

}