package dev.maria.models;

import dev.maria.enums.PlanetType;

public class Planet {
    private String name;
    private int satellites;
    private double mass;
    private double volume;
    private int diameter;
    private int distanceToSun;
    private PlanetType type;
    private boolean visibleWithNakedEye;
    private double orbitalPeriod;
    private double rotationPeriod;

    public Planet(String name, int satellites, double mass, double volume, int diameter, int distanceToSun, PlanetType type, boolean visibleWithNakedEye, double orbitalPeriod, double rotationPeriod) {
        this.name = name;
        this.satellites = satellites;
        this.mass = mass;
        this.volume = volume;
        this.diameter = diameter;
        this.distanceToSun = distanceToSun;
        this.type = type;
        this.visibleWithNakedEye = visibleWithNakedEye;
        this.orbitalPeriod = orbitalPeriod;
        this.rotationPeriod = rotationPeriod;
    }

    public double calculateDensity() {
        return mass / volume;
    }

    public boolean isOuterPlanet() {
        return distanceToSun > 509;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Satellites: " + satellites);
        System.out.println("Mass: " + mass + " kg");
        System.out.println("Volume: " + volume + " km³");
        System.out.println("Diameter: " + diameter + " km");
        System.out.println("Distance to Sun: " + distanceToSun + " million km");
        System.out.println("Type: " + type);
        System.out.println("Visible with Naked Eye: " + visibleWithNakedEye);
        System.out.println("Orbital Period: " + orbitalPeriod + " years");
        System.out.println("Rotation Period: " + rotationPeriod + " days");
        System.out.println("Density: " + String.format("%.1f", calculateDensity()) + " kg/km³"); 
        System.out.println("Is Outer Planet: " + isOuterPlanet());
    }
}