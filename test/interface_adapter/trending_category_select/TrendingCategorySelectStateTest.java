package interface_adapter.trending_category_select;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrendingCategorySelectStateTest {
    @Test
    public void testDefaultConstructor() {
        TrendingCategorySelectState state = new TrendingCategorySelectState();
        assertEquals("0", state.getCategoryId(), "Default category should be '0'");
    }

    @Test
    public void testCopyConstructor() {
        TrendingCategorySelectState original = new TrendingCategorySelectState();
        original.setCategoryId("5");

        TrendingCategorySelectState copy = new TrendingCategorySelectState(original);
        assertEquals("5", copy.getCategoryId(), "Copied state should have same category ID as original");
    }

    @Test
    public void testSetAndGetCategoryId() {
        TrendingCategorySelectState state = new TrendingCategorySelectState();
        state.setCategoryId("10");
        assertEquals("10", state.getCategoryId(), "Category ID should be updated to '10'");
    }

}
