package com.lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/16/2017.
 */
public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
       calculator = new Calculator();
    }
    @Test
    public void operationParser() throws Exception {
        String expression = "1 + 2";
        assert(calculator.operationParser(expression) == 3.0);
        expression = "-1 - 2";
        assert(calculator.operationParser(expression) == -3.0);
        expression = "1 * 2";
        assert(calculator.operationParser(expression) == 2.0);
        expression = "5 / 2";
        assert(calculator.operationParser(expression) == 2.5);
        expression = "5 min 7";
        assert(calculator.operationParser(expression) == 5.0);
        expression = "5 max 7";
        assert(calculator.operationParser(expression) == 7.0);
        expression = "sqrt 9";
        assert(calculator.operationParser(expression) == 3.0);
    }

}