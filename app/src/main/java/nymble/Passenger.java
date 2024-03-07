package app.src.main.java.nymble;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private String name;
    private int passengerNumber;
    private double balance;
    private List<Activity> activities;

    public Passenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setBalance(double d) {

        this.balance = d;

    }

    public void printDetails() {
        System.out.println("Passenger Name: " + getName());
        System.out.println("Passenger Number: " + getPassengerNumber());

        // Check if the passenger is a StandardPassenger and has a balance
        if (this instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) this;
            System.out.println("Balance: " + standardPassenger.getBalance());
        } else if (this instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) this;
            System.out.println("Balance: " + goldPassenger.getBalance());
        }

        // Print each activity the passenger has signed up for
        List<Activity> activities = getActivities();
        if (!activities.isEmpty()) {
            System.out.println("Activities Signed Up:");
            for (Activity activity : activities) {
                System.out.println("Activity: " + activity.getName() +
                        ", Destination: " + activity.getDestination().getName() +
                        ", Price Paid: " + activity.getCost());
            }
        } else {
            System.out.println("No activities signed up.");
        }
    }

    public void signUp(TravelPackage travelPackage, Activity activity) {

        // Check if the activity is associated with the travel package
        if (travelPackage.getItinerary().contains(activity.getDestination())) {
            Destination destination = activity.getDestination();
            if (destination.geActivity(activity).getCapacity() > 0) {
                activity = destination.geActivity(activity);
                if (this instanceof StandardPassenger) {
                    StandardPassenger standardPassenger = (StandardPassenger) this;
                    if (standardPassenger.deductBalance(activity.getCost())) {
                        activities.add(activity);
                        destination.getActivities().remove(activity);
                        destination.getActivities().add(new Activity(
                                activity.getName(),
                                activity.getDescription(),
                                activity.getCost(),
                                activity.getCapacity() - 1,
                                activity.getDestination()));
                    } else {
                        System.out.println("Insufficient balance for standard passenger: " + this.getName());
                    }
                } else if (this instanceof GoldPassenger) {
                    GoldPassenger goldPassenger = (GoldPassenger) this;
                    double discountedCost = activity.getCost() * 0.9;
                    if (goldPassenger.deductBalance(discountedCost)) {
                        activities.add(activity);
                        destination.getActivities().remove(activity);
                        destination.getActivities().add(new Activity(
                                activity.getName(),
                                activity.getDescription(),
                                activity.getCost(),
                                activity.getCapacity() - 1,
                                activity.getDestination()));
                    } else {
                        System.out.println("Insufficient balance for gold passenger: " + this.getName());
                    }
                } else if (this instanceof PremiumPassenger) {
                    activities.add(activity);
                    destination.getActivities().remove(activity);
                    destination.getActivities().add(new Activity(
                            activity.getName(),
                            activity.getDescription(),
                            activity.getCost(),
                            activity.getCapacity() - 1,
                            activity.getDestination()));
                }
            } else {
                System.out.println("Activity is not part of the travel package: " + activity.getName());
            }
        } else {
            System.out.println("Activity is full: " + activity.getName());
        }
    }
}
