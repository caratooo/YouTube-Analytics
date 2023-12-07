package interface_adapter.trending_data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TrendingDataViewModelTest {
    TrendingDataState trendingDataState = new TrendingDataState();

    TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();

    @Test
    void setGetState() {
        assertNotEquals(trendingDataViewModel.getState(), trendingDataState);
        trendingDataState.setCategory("17");
        trendingDataViewModel.setState(trendingDataState);
        assertEquals(trendingDataViewModel.getState(), trendingDataState);
    }
}
