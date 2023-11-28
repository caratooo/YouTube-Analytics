package interface_adapter.trending;

import use_case.trending.TrendingInputBoundary;
import use_case.trending.TrendingInputData;


public class TrendingController {
    final TrendingInputBoundary trendingUseCaseInteractor;

    public TrendingController(TrendingInputBoundary trendingUseCaseInteractor) {
        this.trendingUseCaseInteractor = trendingUseCaseInteractor;
    }


    public void execute(String categoryInt) {
        TrendingInputData trendingInputData = new TrendingInputData(categoryInt);
        trendingUseCaseInteractor.execute(trendingInputData);
    }

}
