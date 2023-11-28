package interface_adapter.video_search;

import use_case.video_search.VideoSearchInputBoundary;
import use_case.video_search.VideoSearchInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class VideoSearchController {

    final VideoSearchInputBoundary videoUseCaseInteractor;

    public VideoSearchController(VideoSearchInputBoundary videoUseCaseInteractor) {
        this.videoUseCaseInteractor = videoUseCaseInteractor;
    }

    public void execute(String videoId) throws GeneralSecurityException, IOException {
        VideoSearchInputData videoSearchInputData = new VideoSearchInputData(videoId);

        videoUseCaseInteractor.execute(videoSearchInputData);
    }


}
