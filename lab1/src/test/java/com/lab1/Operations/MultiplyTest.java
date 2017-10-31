package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class MultiplyTest {
    Multiply multiply;
    @Before
    public void setUp() throws Exception {
        multiply = new Multiply();
    }
    @Test
    public void calculate() throws Exception {
        assert(multiply.calculate(2,3) == 6.0);
        assert(multiply.calculate(5,-2) == -10.0);
    }

}