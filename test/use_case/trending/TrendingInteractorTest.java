package use_case.trending;

import data_access.YouTubeDataAccess;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class TrendingInteractorTest {
    @Test
    void successTest() throws GeneralSecurityException, IOException {
        TrendingInputData inputdata = new TrendingInputData("0"); // "0" represents general

        YouTubeDataAccess trendingDataAccess = new YouTubeDataAccess();

        TrendingOutputBoundary presenter = new TrendingOutputBoundary() {
            @Override
            public void prepareDataView(TrendingOutputData videos) {
                assertEquals(inputdata.getCategoryStr(), videos.getCategory());
                // Top 1
                assertNotNull(videos.getTopOneVideoId());
                assertNotNull(videos.getTopOneChannelName());
                assertNotNull(videos.getTopOneTitle());
                assertNotNull(videos.getTopOneDescription());
                assertNotNull(videos.getTopOnePublishDate());
                assertNotNull(videos.getTopOneViewCount());
                assertNotNull(videos.getTopOneLikeCount());
                assertNotNull(videos.getTopOneCommentCount());

                // Top 2
                assertNotNull(videos.getTopTwoVideoId());
                assertNotNull(videos.getTopTwoChannelName());
                assertNotNull(videos.getTopTwoTitle());
                assertNotNull(videos.getTopTwoDescription());
                assertNotNull(videos.getTopTwoPublishDate());
                assertNotNull(videos.getTopTwoViewCount());
                assertNotNull(videos.getTopTwoLikeCount());
                assertNotNull(videos.getTopTwoCommentCount());

                // Top 3
                assertNotNull(videos.getTopThreeVideoId());
                assertNotNull(videos.getTopThreeChannelName());
                assertNotNull(videos.getTopThreeTitle());
                assertNotNull(videos.getTopThreeDescription());
                assertNotNull(videos.getTopThreePublishDate());
                assertNotNull(videos.getTopThreeViewCount());
                assertNotNull(videos.getTopThreeLikeCount());
                assertNotNull(videos.getTopThreeCommentCount());
            }

        };
         TrendingInputBoundary interactor = new TrendingInteractor(trendingDataAccess, presenter);
         interactor.execute(inputdata);

    }

}
