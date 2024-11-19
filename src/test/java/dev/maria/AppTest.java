package dev.maria;

import dev.maria.enums.PlanetType;
import dev.maria.models.Planet;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    void testAppOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        String output = outContent.toString();
        assertTrue(output.contains("Name: Mars"));
        assertTrue(output.contains("Name: Venus"));

        System.setOut(originalOut);
    }
}
