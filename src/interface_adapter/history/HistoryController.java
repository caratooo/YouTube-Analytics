package interface_adapter.history;

import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInputData;

public class HistoryController {
    private final HistoryInputBoundary historyUseCaseInteractor;

    public HistoryController(HistoryInputBoundary historyUseCaseInteractor) {
        this.historyUseCaseInteractor = historyUseCaseInteractor;
    }

    /**
     * Calls on the history interactor with the identifier as input data
     * @param identifier the username to check history
     */
    public void execute(String identifier) {
        HistoryInputData historyInputData = new HistoryInputData(identifier);

        historyUseCaseInteractor.execute(historyInputData);
    }
}
