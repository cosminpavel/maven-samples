package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class DivideTest {
    Divide divide;
    @Before
    public void setUp() throws Exception {
        divide = new Divide();
    }
    @Test
    public void calculate() throws Exception {
        assert(divide.calculate(1,2) == 0.5);
        assert(divide.calculate(5,5) == 1.0);
    }

}