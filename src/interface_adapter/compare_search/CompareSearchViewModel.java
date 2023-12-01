package interface_adapter.compare_search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CompareSearchViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
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
