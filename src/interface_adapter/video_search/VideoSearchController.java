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
    public void callExecute(String data) {
        execute(data.split(",")[1]);
    }

    public void execute(String videoId) throws GeneralSecurityException, IOException {
        VideoSearchInputData videoSearchInputData = new VideoSearchInputData(videoId);

        videoUseCaseInteractor.execute(videoSearchInputData);
    }

}
