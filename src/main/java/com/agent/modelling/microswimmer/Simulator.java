package com.agent.modelling.microswimmer;

import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_GRID_HEIGHT;
import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_GRID_WIDTH;
import static com.agent.modelling.microswimmer.Constants.Constants.MINIMUM_COORDINATE_VALUE;


import com.agent.modelling.microswimmer.Grid.Grid;
import com.agent.modelling.microswimmer.View.GridView;
import com.agent.modelling.microswimmer.Models.Coordinate;
import com.agent.modelling.microswimmer.Models.Microswimmer;
import com.agent.modelling.microswimmer.Services.CoordinateService;
import com.agent.modelling.microswimmer.Services.MicroswimmerService;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Simulator {
    private LinkedHashMap<Microswimmer, Coordinate> microSwimmerHashMap;
    private List<Coordinate> coordinates;
    private CoordinateService coordinateService;
    private GridView view;
    private MicroswimmerService microswimmerService;
    private int totalCollisionCount;
    private int numberOfMicroswimmers;

    public Simulator(int numberOfMicroswimmers){
        microSwimmerHashMap = new LinkedHashMap<>();
        coordinateService = new CoordinateService();
        microswimmerService = new MicroswimmerService();
        totalCollisionCount = 0;
        //Create a view of the simulation
        view = new GridView(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
        view.setColor(Microswimmer.class, Color.BLUE);

        //Setup Grid
        Grid grid = new Grid(DEFAULT_GRID_WIDTH, DEFAULT_GRID_HEIGHT);
        coordinates = grid.getGridCoordinates();

        // Setup MicroSwimmer Coordinates
        setupMicroSwimmers(numberOfMicroswimmers);
    }

    private int generateRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private void setupMicroSwimmers(int numberOfMicroswimmers){
        for(int i=0; i < numberOfMicroswimmers; i++){
            int x = generateRandomNumber(MINIMUM_COORDINATE_VALUE, DEFAULT_GRID_HEIGHT);
            int y = generateRandomNumber(MINIMUM_COORDINATE_VALUE, DEFAULT_GRID_HEIGHT);

            Coordinate matchingCoordinate =
                    coordinates
                            .stream()
                            .filter((coordinate) -> x == coordinate.getxCoordinate() && y == coordinate.getyCoordinate())
                            .findAny()
                            .orElse(null);

            Microswimmer assignedMicroSwimmer = new Microswimmer();
            assignedMicroSwimmer.setId(i);

            if(matchingCoordinate != null){
                microSwimmerHashMap.put(assignedMicroSwimmer, matchingCoordinate);
            }
        }
    }

    // TODO Will need to change this method so that it will take in a parameter of how many number of runs the while loop
    // should go through before it reaches the end. This can then be run via a test and results can be printed to console.
    public void runSimulation(boolean run){
        boolean shouldRunProgramme = run;

        while (shouldRunProgramme){
            int collisionCount = 0;
            // get next set of positions and render
            LinkedHashMap<Microswimmer, Coordinate> updatedCoordinates =
                coordinateService.updateCoordinates(microSwimmerHashMap);

            // Collision check
            List<Microswimmer> microswimmersCollision =
                    microswimmerService.getMicroswimmerCollisions(updatedCoordinates);

            totalCollisionCount += microswimmersCollision.size();
            // Pass into the renderer the previous values and the updated ones
            // list of microswimmers that are in collision.

            // if any of the new positions are the same get them and set to red.
            // if not set to blue
            //pass to render method
            System.out.println("Collision Count: " + collisionCount);
            System.out.println("Total Collision Count: " + totalCollisionCount);

            //render
            //view.updateView(updatedCoordinates);
        }
    }
}
