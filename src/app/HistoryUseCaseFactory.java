package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare.CompareViewModel;
import interface_adapter.history.HistoryController;
import interface_adapter.history.HistoryPresenter;
import interface_adapter.history.HistoryViewModel;
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
            CompareViewModel compareViewModel,
            VideoSearchViewModel videoSearchViewModel,
            HistoryDataAccessInterface historyDataAccessInterface) {

        try {
            HistoryController historyController = createUserHistoryUseCase(
                    viewManagerModel, historyViewModel, compareViewModel, videoSearchViewModel, historyDataAccessInterface
            );
            return new HistoryView(historyController, historyViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static HistoryController createUserHistoryUseCase(
            ViewManagerModel viewManagerModel,
            HistoryViewModel historyViewModel,
            CompareViewModel compareViewModel,
            VideoSearchViewModel videoSearchViewModel,
            HistoryDataAccessInterface historyDataAccessInterface) throws IOException {

        HistoryOutputBoundary historyOutputBoundary = new HistoryPresenter(historyViewModel, viewManagerModel, compareViewModel, videoSearchViewModel);

        HistoryInputBoundary historyInteractor = new HistoryInteractor(historyDataAccessInterface, historyOutputBoundary);

        return new HistoryController(historyInteractor);
    }
}
