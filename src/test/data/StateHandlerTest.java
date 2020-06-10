package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Loadable;
import storage.Saveable;
import ui.Results;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class StateHandlerTest {

    @BeforeEach
    public void runBefore() {
    }

    @Test
    public void saveTest() {
        Results saveable = new Results(80,74,67);
        Boolean n = saveable.save("lol", "hi", "bye");
        assertTrue(n);
    }

    @Test
    public void setLoadable() throws IOException {
        Results loadable = new Results(80,74,67, "Y");
        String ans = loadable.load("Test.txt");
        assertEquals(ans, "[Output:, lol, bye, hi]");
    }

}
