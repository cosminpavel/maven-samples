package com.lab2;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Cosmin on 11/13/2017.
 */
public class BigDecimalOperationsTest {
    @Test
    public void sumOfList() throws Exception {
        List<BigDecimal> list = new ArrayList<>();
        for(int i=1 ;i <= 100;i++){
            list.add(new BigDecimal(String.valueOf(i)));
        }

        assert(BigDecimalOperations.sumOfList(list).equals(new BigDecimal(String.valueOf(5050))));
    }

    @Test
    public void averageOfList() throws Exception {
        List<BigDecimal> list = new ArrayList<>();
        for(int i=1 ;i <= 100;i++){
            list.add(new BigDecimal(String.valueOf(i)));
        }
        assert(BigDecimalOperations.averageOfList(list).equals(new BigDecimal(String.valueOf(50.5))));

    }

    @Test
    public void biggestTenProcent() throws Exception {
        List<BigDecimal> list = new ArrayList<>();
        for(int i=0 ;i < 100;i++){
            list.add(new BigDecimal(String.valueOf(i)));
        }
        Collections.shuffle(list);
        List<BigDecimal> top10Percent = new ArrayList<>();
        for(int i=99 ;i >= 90;i--){
            top10Percent.add(new BigDecimal(String.valueOf(i)));
        }
        assert(BigDecimalOperations.biggestTenProcent(list).equals(top10Percent));
    }

}