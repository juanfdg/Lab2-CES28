import models.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClientConstructorTest {
    private Client gui;

    @Before
    public void setUp(){
        this.gui = new Client("Guilherme", 21, Client.Sex.M, "guipcleao@gmail.com");
    }

    @Test
    public void testClientConstructor() {
        assertEquals(gui.getName(), "Guilherme");
        assertEquals(gui.getAge(), 21);
        assertEquals(gui.getSex(), Client.Sex.M);
        assertEquals(gui.getEmail(), "guipcleao@gmail.com");
    }
}
