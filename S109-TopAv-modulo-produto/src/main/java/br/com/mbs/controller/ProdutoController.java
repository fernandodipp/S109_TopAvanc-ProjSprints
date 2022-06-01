package br.com.mbs.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.entidades.Compra;
import br.com.mbs.entidades.Produto;
import br.com.mbs.service.ProdutoService;
import br.com.mbs.dados.EstoqueDados;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController(value = "API para manipulacao de produtos")
@RequestMapping("produto")
@Api(description = "Api de produtos - Sprint Atual = 3 imcompleta")
public class ProdutoController {
	
	@Autowired
	private EstoqueDados estoqueDados;
	
	ProdutoService produtoService = new ProdutoService();

	@RequestMapping(value = "/cadastrarProduto/", method = RequestMethod.POST)
	public ResponseEntity<Produto> cadastrarProduto(
			@RequestParam("marcaProduto") String marcaProduto,
			@RequestParam("modeloProduto") String modeloProduto, 
			@RequestParam("precoProduto") float precoProduto,
			@RequestParam("quantidadeProduto") Integer quantidadeProduto) throws Exception {
		System.out.println("Executando controller/cadastrarProduto/");
		int retorno = 0;
		Produto produto = new Produto();
		produto.marcaProduto = marcaProduto;
		produto.modeloProduto = modeloProduto;
		produto.precoProduto = precoProduto;
		produto.quantidadeProduto = quantidadeProduto;
		retorno = produtoService.inserirProduto(produto);
		if (retorno == 400) {
			System.out.println("Retorno de controller/cadastrarProduto/ " + retorno);
			return new ResponseEntity<>(produto, HttpStatus.BAD_REQUEST);
		} else if (retorno == 409) {
			System.out.println("Retorno de controller/cadastrarProduto/ " + retorno);
			return new ResponseEntity<>(produto, HttpStatus.CONFLICT);
		} else
			System.out.println("Retorno de controller/cadastrarProduto/ " + retorno);
			estoqueDados.atualizaEstoque(produto.idProduto, produto.quantidadeProduto);
			return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Salvar um produto via JSON")
	@RequestMapping(value = "/cadastrarProdutoJson/", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON })
	public ResponseEntity<Integer> cadastrarProdutoJson(@RequestBody Produto produto) throws Exception {
		System.out.println("Executando controller/cadastrarProdutoJson/");
		int retorno = 0;
		produto.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		retorno = produtoService.inserirProduto(produto);
		if (retorno == 400) {
			System.out.println("Retorno de controller/cadastrarProdutoJson/ " + retorno);
			return new ResponseEntity<>(retorno, HttpStatus.BAD_REQUEST);
		} else if (retorno == 409) {
			System.out.println("Retorno de controller/cadastrarProdutoJson/ " + retorno);
			return new ResponseEntity<>(retorno, HttpStatus.CONFLICT);
		} else
			System.out.println("Retorno de controller/cadastrarProdutoJson/ " + retorno);
		estoqueDados.atualizaEstoque(produto.idProduto, produto.quantidadeProduto);
		return new ResponseEntity<>(retorno, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/buscarProdutoId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscarProdutoId(@PathVariable("id") Integer idProduto) throws Exception {
		System.out.println("Executando controller/buscar-id");
		Produto produtoBuscado = produtoService.buscarIdProduto(idProduto);
		if (produtoBuscado.idProduto == null) {
			return new ResponseEntity<Produto>(produtoBuscado, HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<Produto>(produtoBuscado, HttpStatus.OK);
	}

	@RequestMapping(value = "/listarProdutos/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Produto>> listarProdutos() throws Exception {
		System.out.println("Processando listarProduto");
		return new ResponseEntity<Collection<Produto>>(produtoService.listarTodosProdutos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/comprarProduto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> comprarProduto(@PathVariable("id") Integer idProduto,
			@RequestParam("quantidade") Integer quantidade, @RequestParam("comprador") String comprador) throws Exception {
		System.out.println("Processando listarProduto");
		Compra produtoComprado =  produtoService.realizarCompra(idProduto, quantidade, comprador);
		if (produtoComprado.idCompra == null) {			
			return new ResponseEntity<Compra>(produtoComprado, HttpStatus.BAD_REQUEST);
		} else
			estoqueDados.atualizaEstoque(idProduto, quantidade);
			return new ResponseEntity<Compra>(produtoComprado, HttpStatus.OK);
	}

	@RequestMapping(value = "/listarCompras/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Compra>> listarCompras() throws Exception {
		System.out.println("Processando listarCompras");
		return new ResponseEntity<Collection<Compra>>(produtoService.listarTodasCompras(), HttpStatus.OK);
	}

	@RequestMapping(value = "/executaLoteComprasAcima10/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Compra>> executaLoteComprasAcima10() throws Exception {
		System.out.println("Processando listarProduto");
		// TODO: Funcionalidade: ao ser chamado, deve-se executar uma rotina em lote,
		// escrevendo em arquivo
		// todas as compras feitas, com valor do produto acima de R$10,00.
		return null;
	}

	@RequestMapping(value = "/deletar-id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletarProduto(@PathVariable("id") Integer idProduto) throws Exception {
		System.out.println("Processando deletarProduto");
		String produtoApagado = produtoService.buscarIdProduto(idProduto).toString();
		int retorno = produtoService.removerProduto(idProduto);
		if (retorno == 404) {
			return new ResponseEntity<>("Produto não existe na base de dados", HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<>("Produto apagado com sucesso " + produtoApagado, HttpStatus.OK);
	}

	@RequestMapping(value = "/atualizar-id/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") Integer id,
			@RequestParam("marcaProduto") String marcaProduto, @RequestParam("modeloProduto") String modeloProduto,
			@RequestParam("precoProduto") float precoProduto,
			@RequestParam("quantidadeProduto") Integer quantidadeProduto) throws Exception {
		System.out.println("Processando atualizarProduto");
		Produto produto = new Produto();
		produto.idProduto = id;
		produto.marcaProduto = marcaProduto;
		produto.modeloProduto = modeloProduto;
		produto.precoProduto = precoProduto;
		produto.quantidadeProduto = quantidadeProduto;
		int retorno = produtoService.alterarProduto(produto, id);
		if (retorno == 400) {
			return new ResponseEntity<Produto>(produto, HttpStatus.BAD_REQUEST);
		}
		if (retorno == 404) {
			return new ResponseEntity<Produto>(produto, HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

}
