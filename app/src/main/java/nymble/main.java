package app.src.main.java.nymble;

public class main {
    public static void main(String[] args) {
        // Creating destinations
        Destination paris = new Destination("Paris");
        Destination london = new Destination("London");

        // Adding activities to destinations
        paris.addActivity(new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 20, paris));
        paris.addActivity(new Activity("Louvre Museum Visit", "Guided tour of the Louvre Museum", 40.0, 30, paris));

        london.addActivity(new Activity("London Eye Ride", "Ride on the London Eye", 60.0, 25, london));
        london.addActivity(new Activity("British Museum Tour", "Guided tour of the British Museum", 35.0, 30, london));

        // Creating travel package
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        // Adding destinations to travel package
        europeTour.addDestination(paris);
        europeTour.addDestination(london);

        // Creating passengers
        StandardPassenger john = new StandardPassenger("John", 1, 200.0);
        GoldPassenger alice = new GoldPassenger("Alice", 2, 300.0);
        PremiumPassenger mike = new PremiumPassenger("Mike", 3);

        // Signing up passengers for activities
        john.signUp(europeTour,paris.getActivities().get(0)); // John signs up for Eiffel Tower Tour
        alice.signUp(europeTour,london.getActivities().get(0)); // Alice signs up for London Eye Ride
        mike.signUp(europeTour,paris.getActivities().get(1)); // Mike signs up for Louvre Museum Visit

        // Printing itinerary, passenger list, passenger details, and available activities
        europeTour.printItinerary();
        europeTour.printPassengerList();
        john.printDetails();
        europeTour.printAvailableActivities();
    }
}
