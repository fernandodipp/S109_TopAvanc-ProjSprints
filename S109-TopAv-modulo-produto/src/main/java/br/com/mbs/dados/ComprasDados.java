package br.com.mbs.dados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.mbs.entidades.Compra;

@Service
public class ComprasDados {
	
	Map<Integer, Compra> mapaCompras = new HashMap<Integer, Compra>();
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

	public ArrayList<Compra> arrayCompras() {
		return new ArrayList<>(mapaCompras.values());
	}


}