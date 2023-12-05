package interface_adapter.trending_category_select;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrendingCategorySelectViewModelTest {
    TrendingCategorySelectState trendingCategorySelectState  = new TrendingCategorySelectState ();

    TrendingCategorySelectViewModel  trendingCategorySelectViewModel = new  TrendingCategorySelectViewModel();

    @Test
    void setGetState() {
        assertNotEquals(trendingCategorySelectViewModel.getState(), trendingCategorySelectState);
        trendingCategorySelectState.setCategoryId("17");
        trendingCategorySelectViewModel.setState(trendingCategorySelectState);
        assertEquals(trendingCategorySelectViewModel.getState(), trendingCategorySelectState);
    }

}
