package com.lab2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cosmin on 11/13/2017.
 */
public class BigDecimalGenerator {
    public static List<BigDecimal> generate(int size){
        List<BigDecimal> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++){
            list.add(new BigDecimal(random.nextInt() + "." + Math.abs(random.nextInt())));
        }

        return list;
    }
}
