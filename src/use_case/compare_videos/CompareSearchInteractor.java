package use_case.compare_videos;

import interface_adapter.compare_search.CompareSearchPresenter;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CompareSearchInteractor implements CompareSearchInputBoundary {
    final CompareSearchDataAccessInterface videoSearchDataAccessObject;
    final CompareSearchPresenter compareSearchPresenter;

    public CompareSearchInteractor(CompareSearchDataAccessInterface videoSearchDataAccessObject, CompareSearchPresenter compareSearchPresenter) {
        this.videoSearchDataAccessObject = videoSearchDataAccessObject;
        this.compareSearchPresenter = compareSearchPresenter;
    }

    @Override
    public void execute(CompareSearchInputData compareSearchInputData) throws GeneralSecurityException, IOException {

    }
}
