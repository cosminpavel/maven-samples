package com.lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 10/16/2017.
 */
public class OperationsTest {
    Operations operations;
    @Before
    public void setUp() throws Exception {
        operations = new Operations();
    }
    @Test
    public void sum() throws Exception {
        assert(operations.sum(5,5) == 10.0);
    }

    @Test
    public void substract() throws Exception {
        assert(operations.substract(15,5) == 10.0);
    }

    @Test
    public void divide() throws Exception {
        assert(operations.divide(50,5) == 10.0);
    }

    @Test
    public void multiply() throws Exception {
        assert(operations.multiply(2,5) == 10.0);
    }

    @Test
    public void max() throws Exception {
        assert(operations.max(5,3) == 5.0);
    }

    @Test
    public void min() throws Exception {
        assert(operations.min(5,8) == 5.0);
    }

    @Test
    public void sqrt() throws Exception {
        assert(operations.sqrt(25) == 5.0);
    }

}