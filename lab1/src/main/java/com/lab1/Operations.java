package com.lab1;

/**
 * Created by Cosmin on 10/16/2017.
 */
public class Operations {
    public long sum(long a, long b){
        return a+b;
    }
    public long substract(long a,long b){
        return a-b;
    }
    public double divide(long a,long b){
        return (double)a/b;
    }
    public long multiply(long a, long b){
        return a*b;
    }
    public long max(long a, long b){
        return Math.max(a,b);
    }
    public long min(long a, long b){
        return Math.min(a,b);
    }
    public double sqrt(long a){
        return (double)Math.sqrt(a);
    }
}
