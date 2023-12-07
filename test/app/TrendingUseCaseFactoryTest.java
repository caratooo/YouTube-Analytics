package app;

import data_access.FileUserDataAccessObject;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.VideoSearchDataAccessObject;
import data_access.YouTubeDataAccess;
import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.trending.TrendingDataAccessInterface;
import use_case.video_search.VideoSearchDataAccessInterface;
import use_case.video_search.VideoSearchUserDataAccessInterface;
import views.TrendingDataView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TrendingUseCaseFactoryTest {

    ViewManagerModel viewManagerModel = new ViewManagerModel();
    TrendingCategorySelectViewModel trendingCategorySelectViewModel = new TrendingCategorySelectViewModel();
    TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();
    HomeViewModel homeViewModel = new HomeViewModel();

    TrendingDataAccessInterface youtubeDataAccessObject = new YouTubeDataAccess();

    TrendingUseCaseFactoryTest() throws IOException {
    }

    @Test
    void testCreate() {
        assertNotNull(TrendingUseCaseFactory.create(viewManagerModel, trendingCategorySelectViewModel, trendingDataViewModel, youtubeDataAccessObject, homeViewModel));
    }

}