package interface_adapter.history;

import interface_adapter.ViewManagerModel;
import use_case.history.HistoryOutputBoundary;
import use_case.history.HistoryOutputData;

public class HistoryPresenter implements HistoryOutputBoundary {
    private final HistoryViewModel historyViewModel;
    private ViewManagerModel viewManagerModel;


    public HistoryPresenter(HistoryViewModel historyViewModel, ViewManagerModel viewManagerModel) {
        this.historyViewModel = historyViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(HistoryOutputData historyOutputData) {
        HistoryState historyState = historyViewModel.getState();
        historyState.setUsername(historyOutputData.getUsername());
        historyState.setUserHistory(historyOutputData.getUserHistory());
        historyViewModel.setState(historyState);
        historyViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(historyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        HistoryState historyState = historyViewModel.getState();
        historyState.setUserHistoryError(error);
        historyViewModel.firePropertyChanged();
        historyState.setUserHistoryError(null);
    }
}
