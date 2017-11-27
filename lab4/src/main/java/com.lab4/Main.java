package com.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cosmin on 11/14/2017.
 */
public class Main {
    public static void restoreObjectsToFile(String path){
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> listOfPossiblePersons = new ArrayList<>();
        String[] optionsStr = text.split("%");
        String[] possiblePerson;
        for (String str: optionsStr
                ) {
            possiblePerson = str.split("~");
            listOfPossiblePersons.add(possiblePerson);
        }
        String outfile = "..\\maven-samples\\lab4\\src\\main\\resources\\input4Out.txt";
        try(FileWriter fw = new FileWriter(outfile, true);
            BufferedWriter bw = new BufferedWriter(fw);)
            {
            for (String[] posPers: listOfPossiblePersons) {
                if(Validator.validName(posPers[0]) &&
                        Validator.validName(posPers[1]) &&
                        Validator.validName(posPers[2]) &&
                        Validator.validCNP(posPers[3]) &&
                        Validator.validEmail(posPers[4]) ){
                    bw.write(new Person(posPers[0], posPers[1], posPers[2], posPers[3], posPers[4]).toString() + "\n");
                   // System.out.println(new Person(posPers[0], posPers[1], posPers[2], posPers[3], posPers[4]));
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static volatile boolean producing = true;
    public static void main(String[] args) throws InterruptedException {
        String path = "..\\maven-samples\\lab4\\src\\main\\resources\\input4.txt";
        //restoreObjectsToFile(path);
        List<Person> persons = Collections.synchronizedList(new ArrayList<>());

        PC producerConsumer = new PC(persons);
        Thread producer = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
