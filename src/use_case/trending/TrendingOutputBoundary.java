package use_case.trending;

public interface TrendingOutputBoundary {
    void prepareDataView(TrendingOutputData data);

    void prepareSelectView();
}
