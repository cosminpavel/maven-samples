package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class SumTest {
    Sum sum;
    @Before
    public void setUp() throws Exception {
        sum = new Sum();
    }
    @Test
    public void calculate() throws Exception {
        assert(sum.calculate(1,2) == 3);
        assert(sum.calculate(-1,-2) == -3);

    }

}