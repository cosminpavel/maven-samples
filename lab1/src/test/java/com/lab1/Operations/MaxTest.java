package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class MaxTest{
    private Max max;
    @Before
    public void setUp(){
        max = new Max();
    }
    @Test
    public void calculate(){
        assert(max.calculate(1,2) == 2.0);
        assert(max.calculate(-3,2) == 2.0);

    }


}