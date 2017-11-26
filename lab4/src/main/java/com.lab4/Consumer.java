package com.lab4;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Cosmin on 11/26/2017.
 */
public class Consumer extends Thread {
    private List<Person> persons;

    public Consumer(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void run(){
        String outfile = "..\\maven-samples\\lab4\\src\\main\\resources\\input4Out.txt";
        try(FileWriter fw = new FileWriter(outfile, true);
            BufferedWriter bw = new BufferedWriter(fw);)
        {
            while(persons.size() == 0){
                wait();
            }
            bw.write(persons.remove(0).toString()+" \n");
            System.out.println("consumer");
            notify();

        }catch (IOException e) {
            System.err.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
