package interface_adapter.trending;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrendingDataViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Trending Data View";
    private TrendingDataState state = new TrendingDataState();

    public TrendingDataViewModel(){super("trending data");}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
