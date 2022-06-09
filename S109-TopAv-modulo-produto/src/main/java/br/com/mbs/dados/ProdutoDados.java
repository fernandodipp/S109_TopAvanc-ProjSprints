package br.com.mbs.dados;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Produto;

@Service
public class ProdutoDados {
	
	Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>();
	Integer contadorProduto = 1;

	public void salvarProduto (Produto produto) {
		produto.idProduto = contadorProduto;
		mapaProduto.put(contadorProduto, produto);
		contadorProduto++;
	}

	public Produto buscarPorId (Integer idProduto) {
		Produto produto = mapaProduto.get(idProduto);
		return produto;
	}

	public Collection<Produto> listarProdutos(){
		return mapaProduto.values();
	}

	public void deletarProduto (Integer idProduto) {
		mapaProduto.remove(idProduto);
	}

	public Produto atualizarProduto (Integer idProduto, Produto produto) {
		produto.idProduto = idProduto;
		mapaProduto.put(idProduto, produto);
		return produto;
	}

	public boolean verificarExistenciaProduto (Integer idProduto) {
		return mapaProduto.containsKey(idProduto);
	}
	
}
