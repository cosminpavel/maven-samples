package com.lab4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 11/27/2017.
 */
public class ValidatorTest {
    @Test
    public void validName() throws Exception {
        assertTrue(Validator.validName("Vladimir"));
        assertFalse(Validator.validName("Andrei.a"));
    }

    @Test
    public void validCNP() throws Exception {
        assertFalse(Validator.validCNP("1961323240011"));
        assertTrue(Validator.validCNP("1960923240011"));
    }

    @Test
    public void validEmail() throws Exception {
        assertFalse(Validator.validEmail("Alexandruoutlook.com"));
        assertTrue(Validator.validEmail("Alexa.ndru@outlook.com"));
    }

}