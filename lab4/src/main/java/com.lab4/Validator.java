package com.lab4;

/**
 * Created by Cosmin on 11/14/2017.
 */
public class Validator {
    public static boolean validName(String name){
        String regex = "[a-zA-Z]+";
        if(name.matches(regex)){
            return true;
        }
        return false;
    }
    public static boolean validCNP(String cnp){
        String regex = "^[1,2,5,6]{1}[0-9]{2}([0]{1}[1-9]{1}|[1]{1}[0-2]{1})([0-2]{1}[1-9]{1}|[3]{1}[0-1]{1})[0-9]{6}";
        if(cnp.matches(regex)){
            return true;
        }
        return false;
    }
    public static boolean validEmail(String email){
        String regexEmail = "^[a-zA-Z0-9!#$%&'*+=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-zA-Z-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-z0-9])?";
        if(email.matches(regexEmail)){
            return true;
        }
        return false;
    }
}
