package app.src.main.java.nymble;

public class PremiumPassenger extends Passenger {
    public PremiumPassenger(String name, int passengerNumber) {
        super(name, passengerNumber, 0); // Premium passengers have no balance, they can sign up for activities for free.
    }
}
