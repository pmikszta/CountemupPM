package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    @Test
    void testMainRunsWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }

    @Test
    void testMainOutput() {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            App.main(new String[]{});
            String output = outContent.toString();

            // Check that it contains something expected (for example, $0.00 from GroceryCounter)
            assertTrue(output.contains("$0.00"), "Output should contain initial total $0.00");
        } finally {
            System.setOut(originalOut); // Restore original output
        }
    }
}
