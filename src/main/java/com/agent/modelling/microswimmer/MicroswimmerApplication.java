package com.agent.modelling.microswimmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_MICROSWIMMERS;
import com.agent.modelling.microswimmer.Simulator;


@SpringBootApplication
public class MicroswimmerApplication {

	public static void main(String[] args) {SpringApplication.run(MicroswimmerApplication.class, args);}

		Simulator simulator. = new Simulator(DEFAULT_MICROSWIMMERS);
	    simulator.runSimulation();

}
