package app.src.test.java.nymble;

import org.junit.Test;

import app.src.main.java.nymble.Activity;
import app.src.main.java.nymble.Passenger;
import app.src.main.java.nymble.PremiumPassenger;
import app.src.main.java.nymble.StandardPassenger;
import app.src.main.java.nymble.TravelPackage;

import static org.junit.Assert.*;

import app.src.main.java.nymble.Destination;
import app.src.main.java.nymble.GoldPassenger;

public class PassengerTest {

    @Test
    public void testPassengerInitialization() {
        Passenger passenger = new Passenger("John", 1, 200.0);
        
        assertEquals("John", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
        assertEquals(200.0, passenger.getBalance(), 0.01);
        assertNotNull(passenger.getActivities());
        assertEquals(0, passenger.getActivities().size());
    }

     @Test
    public void testSignUpWithSufficientBalance() {
         
         TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

         
         Destination destination = new Destination("Paris");
 
         
         Activity activity = new Activity("Louvre Museum Visit", "Guided tour of the Louvre Museum", 40.0, 20, destination);
         destination.addActivity(activity);
 
         
         europeTour.addDestination(destination);
 
         // Create a standard passenger with insufficient balance
         StandardPassenger passenger = new StandardPassenger("Alice", 2, 80.0);
 
         
         europeTour.addPassenger(passenger);
 
         
         passenger.signUp(europeTour, activity);

        // Assert that the passenger is signed up for the activity
        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(40.0, passenger.getBalance(), 0.01); // Assert that the balance is deducted correctly
    }

    @Test
    public void testSignUpWithInsufficientBalance() {
        
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        
        Destination destination = new Destination("Paris");

        
        Activity activity = new Activity("Louvre Museum Visit", "Guided tour of the Louvre Museum", 40.0, 20, destination);
        destination.addActivity(activity);

        
        europeTour.addDestination(destination);

        // Create a standard passenger with insufficient balance
        StandardPassenger passenger = new StandardPassenger("Alice", 2, 30.0);

        
        europeTour.addPassenger(passenger);

        
        passenger.signUp(europeTour, activity);

        // Assert that the passenger is not signed up for the activity
        assertFalse(passenger.getActivities().contains(activity));
        assertEquals(30.0, passenger.getBalance(), 0.01); // Assert that the balance remains unchanged
    }

    @Test
    public void testSignUpWhenCapacityIsZero() {
        
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        
        Destination destination = new Destination("Paris");

        
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 3, destination);
        destination.addActivity(activity);

        
        europeTour.addDestination(destination);

        
        StandardPassenger passenger1 = new StandardPassenger("John", 1, 200.0);
        StandardPassenger passenger2 = new StandardPassenger("Alice", 2, 200.0);
        StandardPassenger passenger3 = new StandardPassenger("Bob", 3, 200.0);

        
        europeTour.addPassenger(passenger1);
        europeTour.addPassenger(passenger2);
        europeTour.addPassenger(passenger3);

        // Sign up passengers for the activity until capacity is full
        passenger1.signUp(europeTour, activity);
        passenger2.signUp(europeTour, activity);
        passenger3.signUp(europeTour, activity);

        // Attempt to sign up another passenger for the activity after capacity is full
        StandardPassenger passenger4 = new StandardPassenger("Mike", 4, 200.0);
        passenger4.signUp(europeTour, activity);

        // Assert that the passenger is not signed up for the activity
        assertFalse(passenger4.getActivities().contains(activity));
    }

    @Test
    public void testGoldPassengerSignUp() {
        
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        
        Destination destination = new Destination("Paris");

        
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 3, destination);
        destination.addActivity(activity);

        
        europeTour.addDestination(destination);


        // Create a gold passenger with sufficient balance
        GoldPassenger passenger = new GoldPassenger("Alice", 2, 100.0);

        
        passenger.signUp(europeTour,activity);

        // Assert that the passenger is signed up for the activity
        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(55.0, passenger.getBalance(), 0.01); // Assert discounted balance
    }

    @Test
    public void testPremiumPassengerSignUp() {
        
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        
        Destination destination = new Destination("Paris");

        
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 3, destination);
        destination.addActivity(activity);

        
        europeTour.addDestination(destination);

        
        PremiumPassenger passenger = new PremiumPassenger("Bob", 3);

        
        passenger.signUp(europeTour,activity);

        // Assert that the passenger is signed up for the activity
        assertTrue(passenger.getActivities().contains(activity));
        assertEquals(0.0, passenger.getBalance(), 0.01); // Assert balance unchanged
    }
}

