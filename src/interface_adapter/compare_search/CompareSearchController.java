package interface_adapter.compare_search;

import use_case.compare_videos.CompareSearchInputBoundary;
import use_case.compare_videos.CompareSearchInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CompareSearchController {

    final CompareSearchInputBoundary compareSearchUseCaseInteractor;

    public CompareSearchController(CompareSearchInputBoundary compareSearchUseCaseInteractor) {
        this.compareSearchUseCaseInteractor = compareSearchUseCaseInteractor;
    }

    public void execute(String videoOneId, String videoTwoId)throws GeneralSecurityException, IOException {
        CompareSearchInputData compareSearchInputData = new CompareSearchInputData(videoOneId, videoTwoId);
        compareSearchUseCaseInteractor.execute(compareSearchInputData);
    }
}
