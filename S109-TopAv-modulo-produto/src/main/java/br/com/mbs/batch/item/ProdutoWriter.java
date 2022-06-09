package br.com.mbs.batch.item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.springframework.batch.item.ItemWriter;

import br.com.mbs.entidades.Compra;

public class ProdutoWriter implements ItemWriter<Compra> {

	String fileName = "ComprasAcima10.txt";
	@Override
	public void write(List<? extends Compra> items) throws Exception {
		System.out.println("+++ Iniciando " + this.getClass().getSimpleName() + " +++");

		for(Compra compra : items) {
			System.out.println(compra.toString());
			String conteudo = compra.toString() + "\n";
			FileWriter fw = new FileWriter(fileName, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(conteudo);
		    bw.newLine();
		    bw.close();
		}



	}

}
