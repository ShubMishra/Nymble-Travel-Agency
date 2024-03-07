package app.src.main.java.nymble;

public class GoldPassenger extends Passenger {
    public GoldPassenger(String name, int passengerNumber, double balance) {
        super(name, passengerNumber, balance);
    }

    public boolean deductBalance(double cost) {
        if (getBalance() >= cost) {
            setBalance(getBalance() - cost);
            return true;
        }
        return false;
    }
}
