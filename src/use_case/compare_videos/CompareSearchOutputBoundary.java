package use_case.compare_videos;

public interface CompareSearchOutputBoundary {

    void prepareSuccessView(CompareSearchOutputData video);
    void prepareFailView(String error);
}
