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
    public void execute(TrendingInputData trendingInputData) throws GeneralSecurityException, IOException {
        System.out.println("trendingInputData:" + trendingInputData.getCategoryId());
        System.out.println("general? " + (trendingInputData.equal("0")));
        if (trendingInputData.equal("0")){
            ArrayList<Video> videos = trendingDataAccessObject.get_trending_default();
            System.out.println(videos);
            TrendingOutputData trendingOutputData = output(videos);
            trendingPresenter.prepareDataView(trendingOutputData);
//            try {
//                ArrayList<Video> videos = trendingDataAccessObject.get_trending_default();
//                System.out.println(videos);
//                TrendingOutputData trendingOutputData = output(videos);
//            } catch (GeneralSecurityException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }
        else{
            // get trend by category
            ArrayList<Video> videos = trendingDataAccessObject.get_trending_category(trendingInputData.getCategoryId());
            System.out.println(videos);
            TrendingOutputData trendingOutputData = output(videos);
            trendingPresenter.prepareDataView(trendingOutputData);
//            try {
//                ArrayList<Video> videos = trendingDataAccessObject.get_trending_category(trendingInputData.getCategoryId());
//                System.out.println(videos);
//                TrendingOutputData trendingOutputData = output(videos);
//            } catch (GeneralSecurityException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
        }


    }

    private TrendingOutputData output(ArrayList<Video> videos){
        TrendingOutputData trendingOutputData = new TrendingOutputData(videos.get(0).getId(),videos.get(0).getTitle(), videos.get(0).getDescription(), videos.get(0).getViewCount(),
                videos.get(0).getLikeCount(), videos.get(0).getCommentCount(), videos.get(1).getId(),videos.get(1).getTitle(), videos.get(1).getDescription(), videos.get(1).getViewCount(),
                videos.get(1).getLikeCount(), videos.get(1).getCommentCount(), videos.get(2).getId(),videos.get(0).getTitle(), videos.get(2).getDescription(), videos.get(2).getViewCount(),
                videos.get(2).getLikeCount(), videos.get(2).getCommentCount());
        return trendingOutputData;
    }
}
