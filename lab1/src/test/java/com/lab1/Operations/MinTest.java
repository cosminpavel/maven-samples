package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class MinTest {
    Min min;
    @Before
    public void setUp() throws Exception {
        min = new Min();
    }
    @Test
    public void calculate() throws Exception {
        assert(min.calculate(1,3) == 1.0);
        assert(min.calculate(-5,4) == -5.00);
    }

}