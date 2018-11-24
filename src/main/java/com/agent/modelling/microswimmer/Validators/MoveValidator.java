package com.agent.modelling.microswimmer.Validators;

import static com.agent.modelling.microswimmer.Constants.Constants.DEFAULT_GRID_HEIGHT;
import static com.agent.modelling.microswimmer.Constants.Constants.MINIMUM_COORDINATE_VALUE;

public class MoveValidator {

    public boolean isValidMove(int x, int y){
        boolean isValid = true;

        if(x > DEFAULT_GRID_HEIGHT || y > DEFAULT_GRID_HEIGHT
            || y < MINIMUM_COORDINATE_VALUE || x < MINIMUM_COORDINATE_VALUE){
            isValid = false;
        }

        return isValid;
    }
}
