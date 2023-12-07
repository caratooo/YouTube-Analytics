package interface_adapter.compare_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchViewModelTest {
    CompareSearchState compareSearchState = new CompareSearchState();

    CompareSearchViewModel compareSearchViewModel = new CompareSearchViewModel();

    @Test
    void setGetState() {
        assertNotEquals(compareSearchViewModel.getState(), compareSearchState);
        compareSearchState.setVideoOneId("id");
        compareSearchState.setVideoTwoId("id");
        compareSearchViewModel.setState(compareSearchState);
        assertEquals(compareSearchViewModel.getState(), compareSearchState);
    }

}