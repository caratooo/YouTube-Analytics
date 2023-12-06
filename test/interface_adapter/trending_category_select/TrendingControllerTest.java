package interface_adapter.trending_category_select;

import org.junit.jupiter.api.Test;
import use_case.trending.TrendingInputBoundary;
import use_case.trending.TrendingInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TrendingControllerTest {
    @Test
    void successTest() throws GeneralSecurityException, IOException {

        String categoryId = "17";

        TrendingInputBoundary interactor = new TrendingInputBoundary() {
            @Override
            public void execute(TrendingInputData trendingInputData) {
                assertEquals("17", trendingInputData.getCategoryId());
            }
        };

        TrendingController controller = new TrendingController(interactor);
        controller.execute(categoryId);

    }


}
