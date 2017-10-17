package com.lab1;

/**
 * Created by Cosmin on 10/3/2017.
 */
public class Calculator {
    private Operations operations;
    private static final String[] actions={"+","-","/","*"};

    public Calculator(Operations operations) {
        this.operations = operations;
    }
    public double operationParser(String str){
        if(str.split("[+]").length>1){
            String[] operators = str.split("[+]");
            return operations.sum(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.split("[-]").length>1){
            String[] operators = str.split("[-]");
            return operations.substract(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.split("[/]").length>1){
            String[] operators = str.split("[/]");
            return operations.divide(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.split("[*]").length>1){
            String[] operators = str.split("[*]");
            return operations.multiply(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.startsWith("max(")){
            CharSequence s = str.subSequence(4,str.length()-1);
            String[] operators = s.toString().split(",");
            return operations.max(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.startsWith("min(")){
            CharSequence s = str.subSequence(4,str.length()-1);
            String[] operators = s.toString().split(",");
            return operations.min(Long.parseLong(operators[0]),Long.parseLong(operators[1]));
        }
        if(str.startsWith("sqrt")){
            CharSequence s = str.subSequence(4,str.length());

            return operations.sqrt(Long.parseLong(s.toString()));
        }
       return 0;
    }
}
