package br.com.mbs.dados;

import java.util.HashMap;
import java.util.Map;

public class EstoqueDados {
	Map<Integer, Integer> mapaCompras = new HashMap<>();
	
	public void registrarProdutoEstoque (Integer idProduto, Integer quantidade) {
		mapaCompras.put(idProduto, quantidade);
		System.out.println("Registrando novo produto no estoque com ID "+ idProduto + ", com a quantidade " + quantidade);
	}
	
	
	public void removerProdutoEstoque (Integer idProduto) {
		mapaCompras.remove(idProduto);
		System.out.println("Removendo o produto ID " + idProduto);
	}
	
	public void atualizarProdutoEstoque (Integer idProduto, Integer quantidade) {
		mapaCompras.put(idProduto, quantidade);
		System.out.println("Atualizando a quantidade do produto ID " + idProduto + " para a quantia de " + quantidade);
	}
	
	public boolean verificarExistenciaProdutoEsoque (Integer idProduto) {
		System.out.println("Verificando a existencia do produto ID " + idProduto + ". Seu resultado"
				+ " é " + mapaCompras.containsKey(idProduto));
		return mapaCompras.containsKey(idProduto);		
	}
	
	public Integer retornaQuantidadeProdutoEstoque (Integer idProduto) {
		System.out.println("Retornando a quantidade do produto ID " + idProduto + " que é: " + mapaCompras.get(idProduto).toString());
		return mapaCompras.get(idProduto);
	}

}
