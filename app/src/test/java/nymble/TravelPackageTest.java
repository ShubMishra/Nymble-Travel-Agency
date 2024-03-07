package app.src.test.java.nymble;

import app.src.main.java.nymble.TravelPackage;
import org.junit.Test;
import static org.junit.Assert.*;

public class TravelPackageTest {

    @Test
    public void testTravelPackageInitialization() {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 50);
        
        assertEquals("Europe Tour", travelPackage.getName());
        assertEquals(50, travelPackage.getPassengerCapacity());
        assertNotNull(travelPackage.getPassengers());
        assertEquals(0, travelPackage.getPassengers().size());
        assertNotNull(travelPackage.getItinerary());
        assertEquals(0, travelPackage.getItinerary().size());
    }
}
