package br.com.mbs.dados;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.mbs.entidades.Compra;

public class ComprasDados {
	Map<Integer, Compra> mapaCompras = new HashMap<>();
	Integer contadorCompra = 1;
	
	public void registrarCompra (Compra compra) {
		compra.idCompra = contadorCompra;
		mapaCompras.put(contadorCompra, compra);
		contadorCompra++;
	}
	
	public Compra buscarCompraPorId (Integer idCompra) {
		Compra compra = mapaCompras.get(idCompra);
		return compra;
	}
	
	public Collection<Compra> listarCompras(){
		return mapaCompras.values();
	}
	
	public void removerCompra (Integer idCompra) {
		mapaCompras.remove(idCompra);
	}
	
	public Compra atualizarCompra (Integer idCompra, Compra compra) {
		compra.idCompra = idCompra;
		mapaCompras.put(idCompra, compra);
		return compra;
	}
	
	public boolean verificarExistenciaCompra (Integer idCompra) {
		return mapaCompras.containsKey(idCompra);
	}

}