package com.lab2;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 11/12/2017.
 */
public class BigDecimalsSerialize {

    public void serializeBigDecimals(String file, List<BigDecimal> list){
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

            for(BigDecimal number: list){
                out.writeObject(number);
            }

        }catch(IOException e) {
            System.out.println(e);
        }
    }
    public List<BigDecimal> deserializeBigDecimals(String file){
        List<BigDecimal> listOfBigDecimals = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
                while (true) {
                    listOfBigDecimals.add((BigDecimal) in.readObject());
                }
        }catch (IOException|ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return listOfBigDecimals;
    }


}
