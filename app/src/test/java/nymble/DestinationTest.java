package app.src.test.java.nymble;

import org.junit.Test;

import app.src.main.java.nymble.Destination;

import static org.junit.Assert.*;

public class DestinationTest {

    @Test
    public void testDestinationInitialization() {
        Destination destination = new Destination("Paris");
        
        assertEquals("Paris", destination.getName());
        assertNotNull(destination.getActivities());
        assertEquals(0, destination.getActivities().size());
    }
}
