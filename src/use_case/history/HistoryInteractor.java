package use_case.history;

import java.util.List;

public class HistoryInteractor implements HistoryInputBoundary {
    final HistoryDataAccessInterface historyDataAccessInterface;
    final HistoryOutputBoundary historyPresenter;

    public HistoryInteractor(HistoryDataAccessInterface historyDataAccessInterface,
                             HistoryOutputBoundary historyPresenter) {
        this.historyDataAccessInterface = historyDataAccessInterface;
        this.historyPresenter = historyPresenter;
    }

    /**
     * Tells the presenter to either send an error message to the history view if a user does not have a history or
     * displays the user's (up to 5) most recent queries
     * @param historyInputData includes the user's username to check
     */
    @Override
    public void execute(HistoryInputData historyInputData) {
        if (!historyDataAccessInterface.doesUserHistoryExist(historyInputData.getIdentifier())) {
            historyPresenter.prepareFailView("No history to view");
        } else {
            List<String> userHistory = historyDataAccessInterface.getUserHistory(historyInputData.getIdentifier());
            HistoryOutputData historyOutputData = new HistoryOutputData(historyInputData.getIdentifier(), userHistory);

            historyPresenter.prepareSuccessView(historyOutputData);
        }
    }
}
