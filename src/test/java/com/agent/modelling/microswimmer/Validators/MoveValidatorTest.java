package com.agent.modelling.microswimmer.Validators;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MoveValidatorTest {

    @Test
    public void AssertValidatorMethodReturnsFalseWhenProvidedWithInvalidCoordinates(){
        // Given invalid coordinates
        MoveValidator validator = new MoveValidator();

        int x = -50;
        int y = -200;

        // When
        boolean result = validator.isValidMove(x, y);

        // Then
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void AssertValidatorMethodReturnsTrueWhenProvidedWithValidCoordinates(){
        // Given invalid coordinates
        MoveValidator validator = new MoveValidator();

        int x = 50;
        int y = 50;

        // When
        boolean result = validator.isValidMove(x, y);

        // Then
        assertNotNull(result);
        assertTrue(result);
    }
}
