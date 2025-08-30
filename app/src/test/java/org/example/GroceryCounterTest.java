package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroceryCounterTest {

    private GroceryCounter counter;


    //each test adds twice and to see if it increments correctly
    @BeforeEach
    void setUp() {
        counter = new GroceryCounter();
    }

    @Test
    void testInitialState() {
        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testTens() {
        counter.tens();
        assertEquals("$10.00", counter.total());

        counter.tens();
        assertEquals("$20.00", counter.total());
    }

    @Test
    void testOnes() {
        counter.ones();
        assertEquals("$1.00", counter.total());

        counter.ones();
        assertEquals("$2.00", counter.total());
    }

    @Test
    void testTenCents() {
        counter.tenCents();
        assertEquals("$0.10", counter.total());

        counter.tenCents();
        assertEquals("$0.20", counter.total());
    }

    @Test
    void testHundredths() {
        counter.hundreths();
        assertEquals("$0.01", counter.total());

        counter.hundreths();
        assertEquals("$0.02", counter.total());
    }

    @Test
    void testCombinationAdditions() {
        counter.tens();
        counter.tens();
        counter.hundreths();
        assertEquals("$20.01", counter.total());
        assertEquals(0, counter.overflows());
    }

    @Test
    void testOverflowDoesNotChangeTotal() {
        // Max out value
        for (int i = 0; i < 9; i++) counter.tens(); 
        for (int i = 0; i < 9; i++) counter.ones(); 
        for (int i = 0; i < 99; i++) counter.hundreths();

        assertEquals("$99.99", counter.total());
        assertEquals(0, counter.overflows());

        // Add one more expect overflow
        counter.ones();
        assertEquals("$99.99", counter.total()); 
        assertEquals(1, counter.overflows());
    }

    @Test
    void testClear() {
        counter.tens();
        counter.ones();
        counter.hundreths();

        counter.clear();

        assertEquals("$0.00", counter.total());
        assertEquals(0, counter.overflows());
    }
}
