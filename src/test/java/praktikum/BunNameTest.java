package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunNameTest {
    private String name;
    private float price = 100;

    public BunNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getNameForTest() {
        return new Object[][]{
                {"Bulka"},
                {"BulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulkaBulka"},
                {"Bulka$$$"},
                {"12345Bulka"},
                {""},
                {null},
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }
}
