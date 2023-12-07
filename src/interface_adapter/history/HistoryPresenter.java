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

    /**
     * Sends username and user history to the view model
     * @param historyOutputData includes (String) username and (List of Strings) user history
     */
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

    /**
     * Sets the user history error in the view model to (String) error
     * @param error the message to show for the user
     */
    @Override
    public void prepareFailView(String error) {
        HistoryState historyState = historyViewModel.getState();
        historyState.setUserHistoryError(error);
        historyViewModel.firePropertyChanged();
    }
}
