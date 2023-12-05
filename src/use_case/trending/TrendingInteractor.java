package use_case.trending;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class TrendingInteractor implements TrendingInputBoundary {
    final TrendingDataAccessInterface trendingDataAccessObject;

    final TrendingOutputBoundary trendingPresenter;


    public TrendingInteractor(TrendingDataAccessInterface trendingDataAccessInterface,
                              TrendingOutputBoundary trendingOutputBoundary) {
        this.trendingDataAccessObject = trendingDataAccessInterface;
        this.trendingPresenter = trendingOutputBoundary;
    }

    @Override
    public void execute(TrendingInputData trendingInputData) throws GeneralSecurityException, IOException {
        ArrayList<Video> videos;
        if (trendingInputData.equal("0")) {
            videos = trendingDataAccessObject.get_trending_default();
        } else {
            // get trend by category
            videos = trendingDataAccessObject.get_trending_category(trendingInputData.getCategoryId());
        }

        TrendingOutputData trendingOutputData = new TrendingOutputData(trendingInputData.getCategoryStr(),videos.get(0).getId(), videos.get(0).getChannelName(),videos.get(0).getTitle(), videos.get(0).getDescription(), videos.get(0).getVideoPublishDate(),videos.get(0).getViewCount(),
                videos.get(0).getLikeCount(), videos.get(0).getCommentCount(), videos.get(1).getId(), videos.get(1).getChannelName(),videos.get(1).getTitle(), videos.get(1).getDescription(), videos.get(1).getVideoPublishDate(),videos.get(1).getViewCount(),
                videos.get(1).getLikeCount(), videos.get(1).getCommentCount(), videos.get(2).getId(),  videos.get(2).getChannelName(),videos.get(2).getTitle(), videos.get(2).getDescription(), videos.get(2).getVideoPublishDate(), videos.get(2).getViewCount(), videos.get(2).getLikeCount(),videos.get(2).getCommentCount());


        trendingPresenter.prepareDataView(trendingOutputData);

    }

}
