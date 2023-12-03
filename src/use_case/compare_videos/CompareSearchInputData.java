package use_case.compare_videos;

public class CompareSearchInputData {

    final private String videoOneId;
    final private String videoTwoId;
    public CompareSearchInputData(String videoOneId, String videoTwoId) {
        this.videoOneId = videoOneId;
        this.videoTwoId = videoTwoId;
    }
}
