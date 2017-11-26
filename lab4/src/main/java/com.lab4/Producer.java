package com.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 11/26/2017.
 */
public class Producer extends Thread {
    private List<Person> persons;

    public Producer(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run(){
        String path = "..\\maven-samples\\lab4\\src\\main\\resources\\input4.txt";
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
        for (String[] posPers: listOfPossiblePersons) {
                if(Validator.validName(posPers[0]) &&
                        Validator.validName(posPers[1]) &&
                        Validator.validName(posPers[2]) &&
                        Validator.validCNP(posPers[3]) &&
                        Validator.validEmail(posPers[4]) ){
                        System.out.println("producer");
                        while(persons.size() == 1){
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        }
                        persons.add(new Person(posPers[0], posPers[1], posPers[2], posPers[3], posPers[4]));

                    notify();
                }
        }
    }

