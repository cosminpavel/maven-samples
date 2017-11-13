package com.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 11/13/2017.
 */
public class BigDecimalGeneratorTest {
    @Test
    public void generate() throws Exception {
        assert(BigDecimalGenerator.generate(50).size() == 50);
    }

}