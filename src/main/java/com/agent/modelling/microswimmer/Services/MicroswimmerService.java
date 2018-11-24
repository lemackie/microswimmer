package com.agent.modelling.microswimmer.Services;

import com.agent.modelling.microswimmer.Models.Coordinate;
import com.agent.modelling.microswimmer.Models.Microswimmer;

import java.util.*;

public class MicroswimmerService {

    public List<Microswimmer> getMicroswimmerCollisions(HashMap<Microswimmer, Coordinate> updatedCoordinates)
    {
        List<Microswimmer> collisionMicroswimmers = new ArrayList<Microswimmer>();
        LinkedHashMap<Microswimmer, Coordinate> coordinatesToCompare = new LinkedHashMap<>(updatedCoordinates);

        for(Map.Entry<Microswimmer, Coordinate> updatedCoordinatesEntry : updatedCoordinates.entrySet()){
            Microswimmer updatedMicroswimmer = updatedCoordinatesEntry.getKey();
            Coordinate updatedCoordinate = updatedCoordinatesEntry.getValue();

            for(Map.Entry<Microswimmer, Coordinate> comparisonCoordinateEntry : coordinatesToCompare.entrySet()){
                Microswimmer comparisonMicroswimmer = comparisonCoordinateEntry.getKey();
                Coordinate comparisonCoordinate = comparisonCoordinateEntry.getValue();

                if(updatedMicroswimmer.getId() != comparisonMicroswimmer.getId()
                        && updatedCoordinate.getxCoordinate() == comparisonCoordinate.getxCoordinate()
                        && updatedCoordinate.getyCoordinate() == comparisonCoordinate.getyCoordinate())
                {
                    collisionMicroswimmers.add(updatedMicroswimmer);
                }
            }
        }

        return collisionMicroswimmers;
    }

}
