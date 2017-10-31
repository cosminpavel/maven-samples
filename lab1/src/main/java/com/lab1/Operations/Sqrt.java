package com.lab1.Operations;

import com.lab1.OperationsInterface.Operation;

/**
 * Created by Cosmin on 10/25/2017.
 */
public class Sqrt implements Operation {

    @Override
    public double calculate(double a) {
        return Math.sqrt(a);
    }
}
