package interface_adapter.compare_search;

public class CompareSearchState {

    private String videoOneId = "";
    private String videoTwoId = "";
    private String videoIdError = null;

    public CompareSearchState(CompareSearchState copy){
        videoOneId = copy.videoOneId;
        videoTwoId = copy.videoTwoId;
    }
    public CompareSearchState(){

    }
    public String getVideoOneId() {
        return videoOneId;
    }

    public void setVideoOneId(String videoOneId) {
        this.videoOneId = videoOneId;
    }

    public String getVideoTwoId() {
        return videoTwoId;
    }

    public void setVideoTwoId(String videoTwoId) {
        this.videoTwoId = videoTwoId;
    }

    public String getVideoIdError() {
        return videoIdError;
    }

    public void setVideoIdError(String videoIdError) {
        this.videoIdError = videoIdError;
    }

}
