package interface_adapter.history;

import org.junit.jupiter.api.Test;
import use_case.history.HistoryInputBoundary;
import use_case.history.HistoryInputData;

import static org.junit.jupiter.api.Assertions.*;


public class HistoryControllerTest {

    @Test
    void successTest() {
        String user = "alex";

        HistoryInputBoundary interactor = new HistoryInputBoundary() {
            @Override
            public void execute(HistoryInputData historyInputData) {
                assertEquals("alex", historyInputData.getIdentifier());
            }
        };

        HistoryController controller = new HistoryController(interactor);
        controller.execute(user);
    }
}
