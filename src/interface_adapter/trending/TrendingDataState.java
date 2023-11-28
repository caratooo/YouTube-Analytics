package interface_adapter.trending;

import entities.Video;

public class TrendingDataState {
    // TODO put everything I want in the output
    private Video topOne;
    private Video topTwo;
    private Video topThree;

    public TrendingDataState(TrendingDataState copy) {
        topOne = copy.topOne;
        topTwo = copy.topTwo;
        topThree = copy.topThree;
    }

    public TrendingDataState() {

    }

    public Video getTopOne() {
        return topOne;
    }

    public Video getTopTwo() {
        return topTwo;
    }

    public Video getTopThree() {
        return topThree;
    }
}
