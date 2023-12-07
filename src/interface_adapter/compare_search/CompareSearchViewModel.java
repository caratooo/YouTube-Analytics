package interface_adapter.compare_search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CompareSearchViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Compare Videos Search View";
    public static final String VIDEO_ID_LABEL = "Input a video ID";
    public static final String SEARCH_BUTTON_LABEL = "Compare";
    public static final String BACK_BUTTON_LABEL = "Back to Home";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private CompareSearchState state = new CompareSearchState();

    public CompareSearchState getState() {
        return state;
    }

    public void setState(CompareSearchState state) { this.state = state; }
    public CompareSearchViewModel() {
        super("compare");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
