package com.lab1.Operations;

import com.lab1.OperationsInterface.BinaryOperation;

/**
 * Created by Cosmin on 10/25/2017.
 */
public class Min implements BinaryOperation {
    @Override
    public double calculate(double a, double b) {
        return Math.min(a,b);
    }
}