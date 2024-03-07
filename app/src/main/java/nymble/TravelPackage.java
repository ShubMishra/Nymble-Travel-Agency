package app.src.main.java.nymble;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Passenger> passengers;
    private List<Destination> itinerary;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<>();
        this.itinerary = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Travel package is full, cannot add more passengers.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Description: " + activity.getDescription() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger Name: " + passenger.getName() +
                    ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getCapacity() > 0) { 
                    System.out.println("Activity: " + activity.getName() +
                            ", Destination: " + activity.getDestination().getName() +
                            ", Spaces Available: " + activity.getCapacity());
                }
            }
        }
    }
}