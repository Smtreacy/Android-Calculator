package com.example.steven.androidcalculatorbuttons;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class CalcControllerUnitTest {
    @Test
    public void operationArrayOrder () {
        assertEquals("+", CalcController.operations[0]);
    }
    @Test
    public void calculateAddition() {
        //refreshes the equation so that way older tests are not stored
        CalcController._equation = "";
        CalcController.insert("2");
        CalcController.insert("+");
        CalcController.insert("2");
        double answer = CalcController.calculate();
        assertEquals(answer, 4, 0.00);
    }
    @Test
    public void calculateSubtraction() {
        //refreshes the equation so that way older tests are not stored
        CalcController._equation = "";
        CalcController.insert("6");
        CalcController.insert("-");
        CalcController.insert("2");
        double answer = CalcController.calculate();
        assertEquals(answer, 4, 0.00);
    }
}
