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
        assertEquals("Guilherme", gui.getName());
        assertEquals(21, gui.getAge());
        assertEquals(Client.Sex.M, gui.getSex());
        assertEquals("guipcleao@gmail.com", gui.getEmail());
    }
}
