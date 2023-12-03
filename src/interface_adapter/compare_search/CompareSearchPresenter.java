package interface_adapter.compare_search;

import use_case.compare_videos.CompareSearchOutputBoundary;
import use_case.compare_videos.CompareSearchOutputData;

public class CompareSearchPresenter implements CompareSearchOutputBoundary {
    @Override
    public void prepareSuccessView(CompareSearchOutputData video) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
