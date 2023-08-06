package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {
    private String name = "Bulka";
    private float price;

    public BunPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getPriceForTest() {
        return new Object[][]{
                {100},
                {Float.MAX_VALUE},
                {Float.MIN_VALUE},
                {0},
                {Float.NaN},
                {-100}
        };
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
