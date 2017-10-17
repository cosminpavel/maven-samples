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
       Operations operations = new Operations();
       calculator = new Calculator(operations);
    }
    @Test
    public void operationParser() throws Exception {
        String expression = "1+2";
        assert(calculator.operationParser(expression) == 3.0);
        expression = "1-2";
        assert(calculator.operationParser(expression) == -1.0);
        expression = "1*2";
        assert(calculator.operationParser(expression) == 2.0);
        expression = "5/2";
        assert(calculator.operationParser(expression) == 2.5);
        expression = "min(5,7)";
        assert(calculator.operationParser(expression) == 5.0);
        expression = "max(5,7)";
        assert(calculator.operationParser(expression) == 7.0);
        expression = "sqrt9";
        assert(calculator.operationParser(expression) == 3.0);
    }

}