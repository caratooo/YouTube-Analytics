package use_case.compare_videos;

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

    }
}
