package app;

import interface_adapter.SearchController;
import interface_adapter.ViewManagerModel;
import interface_adapter.compare.CompareController;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryPresenter;
import interface_adapter.history.HistoryViewModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_search.VideoSearchController;
import interface_adapter.video_search.VideoSearchViewModel;
import use_case.history.HistoryDataAccessInterface;
import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInteractor;
import use_case.history.HistoryOutputBoundary;
import views.HistoryView;

import javax.swing.*;
import java.io.IOException;

public class HistoryUseCaseFactory {
    /** Prevent instantiation. */
    HistoryUseCaseFactory() {}

    public static HistoryView create(
            ViewManagerModel viewManagerModel,
            HistoryViewModel historyViewModel,
            HistoryDataAccessInterface historyDataAccessInterface,
            HomeViewModel homeViewModel) {

        try {
            HistoryController historyController = createUserHistoryUseCase(
                    viewManagerModel, historyViewModel, historyDataAccessInterface
            );
            SearchController compareController = new CompareController();
            SearchController videoSearchController = new VideoSearchController();

            return new HistoryView(historyController, historyViewModel, compareController, videoSearchController, homeViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    public static HistoryController createUserHistoryUseCase(
            ViewManagerModel viewManagerModel,
            HistoryViewModel historyViewModel,
            HistoryDataAccessInterface historyDataAccessInterface) throws IOException {

        HistoryOutputBoundary historyOutputBoundary = new HistoryPresenter(historyViewModel, viewManagerModel);

        HistoryInputBoundary historyInteractor = new HistoryInteractor(historyDataAccessInterface, historyOutputBoundary);

        return new HistoryController(historyInteractor);
    }
}
