// Counter Class
package org.example;


import java.text.DecimalFormat;
import java.util.Scanner;

public class GroceryCounter {
    private int cents; 
    private int overflowCount;

    public GroceryCounter() {
        this.cents = 0;
        this.overflowCount = 0;
    }

    // Ten dollar Place
    public void tens() {
        addAmount(1000);
    }

    // Dollar Place
    public void ones() {
        addAmount(100);
    }

    // Ten Cents place
    public void tenCents() {
        addAmount(10);
    }

    // Cents Place
    public void hundreths() {
        addAmount(1);
    }

    // Overflow counter
    private void addAmount(int addCents) {
        if (cents + addCents > 9999) { // 9999 cents = $99.99
            overflowCount++;
        } else {
            cents += addCents;
        }
    }

    // Pretty price
    public String total() {
        DecimalFormat df = new DecimalFormat("$0.00");
        return df.format(cents / 100.0);
    }

    // returns overflow count
    public int overflows() {
        return overflowCount;
    }

    // reset everything
    public void clear() {
        cents = 0;
        overflowCount = 0;
    }
}
