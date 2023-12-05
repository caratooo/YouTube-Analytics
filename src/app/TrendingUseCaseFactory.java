package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.trending_category_select.TrendingCategorySelectViewModel;
import interface_adapter.trending_category_select.TrendingController;
import interface_adapter.trending_data.TrendingDataViewModel;
import interface_adapter.trending_category_select.TrendingPresenter;
import use_case.trending.TrendingDataAccessInterface;
import use_case.trending.TrendingInputBoundary;
import use_case.trending.TrendingInteractor;
import use_case.trending.TrendingOutputBoundary;
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
