package interface_adapter.home;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Home";
    public static final String SEARCHVIDEO_BUTTON_LABEL = "Search Video";
    public static final String SEARCHCHANNEL_BUTTON_LABEL = "Search Channel";
    public static final String TRENDING_BUTTON_LABEL = "Trending";
    public static final String COMPARE_BUTTON_LABEL = "Compare";
    public static final String HISTORY_BUTTON_LABEL = "History";
    public static final String INSTRUCTION_BUTTON_LABEL = "Instruction";

    public static final String LOGOUT_BUTTON_LABEL = "Log Out";
    private HomeState state = new HomeState();

    public HomeViewModel(){
        super("home");
    }

    public void setState(HomeState state) {
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

    public HomeState getState() {
        return state;
    }
}
