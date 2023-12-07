package interface_adapter.video_search;

import com.google.api.client.util.DateTime;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.video_search.VideoSearchOutputData;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VideoSearchPresenterTest {

    @Test
    void successTest() {

        DateTime dateTime1 = new DateTime("2020-02-19T18:48:38.000Z");
        ArrayList<Object> channelInfo = new ArrayList<>(3);
        channelInfo.add("yuh");
        channelInfo.add(1);
        channelInfo.add(2);
        VideoSearchOutputData output = new VideoSearchOutputData("H-v6DfxnjF8",
                "FIE Fencing Channel",
                "Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA",
                "",
                dateTime1,
                12996,
                169,
                9,
                channelInfo,
                false);

        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();

        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        VideoSearchPresenter presenter = new VideoSearchPresenter(videoSearchViewModel, videoStatsViewModel, viewManagerModel);
        presenter.prepareSuccessView(output);

    }

    @Test
    void failureTest() {

        String error = "Video ID does not exist.";

        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();

        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        VideoSearchPresenter presenter = new VideoSearchPresenter(videoSearchViewModel, videoStatsViewModel, viewManagerModel);
        presenter.prepareFailView(error);

    }

}