package com.agent.modelling.microswimmer.Services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.agent.modelling.microswimmer.Models.Microswimmer;
import com.agent.modelling.microswimmer.Models.Coordinate;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Test;

public class MicroswimmerServiceTest {
    @Test
    public void AssertCollisionsReturnsCollisionMicroswimmers(){
        MicroswimmerService service = new MicroswimmerService();
        LinkedHashMap<Microswimmer, Coordinate> testCoordinates = new LinkedHashMap<>();

        Microswimmer oneMicro = new Microswimmer();
        oneMicro.setId(1);

        Microswimmer twoMicro = new Microswimmer();
        twoMicro.setId(2);

        Microswimmer threeMicro = new Microswimmer();
        threeMicro.setId(3);

        Coordinate oneCoordinate = new Coordinate();
        oneCoordinate.setxCoordinate(0);
        oneCoordinate.setyCoordinate(0);

        Coordinate twoCoordinate = new Coordinate();
        twoCoordinate.setxCoordinate(1);
        twoCoordinate.setyCoordinate(1);

        Coordinate threeCoordinate = new Coordinate();
        threeCoordinate.setxCoordinate(0);
        threeCoordinate.setyCoordinate(0);

        testCoordinates.put(oneMicro, oneCoordinate);
        testCoordinates.put(twoMicro, twoCoordinate);
        testCoordinates.put(threeMicro, threeCoordinate);

        //When
        List<Microswimmer> result = service.getMicroswimmerCollisions(testCoordinates);

        assertNotNull(result);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0).getId(), oneMicro.getId());
        assertEquals(result.get(1).getId(), threeMicro.getId());
    }
}
