package interface_adapter.video_stats;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VideoStatsViewModel extends ViewModel {

    public final String TITLE_LABEL = "Video Stats View";

    private VideoStatsState state = new VideoStatsState();

    public VideoStatsViewModel() { super("video stats"); }

    public VideoStatsState getState() { return state; }

    public void setState(VideoStatsState state) { this.state = state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
