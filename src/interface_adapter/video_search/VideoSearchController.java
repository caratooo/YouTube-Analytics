package interface_adapter.video_search;

import use_case.video_search.VideoSearchInputBoundary;
import use_case.video_search.VideoSearchInputData;

public class VideoSearchController {

    final VideoSearchInputBoundary videoUseCaseInteractor;

    public VideoSearchController(VideoSearchInputBoundary videoUseCaseInteractor) {
        this.videoUseCaseInteractor = videoUseCaseInteractor;
    }

    public void execute(String videoId) {
        VideoSearchInputData videoSearchInputData = new VideoSearchInputData(videoId);

        videoUseCaseInteractor.execute(videoSearchInputData);
    }


}
