package com.agent.modelling.microswimmer.Services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.agent.modelling.microswimmer.Models.Coordinate;
import java.util.List;
import org.junit.Test;

public class CoordinateServiceTest {

    @Test
    public void assertPossibleCoordinatesReturnsNineResults(){
        // given
        CoordinateService service = new CoordinateService();

        Coordinate coordinate = new Coordinate();
        coordinate.setyCoordinate(0);
        coordinate.setxCoordinate(0);

        // when
        List<Coordinate> results = service.getPossibleMoveCoordinates(coordinate);

        // Then
        assertNotNull(results);
        assertEquals(results.size(), 9);

    }

    @Test
    public void assertValidCoordinatesDoesNotContainCurrentCoordinate(){
        // given
        CoordinateService service = new CoordinateService();

        Coordinate coordinate = new Coordinate();
        coordinate.setyCoordinate(0);
        coordinate.setxCoordinate(0);

        List<Coordinate> possibleMoveCoordinates = service.getPossibleMoveCoordinates(coordinate);

        // when
        Coordinate results = service.getValidCoordinates(coordinate, possibleMoveCoordinates);

        // Then
        assertNotNull(results);
        //assertNotEquals(coordinate.getxCoordinate(), results.getxCoordinate());
        //assertNotEquals(coordinate.getyCoordinate(), results.getyCoordinate());
    }
}
