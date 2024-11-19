package dev.maria;

import dev.maria.enums.PlanetType;
import dev.maria.models.Planet;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Planet mars = new Planet("Mars", 2, 6.39e23, 1.6318e11, 6779, 228, PlanetType.TERRESTRIAL, false, 1.88, 1.026);
        Planet venus = new Planet("Venus", 0, 4.867e24, 9.2843e11, 12104, 108, PlanetType.TERRESTRIAL, true, 0.615, -243);
        mars.printDetails();
        System.out.println();
        venus.printDetails();
    }
}
