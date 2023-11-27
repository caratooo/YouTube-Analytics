package interface_adapter.trending;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrendingSelectViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Trending View";

    public static final String GENERAL_BUTTON_LABEL = "General";
    public static final String CATEGORY_BUTTON_LABEL = "Category";

    private TrendingState state = new TrendingState();

    public TrendingSelectViewModel(){super("Trending");}

    public void setState(TrendingState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TrendingState getState() {return state;}
}
