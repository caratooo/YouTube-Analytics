package interface_adapter.compare_search;

import com.google.api.client.util.DateTime;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchOutputData;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchPresenterTest {
    @Test
    void successTest() {

        DateTime dateTime1 = new DateTime("2020-02-19T18:48:38.000Z");
        DateTime dateTime2 = new DateTime("2020-03-30T18:48:38.000Z");
        CompareSearchOutputData output = new CompareSearchOutputData("H-v6DfxnjF8",
                "FIE Fencing Channel",
                "Grand Prix Turin 2020 Women's Foil Final THIBUS FRA vs KIEFER USA",
                "",
                dateTime1,
                12996,
                169,
                9,
                "-cz8aF8tkFc",
                "FIE Fencing Channel",
                "Nick Itkin // foil USA",
                "With the news of the Olympics being postponed, we will still be posting stories we filmed with athletes earlier in the year. We hope this helps in keeping spirits up! This video is a profile with Nick Itkin about his move from Junior to Senior athlete",
                dateTime2,
                6080,
                223,
                0, false);

        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();

        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        CompareSearchPresenter presenter = new CompareSearchPresenter(compareSearchViewModel, compareStatsViewModel, viewManagerModel);
        presenter.prepareSuccessView(output);

    }

    @Test
    void failureTest() {

        String error = "Video ID does not exist.";

        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();

        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        CompareSearchPresenter presenter = new CompareSearchPresenter(compareSearchViewModel, compareStatsViewModel, viewManagerModel);
        presenter.prepareFailView(error);

    }

}