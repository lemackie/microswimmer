package com.agent.modelling.microswimmer.Grid;

import com.agent.modelling.microswimmer.Models.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Coordinate> coordinates;

    public Grid(int width, int height){
        coordinates = new ArrayList<>();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Coordinate coordinate = new Coordinate();

                coordinate.setxCoordinate(x);
                coordinate.setyCoordinate(y);

                coordinates.add(coordinate);
            }
        }
    }

    public List<Coordinate> getGridCoordinates(){
        return coordinates;
    }
}
