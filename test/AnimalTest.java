import models.Animal;
import models.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnimalTest {
    private Client victor;
    private Animal nick;

    @Before
    public void setUp() throws Exception {
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick = new Animal(victor, "Nick", Animal.Sex.M, 2);
    }

    @Test
    public void testConstructor() {
        assertEquals(2, nick.getAge());
        assertEquals(victor, nick.getClient());
        assertEquals("Nick", nick.getName());
        assertEquals(Animal.Sex.M, nick.getSex());
        assertEquals(0, nick.getTreatments().size());
    }
}
