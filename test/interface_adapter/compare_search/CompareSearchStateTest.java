package interface_adapter.compare_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchStateTest {
    CompareSearchState compareSearchState1 = new CompareSearchState();

    @Test
    void setGetVideoId() {
        assertEquals(compareSearchState1.getVideoOneId(), "");
        compareSearchState1.setVideoOneId("id");
        assertEquals(compareSearchState1.getVideoOneId(), "id");
        assertEquals(compareSearchState1.getVideoTwoId(), "");
        compareSearchState1.setVideoTwoId("id");
        assertEquals(compareSearchState1.getVideoTwoId(), "id");
    }

    @Test
    void setGetVideoIdError() {
        assertNull(compareSearchState1.getVideoIdError());
        compareSearchState1.setVideoIdError("error");
        assertEquals(compareSearchState1.getVideoIdError(), "error");
    }

    @Test
    void copyTest() {
        compareSearchState1.setVideoOneId("id");
        CompareSearchState videoSearchState2 = new CompareSearchState(compareSearchState1);
        assertEquals(videoSearchState2.getVideoOneId(), compareSearchState1.getVideoOneId());
    }

}