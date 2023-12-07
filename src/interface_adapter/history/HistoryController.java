package interface_adapter.history;

import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInputData;

public class HistoryController {
    private final HistoryInputBoundary historyUseCaseInteractor;

    public HistoryController(HistoryInputBoundary historyUseCaseInteractor) {
        this.historyUseCaseInteractor = historyUseCaseInteractor;
    }

    public void execute(String identifier) {
        HistoryInputData historyInputData = new HistoryInputData(identifier);

        historyUseCaseInteractor.execute(historyInputData);
    }
}
