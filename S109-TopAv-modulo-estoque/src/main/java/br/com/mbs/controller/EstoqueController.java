package br.com.mbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.service.EstoqueService;
import io.swagger.annotations.Api;

@RestController(value = "API para manipulacao de estoque")
@RequestMapping("estoque")
@Api(description = "Api de estoque - Sprint Atual = 2 incompleta")
public class EstoqueController {

	EstoqueService estoqueService = new EstoqueService();

	@RequestMapping(value = "/verificar-estoque/{id}/{quantidade}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> verificarEstoque(
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) throws Exception {
		Boolean retorno = estoqueService.verificarEstoque(id, quantidade);
		if (retorno) {
			return new ResponseEntity<Boolean>(retorno, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(retorno, HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(value = "/atualizar-estoque/{id}/{quantidade}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> atualizaEstoque(
			@PathVariable("id") Integer id,
			@PathVariable("quantidade") Integer quantidade) throws Exception {
		Boolean retorno = estoqueService.verificarEstoque(id);
		if (retorno == false) {
			estoqueService.atualizarEstoque(id, quantidade);
			return new ResponseEntity<Boolean>(retorno, HttpStatus.OK);
		} else if (estoqueService.verificarEstoque(id, quantidade) == true) {
			estoqueService.atualizarEstoque(id, quantidade);
			return new ResponseEntity<Boolean>(retorno, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(retorno, HttpStatus.BAD_REQUEST);

	}

}
