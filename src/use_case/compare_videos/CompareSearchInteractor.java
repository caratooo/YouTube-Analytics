package use_case.compare_videos;

import entities.Video;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CompareSearchInteractor implements CompareSearchInputBoundary {
    final CompareSearchDataAccessInterface compareSearchDataAccessObject;
    final CompareSearchOutputBoundary compareSearchPresenter;
    final CompareSearchUserDataAccessInterface compareSearchUserDataAccessInterface;

    public CompareSearchInteractor(CompareSearchDataAccessInterface compareSearchDataAccessObject, CompareSearchUserDataAccessInterface userDataAccessInterface, CompareSearchOutputBoundary compareSearchPresenter) {
        this.compareSearchDataAccessObject = compareSearchDataAccessObject;
        this.compareSearchUserDataAccessInterface = userDataAccessInterface;
        this.compareSearchPresenter = compareSearchPresenter;
    }

    @Override
    public void execute(CompareSearchInputData compareSearchInputData) throws GeneralSecurityException, IOException {
        if (compareSearchDataAccessObject.isInvalidTwo(compareSearchInputData.getVideoOneId(), compareSearchInputData.getVideoTwoId())){
            compareSearchPresenter.prepareFailView("Video ID does not exist");
        }else{
            Video videoOne = compareSearchDataAccessObject.getVideo(compareSearchInputData.getVideoOneId());
            Video videoTwo = compareSearchDataAccessObject.getVideo(compareSearchInputData.getVideoTwoId());
            CompareSearchOutputData compareSearchOutputData = new CompareSearchOutputData(videoOne.getId(),
                    videoOne.getChannelName(),
                    videoOne.getTitle(),
                    videoOne.getDescription(),
                    videoOne.getVideoPublishDate(),
                    videoOne.getViewCount(),
                    videoOne.getLikeCount(),
                    videoOne.getCommentCount(),
                    videoTwo.getId(),
                    videoTwo.getChannelName(),
                    videoTwo.getTitle(),
                    videoTwo.getDescription(),
                    videoTwo.getVideoPublishDate(),
                    videoTwo.getViewCount(),
                    videoTwo.getLikeCount(),
                    videoTwo.getCommentCount(),
                    false);

            compareSearchUserDataAccessInterface.saveUserHistory(compareSearchInputData.getUsername(), compareSearchOutputData.toString());
            compareSearchPresenter.prepareSuccessView(compareSearchOutputData);
        }
    }
}
