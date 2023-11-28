package interface_adapter.video_search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VideoSearchViewModel extends ViewModel {

    public static final String TITLE_LABEL = "Video Search View";
    public static final String VIDEO_ID_LABEL = "Input a video ID";
    public static final String SEARCH_BUTTON_LABEL = "Search";

    public static final String BACK_BUTTON_LABEL = "Back to Home";

    private VideoSearchState state = new VideoSearchState();

    public VideoSearchViewModel() { super("video search"); }

    public void setState(VideoSearchState state) { this.state = state; }

    public VideoSearchState getState() { return state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    // TODO get user??? (see LoggedInViewModel)


}
