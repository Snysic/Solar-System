package dev.maria.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.olena.enums.PlanetType;

public class PlanetTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testCalculateDensity() {
        Planet mars = new Planet("Mars", 2, 6.39e23, 1.6318e11, 6779, 228, PlanetType.TERRESTRIAL, false, 1.88, 1.026);
        double expectedDensity = 3.915e12;
        assertEquals(expectedDensity, mars.calculateDensity(), 1e9);
    }
    
    @Test
    void testIsOuterPlanet() {
        Planet mars = new Planet("Mars", 2, 6.39e23, 1.6318e11, 6779, 228, PlanetType.TERRESTRIAL, false, 1.88, 1.026);
        assertFalse(mars.isOuterPlanet());
    }

    @Test
    void testIsOuterPlanetVenus() {
        Planet venus = new Planet("Venus", 0, 4.867e24, 9.2843e11, 12104, 108, PlanetType.TERRESTRIAL, true, 0.615, -243);
        assertFalse(venus.isOuterPlanet());
    }

    @Test
    void testCalculateDensitySaturn() {
        Planet saturn = new Planet("Saturn", 82, 5.683e26, 8.2713e14, 116460, 1434000000, PlanetType.GASEOUS, true, 29.5, 0.444);
        double expectedDensity = 5.683e26 / 8.2713e14; // Density calculation
        assertEquals(expectedDensity, saturn.calculateDensity(), 1e5);
    }

    @Test
    void testIsOuterPlanetSaturn() {
        Planet saturn = new Planet("Saturn", 82, 5.683e26, 8.2713e14, 116460, 1434000000, PlanetType.GASEOUS, true, 29.5, 0.444);
        assertTrue(saturn.isOuterPlanet());
    }

    @Test
    void testPrintDetails() {
        Planet mars = new Planet("Mars", 2, 6.39e23, 1.6318e11, 6779, 228, PlanetType.TERRESTRIAL, false, 1.88, 1.026);
        mars.printDetails();
        String expectedOutput = "Name: Mars\n" +
                "Satellites: 2\n" +
                "Mass: 6.39E23 kg\n" +
                "Volume: 1.6318E11 km³\n" +
                "Diameter: 6779 km\n" +
                "Distance to Sun: 228 million km\n" +
                "Type: TERRESTRIAL\n" +
                "Visible with Naked Eye: false\n" +
                "Orbital Period: 1.88 years\n" +
                "Rotation Period: 1.026 days\n" +
                "Density: " + String.format("%.1f", mars.calculateDensity()) + " kg/km³\n" +
                "Is Outer Planet: false\n";
            assertEquals(expectedOutput.trim(), outContent.toString().trim().replaceAll("\r\n", "\n"));
    }
    

}