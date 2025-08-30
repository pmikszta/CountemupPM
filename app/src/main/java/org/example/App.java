package org.example;

import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class App {
    public static void main(String[] args) {
        GroceryCounter counter = new GroceryCounter();

        System.out.println(counter.total());

        counter.tens(); 
        counter.tens(); 
        counter.ones(); 
        counter.ones(); 
        counter.tenCents(); 
        counter.hundreths();   

        System.out.println("\nManual Add");
        System.out.println(counter.total()); 
        System.out.println(counter.overflows()); 

        // Add $1 thirty-five times
        for (int i = 0; i < 35; i++) counter.ones();

        System.out.println("\nAdd 35 Times");
        System.out.println(counter.total());
        System.out.println(counter.overflows());

        // Attempt to check over flow with ones
        for (int i = 0; i < 100; i++) counter.ones();
        System.out.println("\nAdd 100 times");
        System.out.println(counter.total()); 
        System.out.println(counter.overflows());


        //Clear value and then attempt another round
        System.out.println("\nClearvalue");
        counter.clear();
        System.out.println(counter.total()); 
        System.out.println(counter.overflows());


        counter.tens(); 
        counter.tens(); 
        counter.tens(); 
        counter.ones(); 
        counter.ones(); 
        counter.ones(); 
        counter.ones(); 
        counter.tenCents(); 
        counter.tenCents(); 
        counter.tenCents(); 
        counter.hundreths();   

        System.out.println("\nManual Add");
        System.out.println(counter.total()); 
        System.out.println(counter.overflows()); 

    }
}