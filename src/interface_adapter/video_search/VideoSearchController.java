package interface_adapter.video_search;

import interface_adapter.SearchController;

public class VideoSearchController implements SearchController {
    @Override
    public void callExecute(String data) {
        execute(data.split(",")[1]);
    }

    public void execute(String video) {

    }
}
