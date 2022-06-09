package br.com.mbs.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mbs.batch.item.ProdutoProcessor;
import br.com.mbs.batch.item.ProdutoReader;
import br.com.mbs.batch.item.ProdutoWriter;
import br.com.mbs.entidades.Compra;

@Configuration
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public ProdutoReader produtoReader() {
		return new ProdutoReader();
	}

	@Bean
	public ProdutoProcessor produtoProcessor() {
		return new ProdutoProcessor();
	}

	@Bean
	public ProdutoWriter produtoWriter() {
		return new ProdutoWriter();
	}

	@Bean
	public Job processJob(ProdutoReader produtoReader,
						  ProdutoProcessor produtoProcessor,
						  ProdutoWriter produtoWriter) {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer())
				.flow(orderStep1(produtoReader,
						produtoProcessor,
						produtoWriter)).end().build();
	}

	@Bean
	public Step orderStep1(ProdutoReader produtoReader,
			ProdutoProcessor produtoProcessor,
			ProdutoWriter produtoWriter) {
		return stepBuilderFactory.get("orderStep1").
				<Compra, Compra> chunk(1)
				.reader(produtoReader)
				.processor(produtoProcessor)
				.writer(produtoWriter)
				.build();
	}


}