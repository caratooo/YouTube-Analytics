package views;

import data_access.YouTubeDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import org.junit.jupiter.api.Test;
import use_case.compare_videos.CompareSearchDataAccessInterface;
import use_case.compare_videos.CompareSearchInputData;
import use_case.trending.TrendingDataAccessInterface;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CompareStatsViewTest {
    @Test
    void initialize() throws IOException {
        CompareSearchDataAccessInterface youtubeRepository = new YouTubeDataAccess();

        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        HomeViewModel homeViewModel = new HomeViewModel();

        CompareStatsView compareStatsView = new CompareStatsView(compareStatsViewModel, homeViewModel, viewManagerModel);

    }

}