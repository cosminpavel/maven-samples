package com.lab2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 11/13/2017.
 */
public class BigDecimalsSerializeTest {
    private BigDecimalsSerialize bigDecimalsSerialize;
    private List<BigDecimal> list;
    private String file;
    @Before
    public void setUp(){
        bigDecimalsSerialize = new BigDecimalsSerialize();
        list = new ArrayList<>();
        file = "..\\lab3\\src\\test\\resources\\bigDecimalTest.txt";
    }
    @After
    public void tearDown(){
        list.clear();
    }
    @Test
    public void serialDeserial5000() throws Exception {
        list = BigDecimalGenerator.generate(5000);
        bigDecimalsSerialize.serializeBigDecimals(file,list);
        List<BigDecimal> deserialList = new ArrayList<>();
        deserialList = bigDecimalsSerialize.deserializeBigDecimals(file);
        for(int i = 0; i  < 5000 ;i++){
            assert(list.get(i).equals(deserialList.get(i)));
        }


    }

    @Test
    public void serialDeserial100000() throws Exception {
        list = BigDecimalGenerator.generate(100000);
        bigDecimalsSerialize.serializeBigDecimals(file,list);
        List<BigDecimal> deserialList = new ArrayList<>();
        deserialList = bigDecimalsSerialize.deserializeBigDecimals(file);
        for(int i = 0; i  < 100000 ;i++){
            assert(list.get(i).equals(deserialList.get(i)));
        }

    }

}