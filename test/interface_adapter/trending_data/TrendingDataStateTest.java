package interface_adapter.trending_data;

import com.google.api.client.util.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrendingDataStateTest {
    TrendingDataState trendingDataState = new TrendingDataState();

    @Test
    void setGetCategory() {
        assertEquals(trendingDataState.getCategory(), "0");
        trendingDataState.setCategory("17");
        assertEquals(trendingDataState.getCategory(), "17");

    }

    @Test
    void setGetTopOneVideoId() {
        assertEquals(trendingDataState.getTopOneVideoId(), "");
        trendingDataState.setTopOneVideoId("123");
        assertEquals(trendingDataState.getTopOneVideoId(), "123");

    }

    @Test
    void setGetTopOneChannelName() {
        assertEquals(trendingDataState.getTopOneChannelName(), "");
        trendingDataState.setTopOneChannelName("a");
        assertEquals(trendingDataState.getTopOneChannelName(), "a");

    }


    @Test
    void setGetTopOneTitle() {
        assertEquals(trendingDataState.getTopOneTitle(), "");
        trendingDataState.setTopOneTitle("b");
        assertEquals(trendingDataState.getTopOneTitle(), "b");

    }

    @Test
    void setGetTopOneDescription() {
        assertEquals(trendingDataState.getTopOneDescription(), "");
        trendingDataState.setTopOneDescription("c");
        assertEquals(trendingDataState.getTopOneDescription(), "c");
    }

    @Test
    void setGetTopOneVideoPublishDate() {
        assertEquals(trendingDataState.getTopOneVideoPublishDate(), new DateTime("2013-02-14T13:15:03-08:00"));
        DateTime dateTime1 = new DateTime("2001-01-01T18:48:38.000Z");
        trendingDataState.setTopOneVideoPublishDate(dateTime1);
        assertEquals(trendingDataState.getTopOneVideoPublishDate(), dateTime1);
    }


    @Test
    void setGetTopOneViewCount() {
        assertEquals(trendingDataState.getTopOneViewCount(), 0);
        trendingDataState.setTopOneViewCount(1);
        assertEquals(trendingDataState.getTopOneViewCount(), 1);

    }

    @Test
    void setGetTopOneLikeCount() {
        assertEquals(trendingDataState.getTopOneLikeCount(), 0);
        trendingDataState.setTopOneLikeCount(2);
        assertEquals(trendingDataState.getTopOneLikeCount(), 2);

    }

    @Test
    void setGetTopOneCommentCount() {
        assertEquals(trendingDataState.getTopOneCommentCount(), 0);
        trendingDataState.setTopOneCommentCount(3);
        assertEquals(trendingDataState.getTopOneCommentCount(), 3);

    }

    @Test
    void setGetTopTwoVideoId() {
        assertEquals(trendingDataState.getTopTwoVideoId(), "");
        trendingDataState.setTopTwoVideoId("456");
        assertEquals(trendingDataState.getTopTwoVideoId(), "456");

    }

    @Test
    void setGetTopTwoChannelName() {
        assertEquals(trendingDataState.getTopTwoChannelName(), "");
        trendingDataState.setTopTwoChannelName("d");
        assertEquals(trendingDataState.getTopTwoChannelName(), "d");
    }

    @Test
    void setGetTopTwoTitle() {
        assertEquals(trendingDataState.getTopTwoTitle(), "");
        trendingDataState.setTopTwoTitle("e");
        assertEquals(trendingDataState.getTopTwoTitle(), "e");
    }


    @Test
    void setgetTopTwoDescription() {
        assertEquals(trendingDataState.getTopTwoDescription(), "");
        trendingDataState.setTopTwoDescription("f");
        assertEquals(trendingDataState.getTopTwoDescription(), "f");

    }

    @Test
    void setGetTopTwoVideoPublishDate() {
        assertEquals(trendingDataState.getTopTwoVideoPublishDate(), new DateTime("2013-02-14T13:15:03-08:00"));
        DateTime dateTime2 = new DateTime("2002-01-01T18:48:38.000Z");
        trendingDataState.setTopTwoVideoPublishDate(dateTime2);
        assertEquals(trendingDataState.getTopTwoVideoPublishDate(), dateTime2);
    }

    @Test
    void setGetTopTwoViewCount() {
        assertEquals(trendingDataState.getTopTwoViewCount(), 0);
        trendingDataState.setTopTwoViewCount(4);
        assertEquals(trendingDataState.getTopTwoViewCount(), 4);
    }

    @Test
    void setGetTopTwoLikeCount() {
        assertEquals(trendingDataState.getTopTwoLikeCount(), 0);
        trendingDataState.setTopTwoLikeCount(5);
        assertEquals(trendingDataState.getTopTwoLikeCount(), 5);
    }

    @Test
    void setGetTopTwoCommentCount() {
        assertEquals(trendingDataState.getTopTwoCommentCount(), 0);
        trendingDataState.setTopTwoCommentCount(6);
        assertEquals(trendingDataState.getTopTwoCommentCount(), 6);
    }

    @Test
    void setGetTopThreeVideoId() {
        assertEquals(trendingDataState.getTopThreeVideoId(), "");
        trendingDataState.setTopThreeVideoId("122");
        assertEquals(trendingDataState.getTopThreeVideoId(), "122");
    }

    @Test
    void setGetTopThreeChannelName() {
        assertEquals(trendingDataState.getTopThreeChannelName(), "");
        trendingDataState.setTopThreeChannelName("few");
        assertEquals(trendingDataState.getTopThreeChannelName(), "few");
    }


    @Test
    void setGetTopThreeTitle() {
        assertEquals(trendingDataState.getTopThreeTitle(), "");
        trendingDataState.setTopThreeTitle("ei");
        assertEquals(trendingDataState.getTopThreeTitle(), "ei");
    }

    @Test
    void setGetTopThreeDescription() {
        assertEquals(trendingDataState.getTopThreeDescription(), "");
        trendingDataState.setTopThreeDescription("fq");
        assertEquals(trendingDataState.getTopThreeDescription(), "fq");
    }

    @Test
    void setGetTopThreeVideoPublishDate() {
        assertEquals(trendingDataState.getTopThreeVideoPublishDate(), new DateTime("2013-02-14T13:15:03-08:00"));
        DateTime dateTime3 = new DateTime("2003-01-01T18:48:38.000Z");
        trendingDataState.setTopThreeVideoPublishDate(dateTime3);
        assertEquals(trendingDataState.getTopThreeVideoPublishDate(), dateTime3);
    }

    @Test
    void setGetTopThreeViewCount() {
        assertEquals(trendingDataState.getTopThreeViewCount(), 0);
        trendingDataState.setTopThreeViewCount(7);
        assertEquals(trendingDataState.getTopThreeViewCount(), 7);
    }

    @Test
    void setGetTopThreeLikeCount() {
        assertEquals(trendingDataState.getTopThreeLikeCount(), 0);
        trendingDataState.setTopThreeLikeCount(8);
        assertEquals(trendingDataState.getTopThreeLikeCount(), 8);
    }

    @Test
    void setGetTopThreeCommentCount() {
        assertEquals(trendingDataState.getTopThreeCommentCount(), 0);
        trendingDataState.setTopThreeCommentCount(9);
        assertEquals(trendingDataState.getTopThreeCommentCount(), 9);
    }

    @Test
    void copyTest() {
        TrendingDataState trendingDataStateCopy = new TrendingDataState(trendingDataState);
        assertEquals(trendingDataStateCopy.getTopOneVideoId(), trendingDataState.getTopOneVideoId());
    }
}
