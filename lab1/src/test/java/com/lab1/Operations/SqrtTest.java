package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class SqrtTest {
    private Sqrt sqrt;
    @Before
    public void setUp() throws Exception {
        sqrt = new Sqrt();
    }
    @Test
    public void calculate() {
        assert(sqrt.calculate(9) == 3.0);
        assert(sqrt.calculate(625) == 25.0 );
    }

}