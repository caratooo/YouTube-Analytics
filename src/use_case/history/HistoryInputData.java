package use_case.history;

public class HistoryInputData {
    private final String identifier;

    public HistoryInputData(String identifier) {
        this.identifier = identifier;
    }

    String getIdentifier() {
        return identifier;
    }
}
