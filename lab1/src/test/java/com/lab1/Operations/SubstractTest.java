package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class SubstractTest {
    Substract substract;
    @Before
    public void setUp() throws Exception {
        substract = new Substract();
    }
    @Test
    public void calculate() throws Exception {
        assert(substract.calculate(5,2) == 3.0);
        assert(substract.calculate(-5,2) == -7.0);

    }

}