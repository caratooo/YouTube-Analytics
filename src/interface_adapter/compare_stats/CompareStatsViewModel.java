package interface_adapter.compare_stats;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CompareStatsViewModel extends ViewModel {
    public final String TITLE_LABEL = "Compare Stats View";
    public static final String BACK_BUTTON_LABEL = "Back to Home";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public CompareStatsState getState() {
        return state;
    }

    public void setState(CompareStatsState state) {
        this.state = state;
    }

    private CompareStatsState state = new CompareStatsState();

    public CompareStatsViewModel() {
        super("compare stats");
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
