package click.techlabs.pgp.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.kafka.core.KafkaTemplate;

import click.techlabs.pgp.domain.Simulation;

public class SimulationService {

	private KafkaTemplate<String, Map<String, String>> template;

	
	private Executor executor;
	
	
	public SimulationService(KafkaTemplate<String, Map<String, String>> template, Executor executor) {
		super();
		this.template = template;
		this.executor = executor;
	}


	public CompletableFuture<Void> createSimulation(Simulation simulation) {
		CompletableFuture[] futures = new CompletableFuture[simulation.getMarketWiseData().size()];
		AtomicInteger i = new AtomicInteger(-1);
		simulation.getMarketWiseData().forEach((k, v) -> {
			CompletableFuture<Void> f = CompletableFuture.runAsync(new LoadSimulator<Map<String, String>>(template, simulation.getTopic(), String.valueOf(v.getMarketId()), v.getMessage(), v.getTotalMessageCount()), executor);
			futures[i.incrementAndGet()] = f;
		});
		
		return CompletableFuture.allOf(futures);
	}
}
