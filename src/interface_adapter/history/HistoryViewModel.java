package interface_adapter.history;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HistoryViewModel extends ViewModel {
    public static final String TITLE_LABEL = "History";
    public static final String HOME_BUTTON_LABEL = "Home";
    private HistoryState state = new HistoryState();

    public HistoryViewModel() {
        super("history");
    }

    public void setState(HistoryState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("history", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public HistoryState getState() {
        return state;
    }
}
