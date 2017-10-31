package com.lab1;

import com.lab1.Operations.*;
import com.lab1.OperationsInterface.BinaryOperation;
import com.lab1.OperationsInterface.Operation;
import com.sun.org.apache.xpath.internal.operations.Mult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cosmin on 10/3/2017.
 */
public class Calculator {
    Map<String,BinaryOperation> mapBynaryOperations;
    Map<String,Operation> mapOperations;

    public Calculator() {
        mapBynaryOperations = new HashMap<>();
        mapOperations = new HashMap<>();
        Sum sum = new Sum();
        mapBynaryOperations.put("+",sum);

        Substract substract = new Substract();
        mapBynaryOperations.put("-",substract);

        Multiply multiply = new Multiply();
        mapBynaryOperations.put("*",multiply);

        Divide divide = new Divide();
        mapBynaryOperations.put("/",divide);

        Max max = new Max();
        mapBynaryOperations.put("max", max);

        Min min = new Min();
        mapBynaryOperations.put("min", min);

        Sqrt sqrt = new Sqrt();
        mapOperations.put("sqrt",sqrt);
    }
    public boolean isBynaryOperator(String str){
        if(mapBynaryOperations.containsKey(str)){
            return true;
        }
        return false;
    }
    public boolean isOperator(String str){
        if(mapOperations.containsKey(str)){
            return true;
        }
        return false;
    }
    public double operationParser(String str){
        System.out.println(str);
        String[] opSplitArray = str.split(" ");
        //System.out.println(opSplitArray.toString());
        if(isBynaryOperator(opSplitArray[1])){
            BinaryOperation binaryOperation = mapBynaryOperations.get(opSplitArray[1]);
             return binaryOperation.calculate(Double.parseDouble(opSplitArray[0]),Double.parseDouble(opSplitArray[2]));
        }
        if(isOperator(opSplitArray[0])){
            Operation operation = mapOperations.get(opSplitArray[0]);
            return operation.calculate(Double.parseDouble(opSplitArray[1]));
        }
       return 0;
    }
}
