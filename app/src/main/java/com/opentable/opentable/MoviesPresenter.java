package com.opentable.opentable;

public class MoviesPresenter implements MoviesContract.IMoviesPresenter {

    // region Class Members
    private MoviesContract.IMoviesView mMoviesView;
    // endregion

    // region Public Access
    public MoviesPresenter(MoviesContract.IMoviesView IMoviesView) {
        mMoviesView = IMoviesView;
        mMoviesView.initViews();
    }
    // endregion
}
