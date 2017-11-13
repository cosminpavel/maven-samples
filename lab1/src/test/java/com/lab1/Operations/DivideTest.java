package com.lab1.Operations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class DivideTest {
    private Divide divide;
    @Before
    public void setUp(){
        divide = new Divide();
    }
    @Test
    public void calculate(){
        assert(divide.calculate(1,2) == 0.5);
        assert(divide.calculate(5,5) == 1.0);
    }

}