package app;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.trending_data.TrendingDataViewModel;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;


public class Main {
    public static void main(String[] args){

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

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeViewModel, signupViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        HomeView homeView = new HomeView(homeViewModel, signupViewModel, viewManagerModel);
        views.add(homeView, homeView.viewName);

        YouTubeDataAccess trendingDataAccess = new YouTubeDataAccess();

        TrendingCategorySelectView trendingCategorySelectView =  TrendingUseCaseFactory.create(viewManagerModel, trendingCategorySelectViewModel, trendingDataViewModel, trendingDataAccess, homeViewModel);
        views.add(trendingCategorySelectView, trendingCategorySelectView.viewName);

        TrendingDataView trendingDataView = new TrendingDataView(trendingDataViewModel, homeViewModel, viewManagerModel);
        views.add(trendingDataView, trendingDataView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }

}
