package interface_adapter.compare;

import interface_adapter.SearchController;

public class CompareController implements SearchController {

    @Override
    public void callExecute(String data, String username) {
        String[] videos = data.split(",");
        execute(videos[0], videos[1]);
    }

    public void execute(String video1, String video2) {
    }
}
