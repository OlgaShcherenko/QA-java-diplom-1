package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientOne);
        assertEquals(ingredientOne, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        int expectedIndex = 1;
        burger.moveIngredient(0, 1);
        assertEquals(expectedIndex, burger.ingredients.lastIndexOf(ingredientOne));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(988.00f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(80.00f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(3000.00f);
        float expectedResult = 5056.00f;
        assertEquals(expectedResult, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getName()).thenReturn("R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988.00f);
        Mockito.when(ingredientOne.getName()).thenReturn("Space Sauce");
        Mockito.when(ingredientOne.getPrice()).thenReturn(80.00f);
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientTwo.getName()).thenReturn("Говяжий метеорит");
        Mockito.when(ingredientTwo.getPrice()).thenReturn(3000.00f);
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        String expectedResult = "(==== R2-D3 ====)\r\n" +
                "= sauce Space Sauce =\r\n" +
                "= filling Говяжий метеорит =\r\n" +
                "(==== R2-D3 ====)\r\n" +
                "\r\n" +
                "Price: 5056,000000\r\n";
        assertEquals(expectedResult, burger.getReceipt());
    }
}
