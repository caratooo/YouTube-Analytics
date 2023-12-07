package views;

import data_access.VideoSearchDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.video_stats.VideoStatsViewModel;
import org.junit.jupiter.api.Test;
import use_case.video_search.VideoSearchDataAccessInterface;

import static org.junit.jupiter.api.Assertions.*;

class InstructionsViewTest {

    @Test
    void test() {
        InstructionsView instructionsView = new InstructionsView();
        instructionsView.openInstructionsPanel();
    }



}