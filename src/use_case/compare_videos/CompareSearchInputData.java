package use_case.compare_videos;

public class CompareSearchInputData {

    final private String videoOneId;
    final private String videoTwoId;
    final private String username;

    public String getVideoOneId() {
        return videoOneId;
    }

    public String getVideoTwoId() {
        return videoTwoId;
    }

    public CompareSearchInputData(String videoOneId, String videoTwoId, String username) {
        this.videoOneId = videoOneId;
        this.videoTwoId = videoTwoId;
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
}
