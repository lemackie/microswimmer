package com.agent.modelling.microswimmer.Services;

import static com.agent.modelling.microswimmer.Constants.Constants.MAXIMUM_STEP_MOVE;

import com.agent.modelling.microswimmer.Models.Coordinate;
import com.agent.modelling.microswimmer.Models.Microswimmer;
import com.agent.modelling.microswimmer.Validators.MoveValidator;

import java.util.*;

public class CoordinateService {

    private MoveValidator validator;

    public CoordinateService(){
        validator = new MoveValidator();
    }

    public LinkedHashMap<Microswimmer, Coordinate> updateCoordinates(HashMap<Microswimmer, Coordinate> microSwimmerPositions){
        LinkedHashMap<Microswimmer, Coordinate> newMicroSwimmerPositions = new LinkedHashMap<>();

        for(Map.Entry<Microswimmer, Coordinate> entry : microSwimmerPositions.entrySet()){
            Coordinate coordinate = entry.getValue();

            List<Coordinate> possibleMoveCoordinates = getPossibleMoveCoordinates(coordinate);
            Coordinate validCoordinate = getValidCoordinates(coordinate, possibleMoveCoordinates);

            newMicroSwimmerPositions.put(entry.getKey(), validCoordinate);
        }

        return newMicroSwimmerPositions;
    }


    public Coordinate getValidCoordinates(Coordinate currentCoordinate, List<Coordinate> possibleMoveCoordinates) {
        possibleMoveCoordinates
            .removeIf(
                c -> c.getxCoordinate() == currentCoordinate.getxCoordinate()&&
                    c.getyCoordinate() == currentCoordinate.getyCoordinate() &&
                    !validator.isValidMove(c.getxCoordinate(), c.getyCoordinate())
            );

        Random rand = new Random();
        return possibleMoveCoordinates.get(rand.nextInt(possibleMoveCoordinates.size()));
    }

    public List<Coordinate> getPossibleMoveCoordinates(Coordinate currentCoordinate){
        List<Coordinate> possibleMoves = new ArrayList<>();

        int currentXValue = currentCoordinate.getxCoordinate();
        int currentYValue = currentCoordinate.getyCoordinate();

        int minXCoordinate = currentXValue - MAXIMUM_STEP_MOVE;
        int maxXCoordinate = currentXValue + MAXIMUM_STEP_MOVE;

        int minYCoordinate = currentYValue - MAXIMUM_STEP_MOVE;
        int maxYCoordinate = currentYValue + MAXIMUM_STEP_MOVE;

        for(int i = minXCoordinate; i <= maxXCoordinate; i++){
            for(int y = minYCoordinate; y <= maxYCoordinate; y++ ){
                Coordinate coordinate = new Coordinate();

                coordinate.setxCoordinate(i);
                coordinate.setyCoordinate(y);

                possibleMoves.add(coordinate);
            }
        }

        return possibleMoves;
    }
}
