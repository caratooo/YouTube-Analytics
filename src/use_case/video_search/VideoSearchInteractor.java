package use_case.video_search;

//import java.time.LocalDateTime;

public class VideoSearchInteractor implements VideoSearchInputBoundary {

    final VideoSearchDataAccessInterface videoSearchDataAccessObject;

    final VideoSearchOutputBoundary videoPresenter;

    // TODO design pattern???? (see sign up's factory in SignupInteractor)

    public VideoSearchInteractor(VideoSearchDataAccessInterface videoSearchDataAccessInterface,
                                 VideoSearchOutputBoundary videoSearchOutputBoundary) {
        this.videoSearchDataAccessObject = videoSearchDataAccessInterface;
        this.videoPresenter = videoSearchOutputBoundary;
    }


    @Override
    public void execute(VideoSearchInputData videoSearchInputData) {
        if (videoSearchDataAccessObject.idInvalid(videoSearchInputData.getVideoId())) {
            videoPresenter.prepareFailView("Video ID does not exist.");
        } else {

//            LocalDateTime now = LocalDateTime.now();

            Video video = videoFactory.create(videoSearchInputData.getVideoId());

            videoSearchDataAccessObject.save(video);  // TODO this DAO or another that does the history stuff?

            VideoSearchOutputData videoSearchOutputData = new VideoSearchOutputData(video.getName(), video.getStats(), false);
            videoPresenter.prepareSuccessView(videoSearchOutputData);

        }
    }
}
