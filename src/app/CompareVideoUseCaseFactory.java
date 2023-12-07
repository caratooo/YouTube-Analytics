package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.compare_search.CompareSearchController;
import interface_adapter.compare_search.CompareSearchPresenter;
import interface_adapter.compare_search.CompareSearchViewModel;
import interface_adapter.compare_stats.CompareStatsViewModel;
import use_case.compare_videos.*;
import views.CompareSearchView;

import javax.swing.*;
import java.io.IOException;
public class CompareVideoUseCaseFactory {
    private CompareVideoUseCaseFactory() {}
    public static CompareSearchView create(
            ViewManagerModel viewManagerModel,
            CompareSearchViewModel compareSearchViewModel,
            CompareStatsViewModel compareStatsViewModel,
            HomeViewModel homeViewModel,
            CompareSearchUserDataAccessInterface userDataAccessInterface,
            CompareSearchDataAccessInterface youtubeDataAccessObject) {

        try {
            CompareSearchController compareSearchController = createCompareSearchUseCase(viewManagerModel, compareSearchViewModel, compareStatsViewModel,userDataAccessInterface, youtubeDataAccessObject);
            return new CompareSearchView(compareSearchViewModel,compareSearchController, homeViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static CompareSearchController createCompareSearchUseCase(
            ViewManagerModel viewManagerModel,
            CompareSearchViewModel compareSearchViewModel,
            CompareStatsViewModel compareStatsViewModel,
            CompareSearchUserDataAccessInterface userDataAccessInterface,
            CompareSearchDataAccessInterface youtubeDataAccessObject) throws IOException {

        CompareSearchOutputBoundary compareSearchOutputBoundary = new CompareSearchPresenter(compareSearchViewModel, compareStatsViewModel, viewManagerModel);

        CompareSearchInputBoundary compareSearchInteractor = new CompareSearchInteractor(youtubeDataAccessObject, userDataAccessInterface, compareSearchOutputBoundary);

        return new CompareSearchController(compareSearchInteractor);

    }
}
