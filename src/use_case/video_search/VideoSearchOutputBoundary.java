package use_case.video_search;

public interface VideoSearchOutputBoundary {

    void prepareSuccessView(VideoSearchOutputData video);

    void prepareFailView(String error);

}
