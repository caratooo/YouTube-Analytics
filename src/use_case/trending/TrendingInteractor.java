package use_case.trending;

public class TrendingInteractor implements TrendingInputBoundary{
    final TrendingDataAccessInterface trendingDataAccessObject;

    final TrendingOutputBoundary trendingPresenter;


    public TrendingInteractor(TrendingDataAccessInterface trendingDataAccessInterface,
                              TrendingOutputBoundary trendingOutputBoundary) {
        this.trendingDataAccessObject = trendingDataAccessInterface;
        this.trendingPresenter = trendingOutputBoundary;
    }
    @Override
    public void execute(TrendingInputData trendingInputData) {

    }
}
