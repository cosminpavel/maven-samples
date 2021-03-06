package com.lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Cosmin on 10/31/2017.
 */
public class Main {
    public static BigInteger sumOfList(List<BigInteger> list){
        final BigInteger sum = list.stream().reduce(BigInteger.ZERO,BigInteger::add);

        return sum;
    }
    public static BigInteger averageOfList(List<BigInteger> list){
        return sumOfList(list).divide(new BigInteger(String.valueOf(list.size())));
    }
    public static List<BigInteger> biggestTenProcent(List<BigInteger> list){
        final List<BigInteger> tenProcentlist = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(list.size()/10)
                .collect(Collectors.toList());
        return tenProcentlist;
    }
    public static void main(String[] args) {
        List<BigInteger> list = new ArrayList<>();
        for(int i=0 ;i < 100;i++){
            list.add(new BigInteger(String.valueOf(i)));
        }
        System.out.println(sumOfList(list));
        System.out.println(averageOfList(list));
        List<BigInteger> tenProcent = biggestTenProcent(list);
        for (BigInteger i:
             tenProcent) {
            System.out.println(i);
        }
        List<BigDecimal> bigDecimalsList = BigDecimalGenerator.generate(10);
        String file = "..\\maven-samples\\lab3\\src\\main\\resources\\bigDecimals.txt";

        BigDecimalsSerialize bigDecimalsSerialize = new BigDecimalsSerialize();
        bigDecimalsSerialize.serializeBigDecimals(file,bigDecimalsList);
        System.out.println(bigDecimalsSerialize.deserializeBigDecimals(file));

    }
}
