package com.lab2;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.control.PasswordField;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 10/31/2017.
 */
public class Main {
    public static BigInteger sumOfList(List<BigInteger> list){
        final BigInteger sum = list.stream().reduce(BigInteger.ZERO,BigInteger::add);

        return sum;
    }
    public static BigInteger averageOfList(List<BigInteger> list){

    }
    public static void main(String[] args) {
        List<BigInteger> list = new ArrayList<>();
        for(int i=0 ;i < 100;i++){
            list.add(new BigInteger(String.valueOf(i)));
        }
        System.out.println(sumOfList(list));

    }
}
