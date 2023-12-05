package interface_adapter.history;

import interface_adapter.ViewManagerModel;
import interface_adapter.compare.CompareViewModel;
import interface_adapter.video_search.VideoSearchViewModel;
import use_case.history.HistoryOutputBoundary;
import use_case.history.HistoryOutputData;

public class HistoryPresenter implements HistoryOutputBoundary {
    private final HistoryViewModel historyViewModel;
    private final CompareViewModel compareViewModel;
    private final VideoSearchViewModel videoSearchViewModel;
    private ViewManagerModel viewManagerModel;


    public HistoryPresenter(HistoryViewModel historyViewModel, ViewManagerModel viewManagerModel, CompareViewModel compareViewModel, VideoSearchViewModel videoSearchViewModel) {
        this.historyViewModel = historyViewModel;
        this.viewManagerModel = viewManagerModel;
        this.compareViewModel = compareViewModel;
        this.videoSearchViewModel = videoSearchViewModel;
    }
    @Override
    public void prepareSuccessView(HistoryOutputData historyOutputData) {
        HistoryState historyState = historyViewModel.getState();
        historyState.setUsername(historyState.getUsername());
        historyState.setUserHistory(historyState.getUserHistory());
        historyViewModel.setState(historyState);

        viewManagerModel.setActiveView(historyViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
