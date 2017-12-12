package com.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cosmin on 11/27/2017.
 */
public class PC {
    private List<Person> persons;
    private volatile boolean producing;

    public PC(List<Person> persons) {
        this.persons = persons;
        this.producing = true;
    }
    public void produce() throws InterruptedException
    {   String path = "..\\maven-samples\\lab4\\src\\main\\resources\\input4.txt";
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String[]> listOfPossiblePersons = new ArrayList<>();
        String[] optionsStr = text.split("%");
        String[] possiblePerson;
        for (String str : optionsStr
                ) {
            possiblePerson = str.split("~");
            listOfPossiblePersons.add(possiblePerson);
        }
        for (String[] posPers : listOfPossiblePersons) {
            synchronized (this)
            {
                // producer thread waits while list
                // is 1
                while (persons.size() == 1) {
                    System.out.println("producer waiting!");
                    wait();

                }


                if (Validator.validName(posPers[0]) &&
                        Validator.validName(posPers[1]) &&
                        Validator.validName(posPers[2]) &&
                        Validator.validCNP(posPers[3]) &&
                        Validator.validEmail(posPers[4])) {

                     persons.add(new Person(posPers[0], posPers[1], posPers[2], posPers[3], posPers[4]));
                    notify();
                }

                // notifies the consumer thread

            }
        }
        producing = false;
    }
    // Function called by consumer thread
    public void consume() throws InterruptedException
    {String outfile = "..\\maven-samples\\lab4\\src\\main\\resources\\input4Out.txt";
        try(FileWriter fw = new FileWriter(outfile, true);
            BufferedWriter bw = new BufferedWriter(fw);) {
            while (producing) {
                synchronized (this) {
                    // consumer thread waits while list
                    while (persons.size() == 0) {
                        System.out.println("consumer waiting!");
                        wait();

                    }
                    //to retrive the ifrst job in the list
                    bw.write(persons.remove(0).toString() + "\n");
                    // Wake up producer thread
                    notify();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
