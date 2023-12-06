package interface_adapter.video_search;

import use_case.video_search.VideoSearchInputBoundary;
import use_case.video_search.VideoSearchInputData;
import interface_adapter.SearchController;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class VideoSearchController implements SearchController {

    final VideoSearchInputBoundary videoUseCaseInteractor;

    public VideoSearchController(VideoSearchInputBoundary videoUseCaseInteractor) {
        this.videoUseCaseInteractor = videoUseCaseInteractor;
    }

    @Override
    public void callExecute(String data, String username) throws GeneralSecurityException, IOException {
        execute(data.split(",")[0], username);
    }

    public void execute(String videoId, String username) throws GeneralSecurityException, IOException {
        VideoSearchInputData videoSearchInputData = new VideoSearchInputData(videoId, username);

        videoUseCaseInteractor.execute(videoSearchInputData);
    }

}
