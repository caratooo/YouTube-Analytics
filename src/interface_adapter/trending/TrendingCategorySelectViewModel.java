package interface_adapter.trending;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrendingCategorySelectViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Trending Category Select View";
    public static final String SELECT_BUTTON_LABEL = "Select";

    private TrendingCategorySelectState state = new TrendingCategorySelectState();

    public TrendingCategorySelectViewModel(){super("Trending");}
    public void setState(TrendingCategorySelectState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TrendingCategorySelectState getState() {return state;}
}
