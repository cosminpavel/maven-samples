package com.lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Cosmin on 11/13/2017.
 */
public class BigDecimalOperations {
    public static BigDecimal sumOfList(List<BigDecimal> list){
        final Optional<BigDecimal> sum = list.stream().reduce(BigDecimal::add);

        return sum.get();
    }
    public static BigDecimal averageOfList(List<BigDecimal> list){
        return sumOfList(list).divide(new BigDecimal(String.valueOf(list.size())));
    }
    public static List<BigDecimal> biggestTenProcent(List<BigDecimal> list){
        final List<BigDecimal> tenProcentlist = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(list.size()/10)
                .collect(Collectors.toList());
        return tenProcentlist;
    }

}
