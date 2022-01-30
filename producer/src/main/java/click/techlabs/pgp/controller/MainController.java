package click.techlabs.pgp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import click.techlabs.pgp.domain.Simulation;
import click.techlabs.pgp.service.SimulationService;

@RestController
public class MainController {

	@Autowired
	private SimulationService service;
	
	@Async
	@PostMapping("/simulation")
	public void simulation(@RequestBody Simulation simulation) {
		service.createSimulation(simulation);
	}
}
