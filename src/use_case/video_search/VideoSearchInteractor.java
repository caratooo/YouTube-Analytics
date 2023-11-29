package use_case.video_search;

//import java.time.LocalDateTime;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class VideoSearchInteractor implements VideoSearchInputBoundary {

    final VideoSearchDataAccessInterface videoSearchDataAccessObject;

    final VideoSearchOutputBoundary videoPresenter;

    public VideoSearchInteractor(VideoSearchDataAccessInterface videoSearchDataAccessInterface,
                                 VideoSearchOutputBoundary videoSearchOutputBoundary) {
        this.videoSearchDataAccessObject = videoSearchDataAccessInterface;
        this.videoPresenter = videoSearchOutputBoundary;
    }


    @Override
    public void execute(VideoSearchInputData videoSearchInputData) throws GeneralSecurityException, IOException {

        if (videoSearchDataAccessObject.isInvalid(videoSearchInputData.getVideoId())) {
            videoPresenter.prepareFailView("Video ID does not exist.");
        } else {
            Video video = videoSearchDataAccessObject.getVideo(videoSearchInputData.getVideoId());

            VideoSearchOutputData videoSearchOutputData = new VideoSearchOutputData(video.getId(),
                                                                                    video.getChannelName(),
                                                                                    video.getTitle(),
                                                                                    video.getDescription(),
                                                                                    video.getVideoPublishDate(),
                                                                                    video.getViewCount(),
                                                                                    video.getLikeCount(),
                                                                                    video.getCommentCount(),
                                                                                false);

            // TODO video search output add toString method
            // videoSearchDataAccessObject.saveToCsv(videoSearchOutputData.toString());

            videoPresenter.prepareSuccessView(videoSearchOutputData);

        }
    }
}
