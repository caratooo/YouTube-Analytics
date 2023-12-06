package app;

import data_access.FileHistoryDataAccessObject;
import data_access.FileUserDataAccessObject;
import data_access.YouTubeDataAccess;
import entities.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        JFrame application = new JFrame("Youtube Analytics");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        HomeViewModel homeViewModel = new HomeViewModel();
        TrendingCategorySelectViewModel trendingCategorySelectViewModel =  new TrendingCategorySelectViewModel();
        TrendingDataViewModel trendingDataViewModel = new TrendingDataViewModel();
        HistoryViewModel historyViewModel = new HistoryViewModel();
        CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();
        CompareStatsViewModel compareStatsViewModel = new CompareStatsViewModel();


        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileHistoryDataAccessObject historyDataAccessObject;
        try {
            historyDataAccessObject = new FileHistoryDataAccessObject(userDataAccessObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        YouTubeDataAccess trendingDataAccess = new YouTubeDataAccess();

        YouTubeDataAccess youTubeDataAccess;
        youTubeDataAccess = new YouTubeDataAccess();


        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeViewModel, signupViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        HistoryView historyView = HistoryUseCaseFactory.create(viewManagerModel, historyViewModel, historyDataAccessObject, homeViewModel);
        views.add(historyView, historyView.viewName);
        HomeView homeView = new HomeView(homeViewModel, signupViewModel, trendingCategorySelectViewModel,viewManagerModel, compareSearchViewModel, compareStatsViewModel);
        CompareSearchView compareSearchView = CompareVideoUseCaseFactory.create(viewManagerModel, compareSearchViewModel, compareStatsViewModel, homeViewModel, youTubeDataAccess);
        views.add(compareSearchView, compareSearchView.viewName);

        CompareStatsView compareStatsView = new CompareStatsView(compareStatsViewModel, homeViewModel, viewManagerModel);
        views.add(compareStatsView, compareStatsView.viewName);


        views.add(homeView, homeView.viewName);

        YouTubeDataAccess trendingDataAccess = new YouTubeDataAccess();

        TrendingCategorySelectView trendingCategorySelectView =  TrendingUseCaseFactory.create(viewManagerModel, trendingCategorySelectViewModel, trendingDataViewModel, trendingDataAccess, homeViewModel);
        views.add(trendingCategorySelectView, trendingCategorySelectView.viewName);

        TrendingDataView trendingDataView = new TrendingDataView(trendingDataViewModel, homeViewModel, viewManagerModel);
        views.add(trendingDataView, trendingDataView.viewName);

        HomeView homeView = new HomeView(homeViewModel, signupViewModel, trendingCategorySelectViewModel, viewManagerModel,
                HistoryUseCaseFactory.createUserHistoryUseCase(viewManagerModel, historyViewModel, historyDataAccessObject),
                loginViewModel);
        views.add(homeView, homeView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
