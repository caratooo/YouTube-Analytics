package use_case.trending;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

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
        System.out.println("trendingInputData:" + trendingInputData.getCategoryId());
        System.out.println("general?" + (trendingInputData.equal("0")));
        if (trendingInputData.equal("0")){
            try {
                ArrayList<Video> videos = trendingDataAccessObject.get_trending_default();
                System.out.println(videos);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else{
            // get trend by category
            try {
                ArrayList<Video> videos = trendingDataAccessObject.get_trending_category(trendingInputData.getCategoryId());
                System.out.println(videos);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
