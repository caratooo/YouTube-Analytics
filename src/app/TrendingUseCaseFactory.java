package app;

import entities.CommonUserFactory;
import entities.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.trending.TrendingCategorySelectViewModel;
import interface_adapter.trending.TrendingController;
import interface_adapter.trending.TrendingDataViewModel;
import interface_adapter.trending.TrendingPresenter;
import use_case.login.LoginDataAccessInterface;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.trending.TrendingDataAccessInterface;
import use_case.trending.TrendingInputBoundary;
import use_case.trending.TrendingInteractor;
import use_case.trending.TrendingOutputBoundary;
import views.LoginView;
import views.TrendingCategorySelectView;

import javax.swing.*;
import java.io.IOException;

public class TrendingUseCaseFactory {
    private TrendingUseCaseFactory() {}

    public static TrendingCategorySelectView create(
            ViewManagerModel viewManagerModel,
            TrendingCategorySelectViewModel trendingCategorySelectViewModel,
            TrendingDataViewModel trendingDataViewModel,
            TrendingDataAccessInterface trendingDataAccessObject,
            HomeViewModel homeViewModel) {

        try {
            TrendingController trendingController = createTrendingUseCase(viewManagerModel, trendingCategorySelectViewModel,trendingDataViewModel, trendingDataAccessObject, homeViewModel);
            return new TrendingCategorySelectView(trendingController, trendingCategorySelectViewModel, homeViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fail");
        }

        return null;
    }

    private static TrendingController createTrendingUseCase(
            ViewManagerModel viewManagerModel,
            TrendingCategorySelectViewModel trendingCategorySelectViewModel,
            TrendingDataViewModel trendingDataViewModel,
            TrendingDataAccessInterface trendingDataAccessObject,
            HomeViewModel homeViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        TrendingOutputBoundary trendingOutputBoundary = new TrendingPresenter(trendingCategorySelectViewModel, trendingDataViewModel, viewManagerModel);

        TrendingInputBoundary trendingInteractor = new TrendingInteractor(
                trendingDataAccessObject, trendingOutputBoundary);

        return new TrendingController(trendingInteractor);
    }
}
