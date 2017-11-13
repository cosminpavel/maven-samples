package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class MinTest{
    private Min min;
    @Before
    public void setUp(){
        min = new Min();
    }
    @Test
    public void calculate(){
        assert(min.calculate(1,3) == 1.0);
        assert(min.calculate(-5,4) == -5.00);
    }

}