package br.com.mbs.dados;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "modulo-endereco",
url = "http://localhost:9091/estoque/")
public interface EstoqueDados {

	@RequestMapping(value = "/verificar-estoque/{id}/{quantidade}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> verificarEstoque(
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) throws Exception;

	@RequestMapping(value = "/atualizar-estoque/{id}/{quantidade}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> atualizaEstoque(
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) throws Exception;

}
