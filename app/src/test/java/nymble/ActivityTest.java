package app.src.test.java.nymble;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.src.main.java.nymble.Activity;
import app.src.main.java.nymble.Destination;

public class ActivityTest {
     @Test
    public void testActivityInitialization() {
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 20, destination);
        
        assertEquals("Eiffel Tower Tour", activity.getName());
        assertEquals("Guided tour of the Eiffel Tower", activity.getDescription());
        assertEquals(50.0, activity.getCost(), 0.01);
        assertEquals(20, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }
}
