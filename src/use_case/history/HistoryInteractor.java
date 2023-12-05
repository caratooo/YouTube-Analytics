package use_case.history;

import java.util.Collections;
import java.util.List;

public class HistoryInteractor implements HistoryInputBoundary {
    final HistoryDataAccessInterface historyDataAccessInterface;
    final HistoryOutputBoundary historyPresenter;

    public HistoryInteractor(HistoryDataAccessInterface historyDataAccessInterface,
                             HistoryOutputBoundary historyPresenter) {
        this.historyDataAccessInterface = historyDataAccessInterface;
        this.historyPresenter = historyPresenter;
    }

    @Override
    public void execute(HistoryInputData historyInputData) {
        if (!historyDataAccessInterface.doesUserFileExist(historyInputData.getIdentifier())) {
            historyPresenter.prepareFailView("No history to view");
        } else {
            System.out.println(historyDataAccessInterface.getUserHistory(historyInputData.getIdentifier()).size());

            List<String> userHistory = historyDataAccessInterface.getUserHistory(historyInputData.getIdentifier());
            HistoryOutputData historyOutputData = new HistoryOutputData(historyInputData.getIdentifier(), userHistory);

            historyPresenter.prepareSuccessView(historyOutputData);
        }
    }
}
