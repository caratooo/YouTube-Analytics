package interface_adapter.trending_category_select;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrendingCategorySelectStateTest {

    TrendingCategorySelectState trendingCategorySelectState = new TrendingCategorySelectState();

    @Test
    void setGetCategoryId() {
        assertEquals(trendingCategorySelectState.getCategoryId(), "0");
        trendingCategorySelectState.setCategoryId("17");
        assertEquals(trendingCategorySelectState.getCategoryId(), "17");
    }

    @Test
    void copyTest() {
        trendingCategorySelectState.setCategoryId("17");
        TrendingCategorySelectState trendingCategorySelectStateCopy = new TrendingCategorySelectState(trendingCategorySelectState);
        assertEquals(trendingCategorySelectStateCopy.getCategoryId(), trendingCategorySelectState.getCategoryId());
    }

}


