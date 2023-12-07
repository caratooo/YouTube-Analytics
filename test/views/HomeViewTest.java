package views;

import app.HistoryUseCaseFactory;
import data_access.InMemoryHistoryDataAccessObject;
import data_access.VideoSearchDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryPresenter;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.history.HistoryDataAccessInterface;
import use_case.history.HistoryInteractor;
import use_case.video_search.VideoSearchDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class HomeViewTest {

    @Test
    void initialize() {
        HomeViewModel homeViewModel = new HomeViewModel();
        TrendingCategorySelectViewModel trendingCategorySelectViewModel = new TrendingCategorySelectViewModel();
        VideoSearchViewModel videoSearchViewModel = new VideoSearchViewModel();
        VideoStatsViewModel videoStatsViewModel = new VideoStatsViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        HistoryDataAccessInterface historyDataAccessInterface = new InMemoryHistoryDataAccessObject();
        HistoryController historyController = HistoryUseCaseFactory.createUserHistoryUseCase(viewManagerModel, historyViewModel, historyDataAccessInterface);
        LoginViewModel loginViewModel = new LoginViewModel();
        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();

        HomeView homeView = new HomeView(homeViewModel, trendingCategorySelectViewModel, videoSearchViewModel, videoStatsViewModel,
                viewManagerModel, historyController, loginViewModel, compareSearchViewModel, compareStatsViewModel);

    }

}