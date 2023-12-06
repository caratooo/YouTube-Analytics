package use_case.compare_videos;

import entities.Video;
import interface_adapter.compare_search.CompareSearchPresenter;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CompareSearchInteractor implements CompareSearchInputBoundary {
    final CompareSearchDataAccessInterface compareSearchDataAccessObject;
    final CompareSearchOutputBoundary compareSearchPresenter;

    public CompareSearchInteractor(CompareSearchDataAccessInterface compareSearchDataAccessObject, CompareSearchOutputBoundary compareSearchPresenter) {
        this.compareSearchDataAccessObject = compareSearchDataAccessObject;
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

            compareSearchPresenter.prepareSuccessView(compareSearchOutputData);
        }
    }
}
