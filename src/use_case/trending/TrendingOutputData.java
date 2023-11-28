package use_case.trending;

import entities.Video;

public class TrendingOutputData {
    private final Video topOne;
    private final Video topTwo;

    private final Video topThree;

    public TrendingOutputData(Video topOne, Video topTwo, Video topThree) {
        this.topOne = topOne;
        this.topTwo = topTwo;
        this.topThree = topThree;
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
